package ogloszenia.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Sprzedawca {
	@XmlAttribute(name="id")
	private int id_sprzedawcy;
	private String nazwa;
	private String ulica;
	@XmlElement(name="kod-pocztowy")
	private String kod_pocztowy;
	private String miasto;
	private String email;
	private String telefon;
	
	public Sprzedawca() {
	}

	public Sprzedawca(int id_sprzedawcy, String nazwa, String ulica, String kod_pocztowy, String miasto, String email,
			String telefon) {
		super();
		this.id_sprzedawcy = id_sprzedawcy;
		this.nazwa = nazwa;
		this.ulica = ulica;
		this.kod_pocztowy = kod_pocztowy;
		this.miasto = miasto;
		this.email = email;
		this.telefon = telefon;
	}

	public int getId_sprzedawcy() {
		return id_sprzedawcy;
	}

	public void setId_sprzedawcy(int id_sprzedawcy) {
		this.id_sprzedawcy = id_sprzedawcy;
	}

	public String getNazwa() {
		return nazwa.toUpperCase();
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getKod_pocztowy() {
		return kod_pocztowy;
	}

	public void setKod_pocztowy(String kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_sprzedawcy;
		result = prime * result + ((kod_pocztowy == null) ? 0 : kod_pocztowy.hashCode());
		result = prime * result + ((miasto == null) ? 0 : miasto.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((telefon == null) ? 0 : telefon.hashCode());
		result = prime * result + ((ulica == null) ? 0 : ulica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sprzedawca other = (Sprzedawca) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_sprzedawcy != other.id_sprzedawcy)
			return false;
		if (kod_pocztowy == null) {
			if (other.kod_pocztowy != null)
				return false;
		} else if (!kod_pocztowy.equals(other.kod_pocztowy))
			return false;
		if (miasto == null) {
			if (other.miasto != null)
				return false;
		} else if (!miasto.equals(other.miasto))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (telefon == null) {
			if (other.telefon != null)
				return false;
		} else if (!telefon.equals(other.telefon))
			return false;
		if (ulica == null) {
			if (other.ulica != null)
				return false;
		} else if (!ulica.equals(other.ulica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sprzedawca [id_sprzedawcy=").append(id_sprzedawcy).append(", nazwa=").append(nazwa)
				.append(", ulica=").append(ulica).append(", kod_pocztowy=").append(kod_pocztowy).append(", miasto=")
				.append(miasto).append(", email=").append(email).append(", telefon=").append(telefon).append("]");
		return builder.toString();
	}
}
