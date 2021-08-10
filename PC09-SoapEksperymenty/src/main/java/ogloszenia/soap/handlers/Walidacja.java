package ogloszenia.soap.handlers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

class Walidacja {
	private Source schemaSource;
	private boolean bylyBledy = false;
	private List<String> bledy = new LinkedList<>();
	
	public Walidacja(Source schemaSource) {
		this.schemaSource = schemaSource;
	}
	
	public void waliduj(Node dokument) {
		Source src = new DOMSource(dokument);
		
		try {
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(schemaSource);
			Validator validator = schema.newValidator();
			validator.setErrorHandler(new WalidacjaErrorHandler());
			validator.validate(src);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean bylyBledy() {
		return bylyBledy;
	}

	public List<String> getBledy() {
		return bledy;
	}

	private class WalidacjaErrorHandler implements ErrorHandler {
		public void warning(SAXParseException e) throws SAXException {
			bledy.add(e.getMessage());
		}
		public void error(SAXParseException e) throws SAXException {
			bylyBledy = true;
			bledy.add(e.getMessage());
		}

		public void fatalError(SAXParseException e) throws SAXException {
			bylyBledy = true;
			bledy.add(e.getMessage());
		}
	}	
}
