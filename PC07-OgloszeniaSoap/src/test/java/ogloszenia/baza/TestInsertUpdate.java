package ogloszenia.baza;

import ogloszenia.baza.DostepDoBazy;
import ogloszenia.baza.OgloszeniaDAO;
import ogloszenia.exn.BladAplikacji;
import ogloszenia.model.Samochodowe;

public class TestInsertUpdate {

	public static void main(String[] args) {
		try(DostepDoBazy baza = new DostepDoBazy()) {
			
			OgloszeniaDAO dao = baza.ogloszeniaDAO();
			Samochodowe auto = dao.odczytajWgId(3);
			
			auto.setIdOgloszenia(103);
			auto.setOpis("Opis złotego Matiza");
			
			dao.zapisz(auto);
			
		} catch (BladAplikacji e) {
			e.printStackTrace();
		}
	}
}
