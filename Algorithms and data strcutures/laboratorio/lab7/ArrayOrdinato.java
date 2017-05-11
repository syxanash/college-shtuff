package lab7;

public class ArrayOrdinato implements Dizionario {

	private Coppia[] S = new Coppia[0];

	private class Coppia {
		public Object elem;
		public Comparable key;

		public Coppia(Object e, Comparable k) {
			this.elem = e;
			this.key = k;
		}
	}

	@Override
	public void insert(Object e, Comparable k) {
		Coppia[] temp = new Coppia[S.length + 1];

		int newPos = S.length;
		
		// copio in temp il vecchio array
		for (int i = 0; i < S.length; i++) {
			temp[i] = S[i];
		}

		// ora S avrà una posizione in più libera
		S = temp;
		
		// cerco la posizione dove la chiave è >= del valore in input
		for (int i = 0; i < S.length - 1; i++) {
			if (k.compareTo(S[i].key) <= 0) {
				newPos = i;
				break;
			}
		}

		// shifto gli elementi a partire dalla fine dell'array
		// senza sovrascrivere la posizione newPos
		for (int i = S.length - 1; i > newPos; i--) {
			S[i] = S[i - 1];
		}

		// inserirsco in newPos il nuovo valore coppia
		S[newPos] = new Coppia(e, k);
	}

	@Override
	public void delete(Comparable k) {
		int i = 0;
		int j = S.length;

		while (i < j) {
			int m = (i + j) / 2;

			if (k.compareTo(S[m].key) == 0) {
				Coppia[] temp = new Coppia[S.length - 1];

				for (int l = 0; l < m; l++)
					temp[l] = S[l];
				
				for (int l = m; l < S.length - 1; l++) {
					temp[l] = S[l + 1];
				}
				
				S = temp;
				
				return;
			} else if (k.compareTo(S[m].key) < 0) {
				j = m;
			} else {
				i = m + 1;
			}
		}
	}

	@Override
	public Object search(Comparable k) {
		int i = 0;
		int j = S.length;

		while (i < j) {
			int m = (i + j) / 2;

			if (k.compareTo(S[m].key) == 0) {
				return S[m].elem;
			} else {
				if (k.compareTo(S[m].key) < 0) {
					j = m;
				} else {
					i = m + 1;
				}
			}
		}

		return null;
	}
	
	public static void main(String[] args) {
		Dizionario diz = new ArrayOrdinato();
		
		diz.insert("simone", "45");
		diz.insert("francesco", "5");
		diz.insert("cataldo", "23");
		
		diz.delete("45");
		
		System.out.println(diz.search("45"));
	}

}
