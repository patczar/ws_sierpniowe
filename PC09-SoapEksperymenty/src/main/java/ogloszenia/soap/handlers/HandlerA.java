package ogloszenia.soap.handlers;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

public class HandlerA implements LogicalHandler<LogicalMessageContext> {
	public boolean handleMessage(LogicalMessageContext context) {
		System.out.println("A handleMessage");
		return true;
	}

	public boolean handleFault(LogicalMessageContext context) {
		System.out.println("A handleFault");
		return false;
	}

	public void close(MessageContext context) {
		System.out.println("A close");
	}

}
