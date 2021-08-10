package ogloszenia.klient;

import java.io.File;

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
import javax.xml.ws.Service.Mode;

import ogloszenia.wygenerowane.SerwisOgloszeniowyService;

/* W tej wersji XML zapytania wczytujemy z pliku.
 * Nadal korzystamy z wygenerowanej klasy SerwisOgloszeniowyService, co ułatwia uzyskanie dostępu.
 */
public class KlientDispatch2 {

	private static final QName PORT_NAME = new QName("http://soap.ogloszenia/", "SerwisOgloszeniowyPort");
	
	public static void main(String[] args) {
		SerwisOgloszeniowyService serwis = new SerwisOgloszeniowyService();
		
		Dispatch<Source> dispatch = serwis.createDispatch(PORT_NAME, Source.class, Mode.MESSAGE);

		StreamSource src = new StreamSource(new File("zapytanie2.xml"));
		Source result = dispatch.invoke(src);
		wypiszXmlZSource(result);
		System.out.println("\n\nGotowe");
	}
	
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
}
