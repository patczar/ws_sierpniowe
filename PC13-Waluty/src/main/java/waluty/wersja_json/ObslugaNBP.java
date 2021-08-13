package waluty.wersja_json;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class ObslugaNBP {
	private static final String ADRES = "http://api.nbp.pl/api/exchangerates/tables";

	/**
	 * Pobiera tabelę z bieżącymi kursami walut. Zwraca null w przypadku błędów.
	 */
	public static Tabela pobierzBiezaceKursy() {
		return wczytajZAdresu(ADRES + "/A?format=json");
	}

	public static Tabela pobierzKursyHistoryczne(String data) {
		return wczytajZAdresu(ADRES + "/A/" + data + "?format=json");
	}

	private static Tabela wczytajZAdresu(String adres) {
		try {
			URL url = new URL(adres);
			try (InputStream in = url.openStream()) {
				JsonReader reader = Json.createReader(in);
				JsonArray array = reader.readArray();
				JsonObject jo_tabela = array.getJsonObject(0);

				String nazwaTabeli = jo_tabela.getString("table");
				String numerTabeli = jo_tabela.getString("no");
				LocalDate data = LocalDate.parse(jo_tabela.getString("effectiveDate"));

				Tabela tabela = new Tabela(nazwaTabeli, numerTabeli, data);
				JsonArray rates = jo_tabela.getJsonArray("rates");
				for (JsonValue jsonValue : rates) {
					JsonObject walutaJSON = (JsonObject) jsonValue;
					String kod = walutaJSON.getString("code");
					String nazwa = walutaJSON.getString("currency");
					BigDecimal kurs = walutaJSON.getJsonNumber("mid").bigDecimalValue();
					Waluta waluta = new Waluta(kod, nazwa, kurs);
					tabela.dodaj(waluta);
				}
				return tabela;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
