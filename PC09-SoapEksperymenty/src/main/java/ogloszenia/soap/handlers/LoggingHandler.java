package ogloszenia.soap.handlers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean wychodzaca = (Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
		String jaka = wychodzaca ? "out" : "in";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String nazwa = sdf.format(new Date()) + "_" + jaka + ".xml";

		String katalog_log = "/home/patryk/ogloszenia/logs/";
		
		SOAPMessage message = context.getMessage();
		
		try(FileOutputStream out = new FileOutputStream(katalog_log + nazwa)) {
			message.writeTo(out);
		} catch (SOAPException | IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	public void close(MessageContext context) {
	}

	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}
}
