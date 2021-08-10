package waluty.implementacja;

import javax.jws.WebService;
import javax.xml.bind.JAXBException;

import waluty.model.ArrayOfExchangeRatesTable;
import waluty.model.ExchangeRatesTable;
import waluty.pobieranie.BrakDanych;
import waluty.pobieranie.ImplementacjaPobieraniaJAXB;
import waluty.wygenerowane.Waluty;

@WebService(endpointInterface = "waluty.wygenerowane.Waluty")
public class WalutyService implements Waluty {
	
	private ImplementacjaPobieraniaJAXB implementacjaPobieraniaJAXB;
	
	public WalutyService() {
		try {
			implementacjaPobieraniaJAXB = new ImplementacjaPobieraniaJAXB();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ExchangeRatesTable pobierzBiezaceKursy() throws BrakDanych {
		ArrayOfExchangeRatesTable array = implementacjaPobieraniaJAXB.pobierzBiezaceKursy("A");
		return array.getTables().get(0);
	}

	@Override
	public ExchangeRatesTable pobierzTabeleDlaDaty(String data) throws BrakDanych {
		ArrayOfExchangeRatesTable array = implementacjaPobieraniaJAXB.pobierzKursyHistoryczne("A", data);
		return array.getTables().get(0);
	}

	@Override
	public ArrayOfExchangeRatesTable pobierzPrzedzial(String poczatek, String koniec, String tabela) throws BrakDanych {
		return implementacjaPobieraniaJAXB.pobierzPrzedzial(tabela, poczatek, koniec);
	}

}
