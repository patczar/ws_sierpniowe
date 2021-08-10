package sklep.soap;

import java.time.LocalDateTime;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class Hello12 {
	public String witaj(String imie) {
		return "Witaj " + imie;
	}
	
	@WebResult(name="czas")
	public String biezacyCzas() {
		return LocalDateTime.now().toString();
	}
	
	@WebResult(name="wynik")
	public int oblicz(
			@WebParam(name="x") int liczba1,
			@WebParam(name="y") int liczba2,
			@WebParam(name="operacja") String operacja) throws NieznanaOperacja {
		switch(operacja) {
		case "+" : return liczba1 + liczba2;
		case "-" : return liczba1 - liczba2;
		case "*" : return liczba1 * liczba2;
		case "/" : return liczba1 / liczba2;
		default: throw new NieznanaOperacja("Nieznana operacja " + operacja);
		}
	}

}
