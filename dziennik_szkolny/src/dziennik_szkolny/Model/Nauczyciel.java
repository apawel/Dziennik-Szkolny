package dziennik_szkolny.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Nauczyciel")
@Table(name = "Nauczyciel")
public class Nauczyciel {
	public Nauczyciel(String imie, String nazwisko, String pesel, String haslo) {

		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.haslo = haslo;
	}

	public int getIdNauczyciel() {
		return idNauczyciel;
	}

	public void setIdNauczyciel(int idNauczyciel) {
		this.idNauczyciel = idNauczyciel;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	@Id
	@Column(name = "idNauczyciel")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idNauczyciel;
	@Column(name = "imie")
	String imie;
	@Column(name = "nazwisko")
	String nazwisko;
	@Column(name = "pesel")
	String pesel;
	@Column(name = "haslo")
	String haslo;

}
