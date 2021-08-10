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

public class KlientAsyncDispatch2 {

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
				
		try {
			Future<?> response = dispatch.invokeAsync(src, callback);
			System.out.println("Zleciłem zapytanie");
			for(int i = 1; i <= 100; i++) {
				if(response.isDone()) {
					System.out.println("Już gotowe!");
					break;
				} else {
					System.out.println("Jeszcze nie gotowe");
				}
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			System.out.println("interrupted");
			e.printStackTrace();
		}
		System.out.println("Koniec main-a");
		// Jeśli program dojdzie do końca, a zlecone zapytanie jeszcze się niw wykonało, to zapominamy o nim (callback się nie wykona)
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
