package ogloszenia.soap.handlers;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class Handler_Odrzucajacy_Wszystko implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("Handler Odrzucający :)");
		
		try {
			SOAPMessage message = MessageFactory.newInstance().createMessage();			
			
			QName qName = new QName(SOAPConstants.URI_NS_SOAP_ENVELOPE, "Client");
			message.getSOAPBody().addFault(qName, "nie rozumieć");

			context.setMessage(message);
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
