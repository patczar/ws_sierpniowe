package waluty.pobieranie;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((nazwaTabeli == null) ? 0 : nazwaTabeli.hashCode());
		result = prime * result + ((numerTabeli == null) ? 0 : numerTabeli.hashCode());
		result = prime * result + ((waluty == null) ? 0 : waluty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Tabela other = (Tabela) obj;
		if(data == null) {
			if(other.data != null)
				return false;
		} else if(!data.equals(other.data))
			return false;
		if(nazwaTabeli == null) {
			if(other.nazwaTabeli != null)
				return false;
		} else if(!nazwaTabeli.equals(other.nazwaTabeli))
			return false;
		if(numerTabeli == null) {
			if(other.numerTabeli != null)
				return false;
		} else if(!numerTabeli.equals(other.numerTabeli))
			return false;
		if(waluty == null) {
			if(other.waluty != null)
				return false;
		} else if(!waluty.equals(other.waluty))
			return false;
		return true;
	}
}
