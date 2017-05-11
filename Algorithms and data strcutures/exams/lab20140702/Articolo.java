package lab20140702;

public class Articolo {
	AddOnlyList<String> autori = new VectorList<String>();
	int volume;
	
	public Articolo() {
		autori = new VectorList<String>();
	}
	
	public Articolo(AddOnlyList<String> autori, int volume) {
		this.autori = autori;
		this.volume = volume;
	}
}
