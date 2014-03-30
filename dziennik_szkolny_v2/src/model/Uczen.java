package model;

// Generated 2014-03-29 15:18:46 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Uczen generated by hbm2java
 */
public class Uczen implements java.io.Serializable {

	private Integer idUczen;
	private String imie;
	private String nazwisko;
	private String pesel;
	private String haslo;
	private Set<Klasa> klasas = new HashSet<Klasa>(0);
	private Set<Oceny> ocenies = new HashSet<Oceny>(0);

	public Uczen() {
	}

	public Uczen(String imie, String nazwisko, String pesel, String haslo) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.haslo = haslo;
	}

	public Uczen(String imie, String nazwisko, String pesel, String haslo,
			Set<Klasa> klasas, Set<Oceny> ocenies) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.haslo = haslo;
		this.klasas = klasas;
		this.ocenies = ocenies;
	}

	public Integer getIdUczen() {
		return this.idUczen;
	}

	public void setIdUczen(Integer idUczen) {
		this.idUczen = idUczen;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public Set<Klasa> getKlasas() {
		return this.klasas;
	}

	public void setKlasas(Set<Klasa> klasas) {
		this.klasas = klasas;
	}

	public Set<Oceny> getOcenies() {
		return this.ocenies;
	}

	public void setOcenies(Set<Oceny> ocenies) {
		this.ocenies = ocenies;
	}

}