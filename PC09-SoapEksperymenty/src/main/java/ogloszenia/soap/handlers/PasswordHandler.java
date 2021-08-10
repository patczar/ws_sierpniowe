package ogloszenia.soap.handlers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
Ten handler  wymaga wysyłąnia w zapytaniu nagłówka takiego jak
   	<soap:credentials user="ala" password="abc123"/>
wewnątrz <soapenv:Header>
 */


public class PasswordHandler implements SOAPHandler<SOAPMessageContext> {
	private static final String NS = "http://soap.ogloszenia/";
	private static final String HEADER_NAME = "credentials";
	final static QName CREDENTIALS_HEADER = new QName(NS, HEADER_NAME);
	
	final static Set<QName> zbiorNaglowkow = new HashSet<>();
	static {
		zbiorNaglowkow.add(CREDENTIALS_HEADER);
	}
	
	final static Map<String, String> hasla = new HashMap<>();
	static {
		hasla.put("ala", "abc123");
		hasla.put("monika", "TajneHaslo");
	}
	
	
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean wychodzaca = (Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(wychodzaca) {
			return true;
		}
		
		boolean wynik = false;
		
		try {
			SOAPMessage message = context.getMessage();
			SOAPHeader soapHeader = message.getSOAPHeader();
			if(soapHeader != null) {
				NodeList nodeList = soapHeader.getElementsByTagNameNS(NS, HEADER_NAME);
				if(nodeList.getLength() == 1) {
					Element credentials = (Element) nodeList.item(0);
					String user = credentials.getAttribute("user");
					String password = credentials.getAttribute("password");
					String hasloZBazy = hasla.get(user);
					if(hasloZBazy != null && hasloZBazy.equals(password)) {
						wynik = true;
					}
				}
			}
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		
		try {
			if(! wynik) {
				// nie zweryfikowano
				SOAPMessage message = MessageFactory.newInstance().createMessage();			
				QName qName = new QName(SOAPConstants.URI_NS_SOAP_ENVELOPE, "Client");
				message.getSOAPBody().addFault(qName, "Błąd uwierzytelnienia");
				context.setMessage(message);
			}
			
			return wynik;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return zbiorNaglowkow;
	}

}
