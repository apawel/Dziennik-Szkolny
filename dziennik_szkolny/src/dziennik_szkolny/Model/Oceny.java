package dziennik_szkolny.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name="Oceny")
@Table (name="Oceny")
public class Oceny {

	@Id
	@Column (name="idOceny")
	int idOceny ;
	@Column (name="wartosc")
	int wartosc;
	@Column (name="waga")
	int waga;
	@Column (name="data_wystawienia")
	String data_wystawienia;
	@Column (name="komentarz")
	String komentarz;
	@Column (name="Uczen_idUczen")
	int Uczen_idUczen;
	@Column (name="Klasa_has_przedmiot_Klasa_has_PrzedmiotID")
	int Klasa_has_przedmiot_Klasa_has_PrzedmiotID;


	
}
