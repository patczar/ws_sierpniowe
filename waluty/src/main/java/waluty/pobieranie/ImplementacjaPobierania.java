package waluty.pobieranie;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ImplementacjaPobierania {
	private static final String ADRES = "http://api.nbp.pl/api/exchangerates/tables";

	/** Pobiera tabelę z bieżącymi kursami walut.
	 * @throws BrakDanych 
	 */
	public static Document pobierzBiezaceKursy(String tabela) throws BrakDanych {
		if(tabela == null) {
			tabela = "A";
		}
		return wczytajXmlZAdresu(ADRES + "/" + tabela + "?format=xml");
	}
	
	/** Pobiera tabelę z archiwalnymi kursami walut z określonej daty.
	 * @throws BrakDanych 
	 */
	public static Document pobierzKursyHistoryczne(String tabela, String data) throws BrakDanych {
		if(tabela == null) {
			tabela = "A";
		}
		return wczytajXmlZAdresu(ADRES + "/" + tabela + "/" + data + "?format=xml");
	}

	/** Pobiera listę tabel z archiwalnymi kursami walut z określonego przedziału dat.
	 * @throws BrakDanych 
	 */
	public static Document pobierzPRzedzial(String tabela, String data1, String data2) throws BrakDanych {
		if(tabela == null) {
			tabela = "A";
		}
		return wczytajXmlZAdresu(ADRES + "/" + tabela + "/" + data1 + "/" + data2 + "?format=xml");
	}

	private static Document wczytajXmlZAdresu(String adres) throws BrakDanych {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			URL url = new URL(adres);
			try (InputStream in = url.openStream()) {
				return db.parse(in);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			throw new BrakDanych("Problem z pobraniem tabeli z adresu " + adres, e);
		}
	}
}