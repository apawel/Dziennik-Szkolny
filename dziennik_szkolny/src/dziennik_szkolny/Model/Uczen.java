package dziennik_szkolny.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Uczen")
@Table (name="Uczen")
public class Uczen {
@Id
@Column (name="idUczen")
int idUczen;
@Column (name="imie")
String imie;
@Column (name="nazwisko")
String nazwisko;
@Column (name="pesel")
String pesel;
@Column (name="haslo")
String haslo;
}