package waluty.wersja_xml;

import java.util.Scanner;

public class WypiszKursyHistoryczne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Podaj datę: ");
		String data = sc.nextLine();
		
		System.out.println("Pobieram...");
		Tabela tabela = ObslugaNBP.pobierzKursyHistoryczne(data);
		System.out.println("Pobrana tabela: " + tabela);
		
		for (Waluta waluta : tabela.getWszystkieWaluty()) {
			System.out.println(waluta);
		}
	}

}
