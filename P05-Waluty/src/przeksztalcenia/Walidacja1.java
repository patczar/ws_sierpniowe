package przeksztalcenia;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Walidacja1 {

	public static void main(String[] args) {
		System.out.println("Przygotowania...");
		String xml = "waluty_2017f.xml";
		File xsd = new File("waluty.xsd");
		
		InputSource src = new InputSource(xml);
		StreamSource xsdSource = new StreamSource(xsd);
		
		// Walidacja podczas parsowania
		
		try {
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(xsdSource);
			
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setSchema(schema);
			
			SAXParser parser = spf.newSAXParser();
			
			MojHandlerWalidacji handler = new MojHandlerWalidacji();
			
			parser.parse(src, handler);
			
			System.out.println("Sparsowane");
			
			if(handler.czyBylyBledy()) {
				System.out.println("Były błędy:");
				System.out.println(handler.komunikat());
			} else {
				System.out.println("Nie było błędów");
			}
			
		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
