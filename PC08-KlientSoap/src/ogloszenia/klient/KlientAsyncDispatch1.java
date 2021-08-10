package ogloszenia.klient;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
import javax.xml.ws.Response;
import javax.xml.ws.Service.Mode;

import ogloszenia.wygenerowane.SerwisOgloszeniowyService;

public class KlientAsyncDispatch1 {

	private static final QName PORT_NAME = new QName("http://soap.ogloszenia/", "SerwisOgloszeniowyPort");
	
	public static void main(String[] args) {
		System.out.println("Startujemy...");
		SerwisOgloszeniowyService serwis = new SerwisOgloszeniowyService();
		Dispatch<Source> dispatch = serwis.createDispatch(PORT_NAME, Source.class, Mode.PAYLOAD);

		StreamSource src = new StreamSource(new File("zapytanie1.xml"));
		
		Response<Source> response = dispatch.invokeAsync(src);
		System.out.println("Zleciłem zapytanie");
		try {
			for(int i = 1; i <= 100; i++) {
				if(response.isDone()) {
					System.out.println("Już gotowe!");
					break;
				} else {
					System.out.println("Jeszcze nie gotowe");
				}
				Thread.sleep(500);
			}
			System.out.println("Odczytuję wynik...");
			// Jeśli jeszcze nie gotowe, to get spowoduje oczekiwanie na wynik
			Source result = response.get(10, TimeUnit.SECONDS);
			//Source result = response.get();
			
			wypiszXmlZSource(result);
		} catch (InterruptedException e) {
			System.out.println("interrupted");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("execution exception");
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("timeout");
			e.printStackTrace();
		}
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
