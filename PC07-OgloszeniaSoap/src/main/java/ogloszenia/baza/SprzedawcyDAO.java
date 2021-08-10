package ogloszenia.baza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ogloszenia.exn.BladBazyDanych;
import ogloszenia.model.Sprzedawca;

public class SprzedawcyDAO extends AbstractDAO {

	protected SprzedawcyDAO(DostepDoBazy baza) {
		super(baza);
	}

	public List<Integer> listaIdSprzedawcow() throws BladBazyDanych {
		final String sql = "SELECT id_sprzedawcy FROM sprzedawcy";
		List<Integer> lista = new LinkedList<>();
		try(PreparedStatement stmt = c().prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					lista.add(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
		return lista;
	}

	public List<Sprzedawca> odczytajWszystkich() throws BladBazyDanych {
		final String sql = "SELECT * FROM sprzedawcy";
		List<Sprzedawca> lista = new LinkedList<>();
		try(PreparedStatement stmt = c().prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					lista.add(sprzedawcaZResultSet(rs));
				}
			}
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
		return lista;
	}

	public Sprzedawca odczytajWgId(int idSprzedawcy) throws BladBazyDanych {
		final String sql = "SELECT * FROM sprzedawcy WHERE id_sprzedawcy = ?";
		
		try(PreparedStatement stmt = c().prepareStatement(sql)) {
			stmt.setInt(1, idSprzedawcy);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					return sprzedawcaZResultSet(rs);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
	}

	private Sprzedawca sprzedawcaZResultSet(ResultSet rs) throws SQLException {
		return new Sprzedawca(rs.getInt("id_sprzedawcy"),
			rs.getString("nazwa"),
			rs.getString("ulica"),
			rs.getString("kod_pocztowy"),
			rs.getString("miasto"),
			rs.getString("email"),
			rs.getString("telefon"));
	}
}
