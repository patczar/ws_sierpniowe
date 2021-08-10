package ogloszenia.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Ustawienia {

	/* stara wersja 
	public static Properties wczytaj() {
		Properties p = new Properties();
		p.setProperty("url", "jdbc:postgresql://localhost/ogloszenia");
		p.setProperty("driver_class", "org.postgresql.Driver");
		p.setProperty("user", "ogloszenia");
		p.setProperty("password", "abc123");
		return p;
	}
	*/
	
	public static Properties wczytaj() {
		Properties p = new Properties();
				
		try (InputStream in = Ustawienia.class
				.getResourceAsStream("/ustawienia.properties")) {
			p.load(in);
		} catch (IOException e) {
			System.err.println("Nie mogę załadować properties " + e);
		}
		return p;
	}
}
