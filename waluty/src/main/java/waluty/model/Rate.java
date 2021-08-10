package waluty.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

public class Rate {
	@XmlElement(name="Currency")
	private String currency;

	@XmlElement(name="Code")
	private String code;
	
	@XmlElement(name="Mid")
	private BigDecimal mid;
	
	public Rate() {
		this(null, null, null);
	}
	
	public Rate(String currency, String code, BigDecimal mid) {
		this.currency = currency;
		this.code = code;
		this.mid = mid;
	}

	public String getCurrency() {
		return currency;
	}

	public String getCode() {
		return code;
	}

	public BigDecimal getMid() {
		return mid;
	}

	@Override
	public String toString() {
		return "Rate [currency=" + currency + ", code=" + code + ", mid=" + mid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, currency, mid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rate other = (Rate) obj;
		return Objects.equals(code, other.code)
				&& Objects.equals(currency, other.currency)
				&& Objects.equals(mid, other.mid);
	}
	
}
