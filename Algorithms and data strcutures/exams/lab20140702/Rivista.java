package lab20140702;

public class Rivista {
	protected Dictionary<String, Articolo> articoli;
	protected Dictionary<Integer, Boolean> volumi;
	
	public Rivista() {
		articoli = new LinkedList<String, Articolo>();
		volumi = new LinkedList<Integer, Boolean>();
	}
	
	public boolean rivistaNuova() {
		return articoli == null;
	}
	
	public void addArt(String titolo, int volume) {
		// setto a null gli autori
		Articolo temp = new Articolo(new VectorList<String>(), volume);
		
		volumi.insert(volume, false);
		articoli.insert(titolo, temp);
	}
	
	public void addAut(String titolo, String autore) {
		try {
			if (!pubblicato(articoli.search(titolo).volume))
				articoli.search(titolo).autori.add(autore);
		} catch (StrutturaVuotaException e) {
			System.err.println("non esistono articoli nella rivista!");
		}
	}
	
	public void pubblicaVol(int volume) {
		volumi.insert(volume, true);
	}
	
	public boolean pubblicato(int volume) {
		try {
			return volumi.search(volume);
		} catch (StrutturaVuotaException e) {
			System.err.println("volume inesistente!");
		}
		
		return false;
	}
}
