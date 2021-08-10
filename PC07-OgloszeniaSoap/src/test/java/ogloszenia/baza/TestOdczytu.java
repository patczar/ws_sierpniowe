package ogloszenia.baza;

import java.util.List;

import ogloszenia.exn.BladBazyDanych;
import ogloszenia.model.Samochodowe;

public class TestOdczytu {

    public static void main(String[] args) {
        try(DostepDoBazy db = new DostepDoBazy()) {

            OgloszeniaDAO dao = db.ogloszeniaDAO();

            List<Samochodowe> ogloszenia = dao.odczytajWszystkie();

            for (Samochodowe ogl : ogloszenia) {
                System.out.println(ogl);
            }
        } catch (BladBazyDanych e) {
            e.printStackTrace();
        }
    }
}
