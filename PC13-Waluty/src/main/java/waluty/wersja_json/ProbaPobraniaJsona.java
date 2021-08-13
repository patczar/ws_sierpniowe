package waluty.wersja_json;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class ProbaPobraniaJsona {
	private static final String ADRES = "http://api.nbp.pl/api/exchangerates/tables";

	public static void main(String[] args) {
		try {
			String adres = ADRES + "/A?format=json";
			URL url = new URL(adres);
			try (InputStream in = url.openStream()) {
				System.out.println("zaczynam parsować...");
				JsonReader reader = Json.createReader(in);
				JsonArray dane = reader.readArray();
				//System.out.println(dane);

				JsonObject tabela = dane.getJsonObject(0);
//				System.out.println(tabela);
				
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
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
