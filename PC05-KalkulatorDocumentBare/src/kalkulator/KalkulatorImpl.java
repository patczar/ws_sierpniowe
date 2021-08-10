package kalkulator;


import javax.jws.WebService;

@WebService(serviceName = "Kalkulator",
	portName = "KalkulatorSOAP",
	wsdlLocation = "/WEB-INF/wsdl/KalkulatorBare.wsdl",
	endpointInterface = "kalkulator.Kalkulator",
	targetNamespace = "http://www.example.org/Kalkulator/")
public class KalkulatorImpl implements Kalkulator {
	// w stylu BARE parametr i wynik nie są dodatkowo opakowywane, muszą opakować się same
	// każda operacja musi mieć jeden parametr wejściowy, a ich typy (klasy) muszą być unikalne - aby dla każdego był generowany inny element xml
	
	public IncOutput inc(IncInput parameters) {
		IncOutput wynik = new IncOutput();
		wynik.setResult(parameters.getArg() + 1);
		return wynik;
	}
	
	public AddOutput add(AddInput parameters) {
		AddOutput wynik = new AddOutput();
		wynik.setResult(parameters.getArg1() + parameters.getArg2());
		return wynik;
	}

	public SubOutput sub(SubInput parameters) {
		SubOutput wynik = new SubOutput();
		wynik.setResult(parameters.getArg1() - parameters.getArg2());
		return wynik;
	}
	
	public MulOutput mul(MulInput parameters) {
		MulOutput wynik = new MulOutput();
		wynik.setResult(parameters.getArg1() * parameters.getArg2());
		return wynik;
	}

	public DivOutput div(DivInput parameters) {
		DivOutput wynik = new DivOutput();
		wynik.setQuotient(parameters.getArg1() / parameters.getArg2());
		wynik.setRest(parameters.getArg1() % parameters.getArg2());
		return wynik;
	}

	public AvgOutput avg(AvgInput parameters) {
		float suma = 0;
		int licznik = 0;
		for (int x : parameters.getArg()) {
			suma += x;
			licznik++;
		}
		
		AvgOutput wynik = new AvgOutput();
		wynik.result = suma / licznik;
		return wynik;
	}

}