package dziennik_szkolny.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity (name="Klasa")
  
public class Klasa {
	@Id
	@Column (name="idKlasa")
	int idKlasa;
	@Column (name="nazwa")
	String nazwa;
	@Column (name="rozpoczecie")
	String rozpoczecie;
	@Column (name="zakonczenie")
	String zakonczenie;
	@Column (name="wychowawca")
	int wychowawca;
} 	 	
