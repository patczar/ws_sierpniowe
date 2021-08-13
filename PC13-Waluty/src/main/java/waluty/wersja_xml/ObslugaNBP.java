package waluty.wersja_xml;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ObslugaNBP {
	private static final String ADRES = "http://api.nbp.pl/api/exchangerates/tables";

	/** Pobiera tabelę z bieżącymi kursami walut.
	 * Zwraca null w przypadku błędów.
	 */
	public static Tabela pobierzBiezaceKursy() {
		Document doc = wczytajXmlZAdresu(ADRES + "/A?format=xml");
		return tabelaZXml(doc);
	}
	
	/** Pobiera tabelę z archiwalnymi kursami walut z określonej daty.
	 * Zwraca null w przypadku błędów, np. wtedy, gdy dla danej daty nie istnieje tabela.
	 */
	public static Tabela pobierzKursyHistoryczne(String data) {
		Document doc = wczytajXmlZAdresu(ADRES + "/A/" + data + "?format=xml");
		return tabelaZXml(doc);
	}

	private static Document wczytajXmlZAdresu(String adres) {
		// Document Object Model
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			URL url = new URL(adres);
			try (InputStream in = url.openStream()) {
				return db.parse(in);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Tabela tabelaZXml(Document doc) {
		if (doc == null)
			return null;
		try {
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xpath = xpf.newXPath();

			// String numer = xpath.evaluate(
			// "/ArrayOfExchangeRatesTable/ExchangeRatesTable/No", doc);

			String nazwaTabeli = xpath.evaluate("//Table", doc);
			String numerTabeli = xpath.evaluate("//No", doc);
			LocalDate data = LocalDate.parse(xpath.evaluate("//EffectiveDate", doc));

			Tabela tabela = new Tabela(nazwaTabeli, numerTabeli, data);

			NodeList rates = (NodeList) xpath.evaluate("//Rate", doc, XPathConstants.NODESET);
			final int n = rates.getLength();
			for (int i = 0; i < n; i++) {
				Node rate = rates.item(i);
				String kod = xpath.evaluate("Code", rate);
				String nazwa = xpath.evaluate("Currency", rate);
				String kurs = xpath.evaluate("Mid", rate);
				BigDecimal kursBD = new BigDecimal(kurs);
				Waluta waluta = new Waluta(kod, nazwa, kursBD);
				tabela.dodaj(waluta);
			}

			return tabela;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			return null;
		}
	}
}