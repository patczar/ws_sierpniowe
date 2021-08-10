package ogloszenia.soap.handlers;

import java.time.LocalTime;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class InfoHandler implements SOAPHandler<SOAPMessageContext> {
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean wychodzaca = (Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
		String jaka = wychodzaca ? "out" : "in";
		
		System.out.println("A handleMessage " + jaka);
		SOAPMessage message = context.getMessage();

		QName operacja = (QName)context.get(SOAPMessageContext.WSDL_OPERATION);
		System.out.println("operacja: " + operacja);
		
        HttpServletRequest req = (HttpServletRequest) context.get(SOAPMessageContext.SERVLET_REQUEST);
        System.out.println("  adres klienta: " + req.getLocalAddr());
		
		// dopisanie nagłówka czas:
		if(wychodzaca) {
			try {
				SOAPHeader soapHeader = message.getSOAPHeader();
				if(soapHeader != null) {
					SOAPHeaderElement nowyNaglowek = soapHeader.
						addHeaderElement(new QName("http://nasze_szkolenie.com/naglowki", "czas"));
					nowyNaglowek.setTextContent(LocalTime.now().toString());
				}
			} catch (SOAPException e) {
				e.printStackTrace();
			}
		}
					
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("A handleFault");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("A close");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("A headers");
		return null;
	}
}
