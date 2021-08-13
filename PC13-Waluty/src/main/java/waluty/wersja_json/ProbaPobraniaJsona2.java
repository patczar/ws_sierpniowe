package waluty.wersja_json;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class ProbaPobraniaJsona2 {
	private static final String ADRES = "http://api.nbp.pl/api/exchangerates/tables";

	public static void main(String[] args) {
		try {
			JsonArray dane = pobierzJSON(ADRES + "/A?format=json");
				
			JsonObject tabela = dane.getJsonObject(0);
			
			String numerTabeli = tabela.getString("no");
			String data = tabela.getString("effectiveDate");
			System.out.println("Tabela numer " + numerTabeli + " z dnia " + data);
			
			JsonArray waluty = tabela.getJsonArray("rates");
			
			for (JsonValue jsonValue : waluty) {
				// jeśli element tablicy jest JSON-owym obiektem (a powinien być), to rzutujemy i odczytujemy pola
				if(jsonValue instanceof JsonObject) {
					JsonObject walutaJSON = (JsonObject) jsonValue;
					String kod = walutaJSON.getString("code");
					String nazwa = walutaJSON.getString("currency");
					BigDecimal kurs = walutaJSON.getJsonNumber("mid").bigDecimalValue();
					Waluta waluta = new Waluta(kod, nazwa, kurs);
					
					System.out.println(waluta);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static JsonArray pobierzJSON(String adres) throws IOException {
		URL url = new URL(adres);
		try (InputStream in = url.openStream()) {
			JsonReader reader = Json.createReader(in);
			return reader.readArray();
		}
	}

}
