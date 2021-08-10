package waluty.pobieranie;

import waluty.model.ArrayOfExchangeRatesTable;
import waluty.model.ExchangeRatesTable;
import waluty.model.Rate;

public class PobierzBiezaceJAXB {

	public static void main(String[] args) {
		try {
			ImplementacjaPobieraniaJAXB impl = new ImplementacjaPobieraniaJAXB();
			System.out.println("pobieram");
			ArrayOfExchangeRatesTable array = impl.pobierzBiezaceKursy("A");
			System.out.println("array: " + array);
			for (ExchangeRatesTable table : array.getTables()) {
				System.out.println(table);
				for (Rate rate : table.getRates()) {
					System.out.print("  * ");
					System.out.println(rate);
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
