package ogloszenia.model;

import java.util.ArrayList;
import java.util.List;

public class ListaOgloszen {
	public List<Samochodowe> ogloszenia;
	
	public ListaOgloszen() {
		ogloszenia = new ArrayList<>();
	}

	public ListaOgloszen(List<Samochodowe> ogloszenia) {
		this.ogloszenia = ogloszenia;
	}
	
	
	
}
