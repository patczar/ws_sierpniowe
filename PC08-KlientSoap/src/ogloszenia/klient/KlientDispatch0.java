package ogloszenia.klient;

import java.io.StringReader;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import ogloszenia.wygenerowane.SerwisOgloszeniowyService;

/* W tej wersji czytamy zapytanie XML ze Stringa, wynim wypisujemy na konsolę. */
public class KlientDispatch0 {
	
	static void wypiszXmlZSource(Source xml) {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			StreamResult res = new StreamResult(System.out);
			t.transform(xml, res);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Startujemy");
		QName portName = new QName("http://soap.ogloszenia/", "SerwisOgloszeniowyPort");
		
		SerwisOgloszeniowyService serwis = new SerwisOgloszeniowyService();
		
		Dispatch<Source> dispatch = serwis.createDispatch(portName, Source.class, Service.Mode.PAYLOAD);

		System.out.println("Wysyłam zapytanie");
		
		String trescZapytania = "<ns:odczytajJednoOgloszenie xmlns:ns='http://soap.ogloszenia/'>" + 
				"<id>1</id>" + 
				"</ns:odczytajJednoOgloszenie>";
		
		Source src = new StreamSource(new StringReader(trescZapytania));
		Source wynik = dispatch.invoke(src);		
		System.out.println("Przyszła odpowiedź");
		wypiszXmlZSource(wynik);
		System.out.println("\n\nGotowe");
	}

}
