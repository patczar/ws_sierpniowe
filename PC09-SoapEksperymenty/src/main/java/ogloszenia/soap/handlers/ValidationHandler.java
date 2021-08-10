package ogloszenia.soap.handlers;

import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Node;
/*
 * Ten Handler dokonuje walidacji względem XML Schema i dopisuje do odpowiedzi nagłówek czas
 */
public class ValidationHandler implements SOAPHandler<SOAPMessageContext> {
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean wychodzaca = (Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);

		try {
			SOAPMessage message = context.getMessage();
						
			// walidacja wzgl. schemy
			SOAPBody soapBody = message.getSOAPBody();
			Node elementZapytania = null;
			for(Node nd = soapBody.getFirstChild();
				nd != null; nd = nd.getNextSibling()) {
				
				if(nd.getNodeType() == Node.ELEMENT_NODE) {
					elementZapytania = nd;
				}
			}
			if (elementZapytania != null) {
				ServletContext servletContext = (ServletContext) context.get(SOAPMessageContext.SERVLET_CONTEXT);
				try (InputStream input = servletContext.getResourceAsStream("WEB-INF/ogloszenia.xsd")) {
					Source xsdSource = new StreamSource(input);
					Walidacja walidacja = new Walidacja(xsdSource);
					walidacja.waliduj(elementZapytania);

					if (walidacja.bylyBledy()) {
						System.out.println("Błędy walidacji " + walidacja.getBledy());
						String winny = wychodzaca ? "Server" : "Client";

						soapBody.removeChild(elementZapytania);
						Name qname = SOAPFactory.newInstance().createName(winny, null,
								SOAPConstants.URI_NS_SOAP_ENVELOPE);
						SOAPFault fault = soapBody.addFault();
						fault.setFaultCode(qname);
						fault.setFaultString("Błędy walidacji po stronie " + winny + ": " + walidacja.getBledy());
						return false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}
}
