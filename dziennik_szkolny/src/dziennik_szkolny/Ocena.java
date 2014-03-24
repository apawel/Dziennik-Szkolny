package dziennik_szkolny;

public class Ocena {

	String komentarz;
	int ocena;
	float waga;
	
	public Ocena(String komentarz, int ocena, float waga) {
		this.komentarz = komentarz;
		this.ocena = ocena;
		this.waga = waga;
	}

	public Ocena(int ocena, float waga) {
		super();
		this.ocena = ocena;
		this.waga = waga;
	}

}
