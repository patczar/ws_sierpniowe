package waluty.wersja_json;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Tabela {
	private final String nazwaTabeli;
	private final String numerTabeli;
	private final LocalDate data;
	private final Map<String, Waluta> waluty = new TreeMap<>();
	
	public Tabela() {
		nazwaTabeli = null;
		numerTabeli = null;
		data = null;
	}

	public Tabela(String nazwaTabeli, String numerTabeli, LocalDate data) {
		this.nazwaTabeli = nazwaTabeli;
		this.numerTabeli = numerTabeli;
		this.data = data;
	}

	public String getNazwaTabeli() {
		return nazwaTabeli;
	}

	public String getNumerTabeli() {
		return numerTabeli;
	}

	public LocalDate getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Tabela " + nazwaTabeli + " nr " + numerTabeli
				+ " z dnia " + data + " (" + waluty.size() + " walut)";
	}
	
	public void dodaj(Waluta waluta) {
		waluty.put(waluta.getKod(), waluta);
	}
	
	public Waluta znajdz(String kod) {
		return waluty.get(kod);
	}
	
	public Collection<Waluta> getWszystkieWaluty() {
		return waluty.values();
	}
	
	private static final String[] PUSTA_TABLICA = new String[0];
	
	public String[] getKodyWalut() {
		return waluty.keySet().toArray(PUSTA_TABLICA);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, nazwaTabeli, numerTabeli, waluty);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tabela other = (Tabela) obj;
		return Objects.equals(data, other.data) && Objects.equals(nazwaTabeli, other.nazwaTabeli)
				&& Objects.equals(numerTabeli, other.numerTabeli) && Objects.equals(waluty, other.waluty);
	}

	
}
