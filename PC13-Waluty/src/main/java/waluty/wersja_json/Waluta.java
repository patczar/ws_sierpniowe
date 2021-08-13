package waluty.wersja_json;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Waluta {
    private final String kod;
    private final String nazwa;
    private final BigDecimal kurs;
    
	public Waluta(String kod, String nazwa, BigDecimal kurs) {
		this.kod = kod;
		this.nazwa = nazwa;
		this.kurs = kurs;
	}

	public String getKod() {
		return kod;
	}

	public String getNazwa() {
		return nazwa;
	}

	public BigDecimal getKurs() {
		return kurs;
	}
    
    @Override
    public String toString() {
        return nazwa + " (" + kod + "): " + kurs;
    }

	@Override
	public int hashCode() {
		return Objects.hash(kod, kurs, nazwa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waluta other = (Waluta) obj;
		return Objects.equals(kod, other.kod) && Objects.equals(kurs, other.kurs) && Objects.equals(nazwa, other.nazwa);
	}
	
	public BigDecimal przeliczNaZlote(BigDecimal kwota) {
		return kwota.multiply(kurs).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal przeliczNaWalute(BigDecimal kwota) {
		return kwota.divide(kurs, 2, RoundingMode.HALF_UP);
	}
    
}
