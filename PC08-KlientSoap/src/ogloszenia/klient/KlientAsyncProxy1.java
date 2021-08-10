package ogloszenia.klient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.Response;

import ogloszenia.wygenerowane_async.Samochodowe;
import ogloszenia.wygenerowane_async.OdczytajJednoOgloszenieResponse;
import ogloszenia.wygenerowane_async.SerwisOgloszeniowy;
import ogloszenia.wygenerowane_async.SerwisOgloszeniowyService;

/** Klient "wysokopoziomowy" ale jednocześnie asynchroniczny.
 *  Wykorzystywana jest alternatywna wersja wygenerowanych klas (z konfiguracją async-binding.xml).
 */
public class KlientAsyncProxy1 {

	public static void main(String[] args) {
		SerwisOgloszeniowyService serwis = new SerwisOgloszeniowyService();
		SerwisOgloszeniowy port = serwis.getSerwisOgloszeniowyPort();
		
		Response<OdczytajJednoOgloszenieResponse> response = port.odczytajJednoOgloszenieAsync(2);
		
		System.out.println("Zleciłem zapytanie");
		try {
			for(int i = 1; i <= 12; i++) {
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
			OdczytajJednoOgloszenieResponse wynik = response.get(10, TimeUnit.SECONDS);
			
			Samochodowe ogl = wynik.getOgloszenie();
			System.out.println("Odczytano ogloszenie id = " + ogl.getId());
			System.out.println(ogl.getOpis());

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
	}

}
