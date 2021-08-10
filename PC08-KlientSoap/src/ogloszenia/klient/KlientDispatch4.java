package ogloszenia.klient;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

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
import javax.xml.ws.Service.Mode;

public class KlientDispatch4 {
	
	/* W tym przykładzie nie używamy wygenerowanych klas, to można zrobić "zawsze", nawet bez procedury wsimport
	 * 
	 * Tu pokazujemy zastosowanie klienta niskopoziomowego: wynikowy XML jest przetwarzany za pomocą arkusza XSLT.
	 */

	private static final QName PORT_NAME = new QName("http://soap.ogloszenia/", "SerwisOgloszeniowyPort");
	private static final QName SERVICE_NAME = new QName("http://soap.ogloszenia/", "SerwisOgloszeniowyService");
	private static final String WSDL = "http://localhost:8080/PC07-OgloszeniaSoap-1.0/SerwisOgloszeniowy?wsdl";
	
	public static void main(String[] args) {
		try {
			final URL WSDL_URL = new URL(WSDL);
			Service serwis = Service.create(WSDL_URL, SERVICE_NAME);
			
			Dispatch<Source> dispatch = serwis.createDispatch(PORT_NAME, Source.class, Mode.PAYLOAD);

			StreamSource src = new StreamSource(new File("zapytanie1.xml"));
			Source result = dispatch.invoke(src);
			przeksztalcXml(result);
			System.out.println("\n\nGotowe");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	static void przeksztalcXml(Source xml) {
		try {
			StreamSource xsl = new StreamSource(new File("arkusz.xsl"));
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer(xsl);
			StreamResult res = new StreamResult(new File("wynik4.html"));
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
