package lab8;

import lab7.StrutturaCollegata;

public class TabellaHashListeColl implements Dizionario {
	StrutturaCollegata S[];
	Hash fHash;
	
	public TabellaHashListeColl(int n, Hash f) {
		S = new StrutturaCollegata[(int) (n * 1.2)];
		fHash = f;
	}

	// definisco la classe per le coppie

	private class Coppia {
		public Object elem;
		public Comparable chiave;

		public Coppia(Object e, Comparable k) {
			this.elem = e;
			this.chiave = k;
		}
	}

	public void insert(Object e, Comparable k) {
		int pos = fHash.h(k, S.length);

		if (S[pos] == null) {
			S[pos] = new StrutturaCollegata();
		}

		S[pos].insert(e, k);

	}

	public void delete(Comparable k) {
		int pos = fHash.h(k, S.length);

		if (S[pos] == null) {
			return;
		}

		S[pos].delete(k);
	}

	public Object search(Comparable k) {
		int pos = fHash.h(k, S.length);
		
		return S[pos].search(k);
	}

	private static void inizializza(Dizionario d) {
		d.insert("Pippo", "080123456");
		d.insert("Gi�", "080654321");
		d.insert("Lisa", "081123456");
		d.insert("Gennarino", "081654321");
		d.insert("Emy", "347112233");
	}

	public static void main(String[] args) {
		Dizionario rubrica = new TabellaHashListeColl(6, new HashDivisione());

		inizializza(rubrica);

		// rubrica.delete("080654321");

		System.out.println(rubrica.search("081654321"));
		System.out.println(rubrica.search("080654321"));
		System.out.println(rubrica.search("081123456"));
	}
}
