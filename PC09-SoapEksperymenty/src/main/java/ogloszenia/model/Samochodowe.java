package ogloszenia.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Samochodowe extends Ogloszenie {
	private String marka;
	private String model;
	private String generacja;
	private String kolor;
	private int rocznik;
	private int przebieg;
	private float pojemnosc;
	private float moc;
	private Paliwo paliwo;
	
	public Samochodowe() {
	}

	public Samochodowe(Integer idOgloszenia, Integer idSprzedawcy, LocalDateTime wystawione, BigDecimal cena,
			String lokalizacja, String tytul, String opis, String marka, String model, String generacja, String kolor,
			int rocznik, int przebieg, float pojemnosc, float moc, Paliwo paliwo) {
		super(idOgloszenia, idSprzedawcy, wystawione, cena, lokalizacja, tytul, opis);
		this.marka = marka;
		this.model = model;
		this.generacja = generacja;
		this.kolor = kolor;
		this.rocznik = rocznik;
		this.przebieg = przebieg;
		this.pojemnosc = pojemnosc;
		this.moc = moc;
		this.paliwo = paliwo;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getGeneracja() {
		return generacja;
	}

	public void setGeneracja(String generacja) {
		this.generacja = generacja;
	}

	public String getKolor() {
		return kolor;
	}

	public void setKolor(String kolor) {
		this.kolor = kolor;
	}

	public int getRocznik() {
		return rocznik;
	}

	public void setRocznik(int rocznik) {
		this.rocznik = rocznik;
	}

	public int getPrzebieg() {
		return przebieg;
	}

	public void setPrzebieg(int przebieg) {
		this.przebieg = przebieg;
	}

	public float getPojemnosc() {
		return pojemnosc;
	}

	public void setPojemnosc(float pojemnosc) {
		this.pojemnosc = pojemnosc;
	}

	public float getMoc() {
		return moc;
	}

	public void setMoc(float moc) {
		this.moc = moc;
	}

	public Paliwo getPaliwo() {
		return paliwo;
	}

	public void setPaliwo(Paliwo paliwo) {
		this.paliwo = paliwo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((generacja == null) ? 0 : generacja.hashCode());
		result = prime * result + ((kolor == null) ? 0 : kolor.hashCode());
		result = prime * result + ((marka == null) ? 0 : marka.hashCode());
		result = prime * result + Float.floatToIntBits(moc);
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + Float.floatToIntBits(pojemnosc);
		result = prime * result + przebieg;
		result = prime * result + rocznik;
		result = prime * result + ((marka == null) ? 0 : paliwo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Samochodowe other = (Samochodowe) obj;
		if (generacja == null) {
			if (other.generacja != null)
				return false;
		} else if (!generacja.equals(other.generacja))
			return false;
		if (kolor == null) {
			if (other.kolor != null)
				return false;
		} else if (!kolor.equals(other.kolor))
			return false;
		if (marka == null) {
			if (other.marka != null)
				return false;
		} else if (!marka.equals(other.marka))
			return false;
		if (Float.floatToIntBits(moc) != Float.floatToIntBits(other.moc))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Float.floatToIntBits(pojemnosc) != Float.floatToIntBits(other.pojemnosc))
			return false;
		if (przebieg != other.przebieg)
			return false;
		if (rocznik != other.rocznik)
			return false;
		if (paliwo == null) {
			if (other.paliwo != null)
				return false;
		} else if (!paliwo.equals(other.paliwo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("Ogl.Samochodowe [id=").append(getIdOgloszenia()).append(", idSprz=")
			.append(getIdSprzedawcy()).append(", wystawione=").append(getWystawione()).append(", cena=")
			.append(getCena()).append(", lok=").append(getLokalizacja()).append(", tytul=")
			.append(getTytul()).append(", opis=").append(getOpis())
			.append(", marka=").append(getMarka()).append(", model=").append(getModel())
			.append(", gen=").append(getGeneracja()).append(", kolor=").append(getKolor())
			.append(", rocznik=").append(getRocznik()).append(", przeb=").append(getPrzebieg())
			.append(", poj=").append(getPojemnosc()).append(", moc=").append(getMoc()).append(", paliwo=").append(getPaliwo()).append("]");
		return builder.toString();
	}

    public String dajHtml() {
        // String.format zwraca Stringa, a System.out.printf wypisuje na wyjście
        return String.format("<div class='ogloszenie'>"
                + "<h2>%s</h2>"
                + "<p>Cena: <strong>%,.0f PLN</strong></p>"
                + "<p>Marka: %s %s %s</p>"
                + "<p>Silnik: %.1f l, %.0f KM, %s</p>"
                + "</div>",
                getTytul(),
                getCena(),
                getMarka(),
                getModel(),
                getGeneracja(),
                getPojemnosc(),
                getMoc(),
                getPaliwo()
        );
    }
}
