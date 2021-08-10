package waluty.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ArrayOfExchangeRatesTable")
public class ArrayOfExchangeRatesTable {
	@XmlElement(name="ExchangeRatesTable")
	private final List<ExchangeRatesTable> tables = new ArrayList<>();
	
	public void addTables(List<ExchangeRatesTable> tables) {
		if(tables != null) {
			this.tables.addAll(tables);
		}
	}

	public void addTable(ExchangeRatesTable table) {
		this.tables.add(table);
	}

	public List<ExchangeRatesTable> getTables() {
		return Collections.unmodifiableList(tables);
	}

	@Override
	public String toString() {
		return "ArrayOfExchangeRatesTable [" + tables.size() + " tables]";
	}
}
