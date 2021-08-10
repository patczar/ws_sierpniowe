package ogloszenia.klient;

import java.util.List;

import ogloszenia.wygenerowane.BladBazyDanych_Exception;
import ogloszenia.wygenerowane.Samochodowe;
import ogloszenia.wygenerowane.SerwisOgloszeniowy;
import ogloszenia.wygenerowane.SerwisOgloszeniowyService;

public class Klient1_WszystkieOgloszenia {

	public static void main(String[] args) {
		
		SerwisOgloszeniowyService service = new SerwisOgloszeniowyService();
		SerwisOgloszeniowy proxy = service.getSerwisOgloszeniowyPort();
		
		try {
			List<Samochodowe> lista = proxy.odczytajWszystkieOgloszenia();
			System.out.println("Odczytano " + lista.size() + " ogłoszeń:");
			
			for (Samochodowe ogl : lista) {
				// System.out.println(ogl);
				System.out.printf("%s %s za %s\n", ogl.getMarka(), ogl.getModel(), ogl.getCena());
			}
			
		} catch (BladBazyDanych_Exception e) {
			e.printStackTrace();
		}
	}

}

// alt+Enter intellij  =~=   Ctrl+1 w eclipse

