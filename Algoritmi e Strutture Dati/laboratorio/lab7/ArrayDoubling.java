package lab7;

public class ArrayDoubling implements Dizionario {
	private Coppia[] S = new Coppia[1];
	private int nElem = 0; // numero elementi effettivi nell'array
	
	private class Coppia {
		Comparable key;
		Object elem;
		
		Coppia(Object e, Comparable k) {
			this.elem = e;
			this.key = k;
		}
	}

	@Override
	public void insert(Object e, Comparable k) {
		if (nElem == S.length) {
			Coppia[] temp = new Coppia[2 * S.length];
			for (int i = 0; i < nElem; i++) {
				temp[i] = S[i];
			}
			
			S = temp;
		}
		
		S[nElem] = new Coppia(e, k);
		nElem++;
	}

	@Override
	public void delete(Comparable k) {
		// per la cancellazione prendo l'ultimo elemento nell'array
		// e lo vado a posizionare nella cella appena liberata
		// decrementando il numero totale di elementi non mi comparirà
		// due volte lo stesso elemento anche se è presente nella struttura
		// per due volte
		
		for (int i = 0; i < nElem; i++) {
			if (k.compareTo(S[i].key) == 0) {
				S[i] = S[nElem - 1];
				nElem--;
				
				break;
			}
		}
		
		if (nElem > 1 && nElem <= S.length / 4) {
			Coppia[] temp = new Coppia[S.length / 2];
			for (int i = 0; i < nElem; i++) {
				temp[i] = S[i];
			}
			
			S = temp;
		}
	}

	@Override
	public Object search(Comparable k) {
		for (int i = 0; i < nElem; i++) {
			if (k.compareTo(S[i].key) == 0) {
				return S[i].elem;
			}
		}
		
		return null;
	}

}
