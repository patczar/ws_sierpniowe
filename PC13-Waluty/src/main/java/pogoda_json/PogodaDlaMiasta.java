package pogoda_json;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class PogodaDlaMiasta {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Podaj nazwę miasta: ");
			String miasto = sc.nextLine();
			
			int idLokalizacji = dajIdLokalizacji(miasto);
			System.out.println("Znalezione id lokalizacji: " + idLokalizacji);
			
			wypiszPogodeDlaLokalizacji(idLokalizacji);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static JsonArray pobierzJSONArray(String adres) throws IOException {
		URL url = new URL(adres);
		try (InputStream in = url.openStream()) {
			JsonReader reader = Json.createReader(in);
			return reader.readArray();
		}
	}
	
	private static JsonObject pobierzJSONObject(String adres) throws IOException {
		URL url = new URL(adres);
		try (InputStream in = url.openStream()) {
			JsonReader reader = Json.createReader(in);
			return reader.readObject();
		}
	}

	private static int dajIdLokalizacji(String miasto) throws IOException {
		String adres = "https://www.metaweather.com/api/location/search/?query=" + miasto;
		JsonArray dane = pobierzJSONArray(adres);
		JsonObject object = dane.getJsonObject(0);
		return object.getInt("woeid");
	}
	
	private static void wypiszPogodeDlaLokalizacji(int idLokalizacji) throws IOException {
		String adres = "https://www.metaweather.com/api/location/" + idLokalizacji;
		JsonObject jsonObject = pobierzJSONObject(adres);
		JsonArray jsonArray = jsonObject.getJsonArray("consolidated_weather");
		
		for (JsonValue jsonValue : jsonArray) {
			if(jsonValue instanceof JsonObject) {
				JsonObject prognoza = (JsonObject) jsonValue;
				System.out.println("Data: " + prognoza.getString("applicable_date"));
				System.out.println("Ogólny stan: " + prognoza.getString("weather_state_name"));
				System.out.println("Temperatura: " + prognoza.getJsonNumber("the_temp").doubleValue());
				
			}
			System.out.println();
		}
	}

}
