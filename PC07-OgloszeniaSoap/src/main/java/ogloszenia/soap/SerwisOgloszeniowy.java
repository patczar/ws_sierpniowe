package ogloszenia.soap;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import ogloszenia.baza.DostepDoBazy;
import ogloszenia.baza.OgloszeniaDAO;
import ogloszenia.exn.BladBazyDanych;
import ogloszenia.exn.NieznanyRekord;
import ogloszenia.model.Samochodowe;
import ogloszenia.util.FotoUtil;

@WebService
//@MTOM
public class SerwisOgloszeniowy {
	@WebResult(name="ogloszenie")
	public List<Samochodowe> odczytajWszystkieOgloszenia() throws BladBazyDanych {
		try(DostepDoBazy db = new DostepDoBazy()) {
			OgloszeniaDAO dao = db.ogloszeniaDAO();
			return dao.odczytajWszystkie();
		}
	}
	
	@WebResult(name="ogloszenie")
	@WebMethod(operationName="odczytajJednoOgloszenie", action="http://ogloszenia.com/jedno")
	public Samochodowe odczytajOgloszenieWgId(@WebParam(name="id") int idOgloszenia) throws BladBazyDanych, NieznanyRekord {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		if(idOgloszenia == 13) {
			throw new RuntimeException("Pechowa trzynastka");
		}
		
		try(DostepDoBazy db = new DostepDoBazy()) {
			OgloszeniaDAO dao = db.ogloszeniaDAO();
			return dao.odczytajWgId(idOgloszenia);
		}
	}
	
	@WebResult(name="ogloszenie")
	public List<Samochodowe> odczytajOgloszeniaWedlugCeny(
				@WebParam(name="min") BigDecimal min,
				@WebParam(name="max") BigDecimal max
			) throws BladBazyDanych {
		try(DostepDoBazy db = new DostepDoBazy()) {
			OgloszeniaDAO dao = db.ogloszeniaDAO();
			return dao.odczytajWedlugCeny(min, max);
		}
	}
	
	public void zapiszOgloszenie(
			@WebParam(name="ogloszenie") Samochodowe ogloszenie) throws BladBazyDanych {
		try(DostepDoBazy db = new DostepDoBazy()) {
			OgloszeniaDAO dao = db.ogloszeniaDAO();
			dao.zapisz(ogloszenie);
		}
	}
	
	// W tej wersji wersji serwer odsyła ID ogłoszenia - jeśli było utworzone jako nowe, to dzięki temu klient będzie znał ID.
	public Integer zapiszOgloszenie2(
			@WebParam(name="ogloszenie") Samochodowe ogloszenie) throws BladBazyDanych {
		try(DostepDoBazy db = new DostepDoBazy()) {
			OgloszeniaDAO dao = db.ogloszeniaDAO();
			dao.zapisz(ogloszenie);
			return ogloszenie.getIdOgloszenia();
		}
	}
	
	// W tej wersji serwer odsyła uzupełniony obiekt ogłoszenia.
	// Dopisane mogą być id oraz data wystawienia.
	public Samochodowe zapiszOgloszenie3(
			@WebParam(name="ogloszenie") Samochodowe ogloszenie) throws BladBazyDanych {
		try(DostepDoBazy db = new DostepDoBazy()) {
			OgloszeniaDAO dao = db.ogloszeniaDAO();
			dao.zapisz(ogloszenie);
			return ogloszenie;
		}
	}
	
	public byte[] foto(@WebParam(name="id") int idOgloszenia) throws NieznanyRekord {
		return FotoUtil.wczytajFoto(idOgloszenia);
		// JAXB konwertuje tablicę bajtów do formatu base64
		// Jeśli w tej klasie dodamy adnotację @MTOM, to zamiast tego dane binarne zostaną zapisane w załączniku
	}
	
}

