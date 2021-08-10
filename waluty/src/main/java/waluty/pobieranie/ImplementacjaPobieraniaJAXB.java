package waluty.pobieranie;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import waluty.model.ArrayOfExchangeRatesTable;

public class ImplementacjaPobieraniaJAXB {
	private static final String ADRES = "http://api.nbp.pl/api/exchangerates/tables";
	
	private JAXBContext jaxbContext;
	
	public ImplementacjaPobieraniaJAXB() throws JAXBException {
		jaxbContext = JAXBContext.newInstance(ArrayOfExchangeRatesTable.class);
	}

	/** Pobiera tabelę z bieżącymi kursami walut.
	 * @throws BrakDanych 
	 */
	public ArrayOfExchangeRatesTable pobierzBiezaceKursy(String tabela) throws BrakDanych {
		if(tabela == null) {
			tabela = "A";
		}
		return wczytajXmlZAdresu(ADRES + "/" + tabela + "?format=xml");
	}
	
	/** Pobiera tabelę z archiwalnymi kursami walut z określonej daty.
	 * @throws BrakDanych 
	 */
	public ArrayOfExchangeRatesTable pobierzKursyHistoryczne(String tabela, String data) throws BrakDanych {
		if(tabela == null) {
			tabela = "A";
		}
		return wczytajXmlZAdresu(ADRES + "/" + tabela + "/" + data + "?format=xml");
	}

	/** Pobiera listę tabel z archiwalnymi kursami walut z określonego przedziału dat.
	 * @throws BrakDanych 
	 */
	public ArrayOfExchangeRatesTable pobierzPrzedzial(String tabela, String data1, String data2) throws BrakDanych {
		if(tabela == null) {
			tabela = "A";
		}
		return wczytajXmlZAdresu(ADRES + "/" + tabela + "/" + data1 + "/" + data2 + "?format=xml");
	}

	private ArrayOfExchangeRatesTable wczytajXmlZAdresu(String adres) throws BrakDanych {
		try {
			URL url = new URL(adres);
			try (InputStream in = url.openStream()) {
				Unmarshaller u = jaxbContext.createUnmarshaller();
				return (ArrayOfExchangeRatesTable) u.unmarshal(in);
			}
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
			throw new BrakDanych("Problem z pobraniem tabeli z adresu " + adres, e);
		}
	}
}