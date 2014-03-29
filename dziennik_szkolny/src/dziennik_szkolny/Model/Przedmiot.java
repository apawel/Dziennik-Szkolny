package dziennik_szkolny.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
@Entity (name="Przedmiot")
@Table (name="Przedmiot")
public class Przedmiot {
	
/**
 * @Embedded - > pole jako Obiekt jakiego typu
 * @AttributeOverride() -> nadpusuje spos\ob dostania si\e do p\ol obiekt\ow
 * @ElementCollection adnotacja kt\ora m\owi \ze dane pole ma by\c zapisane do bazy danych(kolekcja)
 * @JoinTable zwyk\ly join
 * @CollectionId -> od hibernate
 */
@Id
@Column (name="idPrzedmiot")
int idPrzedmiot;
@Column (name="nazwa")
String nazwa;
@Column (name="Nauczyciel_idNauczyciel")
int Nauczyciel_idNauczyciel;
}
