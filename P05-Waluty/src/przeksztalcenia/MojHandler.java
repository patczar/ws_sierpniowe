package przeksztalcenia;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MojHandler extends DefaultHandler {

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
	}
	
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("FATAL " + e.getMessage());
	}
	
	
}
