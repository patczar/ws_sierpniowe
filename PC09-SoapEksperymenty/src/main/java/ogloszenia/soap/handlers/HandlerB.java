package ogloszenia.soap.handlers;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HandlerB implements SOAPHandler<SOAPMessageContext> {
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("B handleMessage");
		return true;
	}

	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("B handleFault");
		return false;
	}

	public void close(MessageContext context) {
		System.out.println("B close");
	}

	public Set<QName> getHeaders() {
		System.out.println("B headers");
		return null;
	}
}
