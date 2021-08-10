package ogloszenia.klient;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
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

import ogloszenia.wygenerowane.OdczytajJednoOgloszenie;
import ogloszenia.wygenerowane.SerwisOgloszeniowyService;

public class KlientDispatch5 {

	/*
	 * Tutaj zapytanie utworzymy z obiektów (JAXB), a wynik uzyskamy jako XML i przetworzymy.
	 */

	private static final QName PORT_NAME = new QName("http://soap.ogloszenia/", "SerwisOgloszeniowyPort");

	public static void main(String[] args) {
		SerwisOgloszeniowyService serwis = new SerwisOgloszeniowyService();
		Dispatch<Source> dispatch = serwis.createDispatch(PORT_NAME, Source.class, Mode.PAYLOAD);

		OdczytajJednoOgloszenie zapytanie = new OdczytajJednoOgloszenie();
		zapytanie.setId(3);
		
		try {
			JAXBContext ctx = JAXBContext.newInstance(OdczytajJednoOgloszenie.class);
			JAXBSource src = new JAXBSource(ctx, zapytanie);

			Source result = dispatch.invoke(src);

			przeksztalcXml(result);
			System.out.println("\n\nGotowe");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	static void przeksztalcXml(Source xml) {
		try {
			StreamSource xsl = new StreamSource(new File("arkusz.xsl"));
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer(xsl);
			StreamResult res = new StreamResult(new File("wynik5.html"));
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
