package waluty.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class ExchangeRatesTable {
	@XmlElement(name="Table")
	private String table;

	@XmlElement(name="No")
	private String no;

	@XmlElement(name="EffectiveDate")
	private String effectiveDate;

	@XmlElementWrapper(name="Rates")
	@XmlElement(name="Rate")
	private final List<Rate> rates;

	public ExchangeRatesTable(String table, String no, String effectiveDate) {
		this.table = table;
		this.no = no;
		this.effectiveDate = effectiveDate;
		this.rates = new ArrayList<>();
	}

	public ExchangeRatesTable(String table, String no, String effectiveDate, List<Rate> rates) {
		this(table, no, effectiveDate);
		addRates(rates);
	}

	public ExchangeRatesTable() {
		this(null, null, null);
	}

		public String getTable() {
		return table;
	}

	public String getNo() {
		return no;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public List<Rate> getRates() {
		return Collections.unmodifiableList(rates);
	}

	public void addRates(List<Rate> rates) {
		if(rates != null) {
			this.rates.addAll(rates);
		}
	}

	public void addRate(Rate rate) {
		this.rates.add(rate);
	}

	
	
	@Override
	public String toString() {
		return "ExchangeRatesTable [table=" + table + ", no=" + no + ", effectiveDate=" + effectiveDate + ", "
				+ rates.size() + " rates ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(table, no, effectiveDate, rates);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExchangeRatesTable other = (ExchangeRatesTable) obj;
		return Objects.equals(table, other.table) && Objects.equals(no, other.no)
				&& Objects.equals(effectiveDate, other.effectiveDate) && Objects.equals(rates, other.rates);
	}
	
}
