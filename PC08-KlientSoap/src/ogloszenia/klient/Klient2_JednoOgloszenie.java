package ogloszenia.klient;

import java.util.List;
import java.util.Scanner;

import ogloszenia.wygenerowane.BladBazyDanych_Exception;
import ogloszenia.wygenerowane.NieznanyRekord_Exception;
import ogloszenia.wygenerowane.Samochodowe;
import ogloszenia.wygenerowane.SerwisOgloszeniowy;
import ogloszenia.wygenerowane.SerwisOgloszeniowyService;

public class Klient2_JednoOgloszenie {

	public static void main(String[] args) {
		
		SerwisOgloszeniowyService service = new SerwisOgloszeniowyService();
		SerwisOgloszeniowy proxy = service.getSerwisOgloszeniowyPort();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Podaj id szukanego ogłoszenia: ");
			int id = sc.nextInt();
			if(id <= 0) break;
			
			try {
				Samochodowe ogl = proxy.odczytajJednoOgloszenie(id);
				System.out.printf("%s %s za %s\n", ogl.getMarka(), ogl.getModel(), ogl.getCena());
				System.out.println(ogl.getTytul());
				System.out.println(ogl.getOpis());
				
			} catch (NieznanyRekord_Exception e) {
				System.out.println(e.getMessage());
			} catch (BladBazyDanych_Exception e) {
				System.out.println("Inny błąd serwera: " + e);
			} catch (Exception e) {
				System.out.println("Inny błąd: " + e);
			}
		}
	}

}

// alt+Enter intellij  =~=   Ctrl+1 w eclipse

