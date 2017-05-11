package lab20120221;

import java.util.LinkedList;
import java.util.List;

public class Biblioteca {
	protected Dictionary<Volume> library;

	private int size = 0;
	private List<String> codici;

	public Biblioteca(int n) {
		library = new TabellaHashLL<Volume>(n, new HashDivisione());
		size = n;
		codici = new LinkedList<String>();
	}

	public int volumi() {
		int n = 0;

		for (Volume v : library) {
			n++;
		}

		return n;
	}

	public void registra(String cod, String titolo, String autore, String anno) {
		library.insert(new Volume(titolo, autore, anno, false), cod);
		codici.add(cod);
	}

	public String titolo(String cod) {
		return library.search(cod).getTitolo();
	}

	public String autore(String cod) {
		return library.search(cod).getAutore();
	}

	public String anno(String cod) {
		return library.search(cod).getAnno();
	}

	public List<String> codice(String titolo, String autore, String anno) {
		List<String> lista = new LinkedList<String>();

		for (String cod : codici) {
			if (library.search(cod).getTitolo().compareTo(titolo) == 0
					&& library.search(cod).getAutore().compareTo(autore) == 0
					&& library.search(cod).getAnno().compareTo(anno) == 0) {
				lista.add(cod);
			}
		}

		return lista;
	}
	
	public void prestito(String cod) {
		library.search(cod).setStato(true);
	}
	
	public boolean prestato(String cod) {
		return library.search(cod).getStato();
	}
	
	public int copie(String titolo, String autore, String anno) {
		int n = 0;
		
		for (Volume v : library) {
			if (v.getTitolo().compareTo(titolo) == 0 &&
					v.getAutore().compareTo(autore) == 0 && 
					v.getAnno().compareTo(anno) == 0 && v.getStato()) {
				n++;
			}
		}
		
		return n;
	}

}
