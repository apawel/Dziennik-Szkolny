package dziennik_szkolny.Model;

import java.util.List;

public interface NauczycielDao {
	public void add(Nauczyciel nauczyciel);
	public void edit(Nauczyciel nauczyciel);
	public void delete(int idNauczyciel);
	public Nauczyciel getNauczyciel(int idNauczyciel);
	public List<Nauczyciel> getAllNauczyciel();

}
