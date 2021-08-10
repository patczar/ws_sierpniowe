package ogloszenia.klient;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
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
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service.Mode;

import ogloszenia.wygenerowane.SerwisOgloszeniowyService;

public class KlientAsyncDispatch2a {

	private static final QName PORT_NAME = new QName("http://soap.ogloszenia/", "SerwisOgloszeniowyPort");
	
	public static void main(String[] args) {
		SerwisOgloszeniowyService serwis = new SerwisOgloszeniowyService();
		Dispatch<Source> dispatch = serwis.createDispatch(PORT_NAME, Source.class, Mode.PAYLOAD);

		StreamSource src = new StreamSource(new File("zapytanie1.xml"));
		
		AsyncHandler<Source> callback = response -> {
			try {
				System.out.println("callback wykonywany jest w wątku nr " + Thread.currentThread().getId());
				wypiszXmlZSource(response.get());
				System.out.println();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		};
				
		dispatch.invokeAsync(src, callback);
		System.out.println("Zleciłem zapytanie. Nie czekam, idę dalej");
		
		try {
			// tutaj sleep, ale program mógłby dalej działać...
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
		}
		
			
		System.out.println("Koniec main-a");
		// Jeśli program dojdzie do końca, a zlecone zapytanie jeszcze się nie wykonało, to zapominamy o nim (callback się nie wykona)
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
