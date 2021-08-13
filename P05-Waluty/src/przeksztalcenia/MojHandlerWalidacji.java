package przeksztalcenia;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MojHandlerWalidacji extends DefaultHandler {
	private List<Exception> listaBledow = new LinkedList<>();
	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// System.out.println("start " + qName);
	}
	
	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("WARNING " + e.getMessage());
	}
	
	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("ERROR " + e.getMessage());
		listaBledow.add(e);
	}
	
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("FATAL " + e.getMessage());
		listaBledow.add(e);
	}
	
	public boolean czyBylyBledy() {
		return ! listaBledow.isEmpty();
	}
	
	public String komunikat() {
		return listaBledow.stream()
				.map(Exception::getMessage)
				.collect(Collectors.joining("\n"));
	}
	
	
}
