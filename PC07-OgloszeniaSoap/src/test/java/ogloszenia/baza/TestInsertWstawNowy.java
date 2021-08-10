package ogloszenia.baza;

import java.time.LocalTime;

import ogloszenia.baza.DostepDoBazy;
import ogloszenia.baza.OgloszeniaDAO;
import ogloszenia.exn.BladAplikacji;
import ogloszenia.model.Samochodowe;

public class TestInsertWstawNowy {

	public static void main(String[] args) {
		try(DostepDoBazy baza = new DostepDoBazy()) {
			
			OgloszeniaDAO dao = baza.ogloszeniaDAO();
			Samochodowe auto = dao.odczytajWgId(3);
			
			auto.setIdOgloszenia(null);
			auto.setWystawione(null);
			auto.setOpis("Nowy z godziny " + LocalTime.now());
			
			dao.zapisz(auto);
			
		} catch (BladAplikacji e) {
			e.printStackTrace();
		}
	}
}
