package ogloszenia.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Ogloszenie {
	@XmlAttribute(name="id")
	private Integer idOgloszenia;
	@XmlAttribute(name="id-sprzedawcy")
	private Integer idSprzedawcy;
	
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private LocalDateTime wystawione;
	
	private BigDecimal cena;
	private String lokalizacja;
	private String tytul;
	private String opis;
	private Sprzedawca sprzedawca;
	
	public Ogloszenie() {
	}

	public Ogloszenie(Integer idOgloszenia, Integer idSprzedawcy, LocalDateTime wystawione, BigDecimal cena, String lokalizacja,
			String tytul, String opis) {
		super();
		this.idOgloszenia = idOgloszenia;
		this.idSprzedawcy = idSprzedawcy;
		this.wystawione = wystawione;
		this.cena = cena;
		this.lokalizacja = lokalizacja;
		this.tytul = tytul;
		this.opis = opis;
	}

	public Integer getIdOgloszenia() {
		return idOgloszenia;
	}

	public void setIdOgloszenia(Integer idOgloszenia) {
		this.idOgloszenia = idOgloszenia;
	}

	public Integer getIdSprzedawcy() {
		return idSprzedawcy;
	}

	public void setIdSprzedawcy(Integer idSprzedawcy) {
		this.idSprzedawcy = idSprzedawcy;
	}
	
	public Sprzedawca getSprzedawca() {
		return sprzedawca;
	}

	public void setSprzedawca(Sprzedawca sprzedawca) {
		this.sprzedawca = sprzedawca;
	}

	public LocalDateTime getWystawione() {
		return wystawione;
	}

	public void setWystawione(LocalDateTime wystawione) {
		this.wystawione = wystawione;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public String getLokalizacja() {
		return lokalizacja;
	}

	public void setLokalizacja(String lokalizacja) {
		this.lokalizacja = lokalizacja;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "Ogloszenie [id=" + idOgloszenia + ", wystawione=" + wystawione + ", cena=" + cena
				+ ", lok=" + lokalizacja + ", opis=" + opis + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cena == null) ? 0 : cena.hashCode());
		result = prime * result + idOgloszenia;
		result = prime * result + ((lokalizacja == null) ? 0 : lokalizacja.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((wystawione == null) ? 0 : wystawione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ogloszenie other = (Ogloszenie) obj;
		if (cena == null) {
			if (other.cena != null)
				return false;
		} else if (!cena.equals(other.cena))
			return false;
		if (idOgloszenia != other.idOgloszenia)
			return false;
		if (lokalizacja == null) {
			if (other.lokalizacja != null)
				return false;
		} else if (!lokalizacja.equals(other.lokalizacja))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (wystawione == null) {
			if (other.wystawione != null)
				return false;
		} else if (!wystawione.equals(other.wystawione))
			return false;
		return true;
	}
}
