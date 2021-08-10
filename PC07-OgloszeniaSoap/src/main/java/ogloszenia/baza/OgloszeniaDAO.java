package ogloszenia.baza;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import ogloszenia.exn.BladBazyDanych;
import ogloszenia.exn.NieznanyRekord;
import ogloszenia.model.Ogloszenie;
import ogloszenia.model.Paliwo;
import ogloszenia.model.Samochodowe;
import ogloszenia.model.Sprzedawca;

public class OgloszeniaDAO extends AbstractDAO {

	OgloszeniaDAO(DostepDoBazy baza) {
		super(baza);
	}

	/** Lista id wszystkich ogłoszeń <strong>samochodowych</strong>.
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> listaIdOgloszen() throws BladBazyDanych {
		final String sql = "SELECT id_ogloszenia FROM samochodowe ORDER BY id_ogloszenia";
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

	/** Zwraca listę wszystkich ogłoszeń samochodowych wraz z danymi sprzedawców.
	 * @return
	 * @throws BladBazyDanych
	 */
	public List<Samochodowe> odczytajWszystkie() throws BladBazyDanych {
		final String sql = "SELECT * FROM ogloszenia INNER JOIN samochodowe USING(id_ogloszenia) ORDER BY id_ogloszenia";
		
		List<Samochodowe> lista = new LinkedList<>();
		
		try(PreparedStatement stmt = c().prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				wypelnijListeOgloszenDanymiZResultSet(lista, rs);
			}
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
		
		return lista;
	}
	
	/** Odczytuje jedno ogłoszenie.
	 * @param idOgloszenia które ma być odczytane
	 * @return
	 * @throws BladBazyDanych
	 * @throws NieznanyRekord gdy nie istnieje rekord o podanym id
	 */
	public Samochodowe odczytajWgId(int idOgloszenia) throws BladBazyDanych, NieznanyRekord {
		final String sql = "SELECT * FROM ogloszenia INNER JOIN samochodowe USING(id_ogloszenia)"
				+ " WHERE id_ogloszenia = ?";
		
		try(PreparedStatement stmt = c().prepareStatement(sql)) {
			stmt.setInt(1, idOgloszenia);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					Samochodowe ogloszenie = ogloszenieZResultSet(rs);
					return ogloszenie;
				} else {
					throw new NieznanyRekord("Brak ogłoszenia o id="+idOgloszenia);
				}
			}
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
	}

	/** Odczytuje ogłoszenia o cenie a podanego przedziału
	 * @param cenaOd minimalna cena szukanych ogłoszeń, lub null jeśli nie ma dolnej granicy
	 * @param cenaDo maksymalna cena szukanych ogłoszeń, lub null jeśli nie ma dolnej granicy
	 * @return
	 * @throws BladBazyDanych
	 */
	public List<Samochodowe> odczytajWedlugCeny(BigDecimal cenaOd, BigDecimal cenaDo) throws BladBazyDanych {
		//final String sql = "SELECT * FROM ogloszenia WHERE cena BETWEEN ? AND ?";
		final String sql = "SELECT * FROM ogloszenia INNER JOIN samochodowe USING(id_ogloszenia)"
				+ " WHERE cena BETWEEN ? AND ?"
				+ " ORDER BY id_ogloszenia";

		if(cenaOd == null)
			cenaOd = BigDecimal.ZERO;
		
		if(cenaDo == null)
			cenaDo = new BigDecimal(1_000_000_000);
		
		List<Samochodowe> lista = new LinkedList<>();
		
		try(PreparedStatement stmt = c().prepareStatement(sql)) {
			stmt.setBigDecimal(1, cenaOd);			
			stmt.setBigDecimal(2, cenaDo);
			try(ResultSet rs = stmt.executeQuery()) {
				wypelnijListeOgloszenDanymiZResultSet(lista, rs);
			}
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy w metodzie ogloszeniaWedlugCeny: " + e.getMessage(), e);
		}	
		return lista;
	}

	/** Zapisuje rekord do bazy danych.
	 * Jeśli istniał już rekord o podanym id, jest nadpisywany.
	 * Jeśli rekord posiada id, ale w bazie nie ma rekordu o takim id, jest dodawany.
	 * Jeśli rekord nie posiada id, nowe id jest generowane z sekwencji, rekord jest dodawany z takim nowym id, a to id jest także ustawiane w obiekcie ogl
	 * @param ogl ogłoszenie do zapisania; obiekt może zostać zmodyfikowany na dwa sposoby: jeśli nie posiadał id, nowe id jest generowane z sekwencji; jeśli nie posiadał pola wystawione, wpisywany jest bieżący czas
	 * @throws BladBazyDanych
	 */
	public void zapisz(Samochodowe ogl) throws BladBazyDanych {
		if(ogl.getIdOgloszenia() == null) {
			// wstawiamy nowy rekord korzystajac z sekwecji
			dodajNowy(ogl);
		} else {
			if(! aktualizuj(ogl)) {
				dodaj(ogl);
			}
		}
	}
	
	public boolean dodajNowy(Samochodowe ogloszenie) throws BladBazyDanych {
		// nowe id z sekwencji - podejście z takich baz jak PostgreSQL czy Oracle
		final String sql1 = "SELECT nextval('seq_ogloszenia')";
		int nextId;
		try(PreparedStatement stmt1 = c().prepareStatement(sql1);
			ResultSet rs1 = stmt1.executeQuery()) {
			if(rs1.next()) {
				nextId = rs1.getInt(1);
			} else {
				throw new BladBazyDanych("nie działa sequence");
			}
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
		ogloszenie.setIdOgloszenia(nextId);
		if(ogloszenie.getWystawione() == null) {
			ogloszenie.setWystawione(LocalDateTime.now());
		}
		return this.dodaj(ogloszenie);
	}
	
	public boolean dodaj(Samochodowe ogl) throws BladBazyDanych {
		// dwa inserty, bo dane są podzielone na dwie tabele
		final String sql1 = "INSERT INTO ogloszenia("
            + " id_ogloszenia, id_sprzedawcy, wystawione, cena, lokalizacja, tytul, opis)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";

		final String sql2 = "INSERT INTO samochodowe("
				+ " id_ogloszenia, marka, model, generacja, kolor, rocznik, przebieg, pojemnosc, moc, paliwo)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try(PreparedStatement stmt = c().prepareStatement(sql1)) {
			stmt.setInt(1, ogl.getIdOgloszenia());
			stmt.setInt(2, ogl.getIdSprzedawcy());
			stmt.setTimestamp(3, Konwersje.dateTimeToTimestamp(ogl.getWystawione()));
			stmt.setBigDecimal(4, ogl.getCena());
			stmt.setString(5, ogl.getLokalizacja());
			stmt.setString(6, ogl.getTytul());
			stmt.setString(7, ogl.getOpis());
			int ile = stmt.executeUpdate();
			if(ile < 1)
				return false;			
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}		
		
		try(PreparedStatement stmt = c().prepareStatement(sql2)) {
			stmt.setInt(1, ogl.getIdOgloszenia());
			stmt.setString(2, ogl.getMarka());
			stmt.setString(3, ogl.getModel());
			stmt.setString(4, ogl.getGeneracja());
			stmt.setString(5, ogl.getKolor());
			stmt.setInt(6, ogl.getRocznik());
			stmt.setInt(7, ogl.getPrzebieg());
			stmt.setFloat(8, ogl.getPojemnosc());
			stmt.setFloat(9, ogl.getMoc());
			stmt.setString(10, String.valueOf(ogl.getPaliwo()));
			int ile = stmt.executeUpdate();
			if(ile < 1)
				return false;
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
		return true;
	}
	
	public boolean aktualizuj(Samochodowe ogl) throws BladBazyDanych {
		final String sql1 = "UPDATE ogloszenia"
				+ " SET id_ogloszenia=?, id_sprzedawcy=?, wystawione=?, cena=?, lokalizacja=?, tytul=?, opis=?"
				+ " WHERE id_ogloszenia=?";
		final String sql2 = "UPDATE samochodowe"
				+ " SET id_ogloszenia=?, marka=?, model=?, generacja=?, kolor=?, rocznik=?, przebieg=?, pojemnosc=?, moc=?, paliwo=?"
				+ " WHERE id_ogloszenia=?";
		
		try(PreparedStatement stmt = c().prepareStatement(sql1)) {
			stmt.setInt(1, ogl.getIdOgloszenia());
			stmt.setInt(2, ogl.getIdSprzedawcy());
			stmt.setTimestamp(3, Konwersje.dateTimeToTimestamp(ogl.getWystawione()));
			stmt.setBigDecimal(4, ogl.getCena());
			stmt.setString(5, ogl.getLokalizacja());
			stmt.setString(6, ogl.getTytul());
			stmt.setString(7, ogl.getOpis());
			stmt.setInt(8, ogl.getIdOgloszenia());
			int ile = stmt.executeUpdate();
			if(ile < 1)
				return false;			
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}	
		
		try(PreparedStatement stmt = c().prepareStatement(sql2)) {
			stmt.setInt(1, ogl.getIdOgloszenia());
			stmt.setString(2, ogl.getMarka());
			stmt.setString(3, ogl.getModel());
			stmt.setString(4, ogl.getGeneracja());
			stmt.setString(5, ogl.getKolor());
			stmt.setInt(6, ogl.getRocznik());
			stmt.setInt(7, ogl.getPrzebieg());
			stmt.setFloat(8, ogl.getPojemnosc());
			stmt.setFloat(9, ogl.getMoc());
			stmt.setString(10, String.valueOf(ogl.getPaliwo()));
			stmt.setInt(11, ogl.getIdOgloszenia());
			int ile = stmt.executeUpdate();
			if(ile < 1)
				return false;
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
		return true;
		
	}
	
	
	private void wypelnijListeOgloszenDanymiZResultSet(List<Samochodowe> lista, ResultSet rs) throws SQLException, BladBazyDanych {
		while(rs.next()) {
			Samochodowe ogloszenie = ogloszenieZResultSet(rs);
			lista.add(ogloszenie);
		}
	}

	private Samochodowe ogloszenieZResultSet(ResultSet rs) throws SQLException, BladBazyDanych {
		Samochodowe ogloszenie = new Samochodowe(
				rs.getInt("id_ogloszenia"),
				rs.getInt("id_sprzedawcy"),
				Konwersje.timestampToDateTime(rs.getTimestamp("wystawione")),
				rs.getBigDecimal("cena"),
				rs.getString("lokalizacja"),
				rs.getString("tytul"),
				rs.getString("opis"),
				rs.getString("marka"),
				rs.getString("model"),
				rs.getString("generacja"),
				rs.getString("kolor"),
				rs.getInt("rocznik"),
				rs.getInt("przebieg"),
				rs.getFloat("pojemnosc"),
				rs.getFloat("moc"),
				Paliwo.valueOf(rs.getString("paliwo")));
		uzupelnijDaneSprzedawcy(ogloszenie);
		return ogloszenie;
	}
	
	private void uzupelnijDaneSprzedawcy(Ogloszenie ogloszenie) throws BladBazyDanych {
		SprzedawcyDAO sdao = baza.sprzedawcyDAO();
		Sprzedawca sprzedawca = sdao.odczytajWgId(ogloszenie.getIdSprzedawcy());
		ogloszenie.setSprzedawca(sprzedawca);
	}

	public boolean usun(int idOgloszenia) throws BladBazyDanych {
		final String sql1 = "DELETE FROM ogloszenia"
				+ " WHERE id_ogloszenia=?";
		final String sql2 = "DELETE FROM samochodowe"
				+ " WHERE id_ogloszenia=?";
		
		try(PreparedStatement stmt = c().prepareStatement(sql2)) {
			stmt.setInt(1, idOgloszenia);
			int ile = stmt.executeUpdate();
			if(ile < 1)
				return false;			
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}			
		try(PreparedStatement stmt = c().prepareStatement(sql1)) {
			stmt.setInt(1, idOgloszenia);
			int ile = stmt.executeUpdate();
			if(ile < 1)
				return false;			
		} catch (SQLException e) {
			throw new BladBazyDanych("Błąd bazy", e);
		}
		return true;
	}
}
