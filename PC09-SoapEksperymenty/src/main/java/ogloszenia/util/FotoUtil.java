package ogloszenia.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import ogloszenia.exn.NieznanyRekord;

public class FotoUtil {
	
	public static byte[] wczytajFoto(int id) throws NieznanyRekord {
		String katalog = Ustawienia.wczytaj().getProperty("katalog_foto");
		String plik = id + ".jpg";
		try {
			byte[] dane = Files.readAllBytes(Paths.get(katalog, plik));
			return dane;
		} catch (IOException e) {
			throw new NieznanyRekord("Brak pliku ze zdjęciem " + plik);
		}
	}	
}
