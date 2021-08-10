package ogloszenia.baza;

import java.sql.Connection;

public abstract class AbstractDAO {
	protected DostepDoBazy baza;

	protected AbstractDAO(DostepDoBazy baza) {
		this.baza = baza;
	}
	
	protected Connection c() {
		return baza.getC();
	}
}
