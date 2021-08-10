package ogloszenia.baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import ogloszenia.exn.BladBazyDanych;
import ogloszenia.util.Ustawienia;

public class DostepDoBazy implements AutoCloseable {
	private Connection c;
	
	public DostepDoBazy() throws BladBazyDanych {
		Properties props = Ustawienia.wczytaj();
		
		try {
			Class.forName(props.getProperty("driver_class"));
			c = DriverManager.getConnection(props.getProperty("url") , props);
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BladBazyDanych("Błąd podczas łączenia z bazą", e);
		}
	}

	public void close() {
		try {
			if(c != null)
				c.close();
		} catch (Exception e) {
			System.err.println("WARNING: Błąd poczas rozłączania");
			e.printStackTrace();
		}
	}
	
	Connection getC() {
		return c;
	}

	public void beginTransaction() throws SQLException {
		c.setAutoCommit(false);
		c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
	}

	public void endTransaction(boolean commit) throws SQLException {
		if(commit) {
			c.commit();
		} else {
			c.rollback();
		}
		c.setAutoCommit(true);
	}

	public OgloszeniaDAO ogloszeniaDAO() {
		return new OgloszeniaDAO(this);
	}

	public SprzedawcyDAO sprzedawcyDAO() {
		return new SprzedawcyDAO(this);
	}
}
