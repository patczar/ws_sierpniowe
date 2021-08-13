package waluty.wersja_json;
import java.util.Collection;

public class WypiszWszystkieWaluty {

	public static void main(String[] args) {
		Tabela tabela = ObslugaNBP.pobierzBiezaceKursy();		
		System.out.println("Pobrana tabela: " + tabela);
		
		Collection<Waluta> waluty = tabela.getWszystkieWaluty();
		for (Waluta waluta : waluty) {
			System.out.println(waluta);
		}
	}

}
