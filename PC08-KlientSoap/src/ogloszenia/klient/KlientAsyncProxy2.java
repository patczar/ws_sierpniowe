package ogloszenia.klient;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;

import ogloszenia.wygenerowane_async.Samochodowe;
import ogloszenia.wygenerowane_async.OdczytajJednoOgloszenieResponse;
import ogloszenia.wygenerowane_async.SerwisOgloszeniowy;
import ogloszenia.wygenerowane_async.SerwisOgloszeniowyService;


/** Klient "wysokopoziomowy" ale jednocześnie asynchroniczny.
 *  Wykorzystywana jest alternatywna wersja wygenerowanych klas (z konfiguracją async-binding.xml).
 *  Wersja z callbackiem (handlerem).
 */
public class KlientAsyncProxy2 {

	public static void main(String[] args) {
		SerwisOgloszeniowyService serwis = new SerwisOgloszeniowyService();
		SerwisOgloszeniowy port = serwis.getSerwisOgloszeniowyPort();
		
		
		AsyncHandler<OdczytajJednoOgloszenieResponse> handler = response -> {
			try {
				Samochodowe ogl = response.get().getOgloszenie();
				System.out.println("Przyszła odpowiedź:");
				System.out.println(ogl.getMarka() + " " + ogl.getModel());
				System.out.println(ogl.getTytul());
				System.out.println(ogl.getCena());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
		};
		
		port.odczytajJednoOgloszenieAsync(2, handler);
		
		System.out.println("Zleciłem zapytanie");
		try {
			for(int i = 1; i <= 20; i++) {
				System.out.println("lalala");
				Thread.sleep(500);
			}

		} catch (InterruptedException e) {
			System.out.println("interrupted");
			e.printStackTrace();
		}
	}

}
