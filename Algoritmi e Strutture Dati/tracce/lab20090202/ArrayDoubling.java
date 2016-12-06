package lab20090202;

public class ArrayDoubling implements Tabella {
	
	private Entry[] S = new Entry[1];
	private int nElem = 0;
	
	private class Entry {
		Object elem;
		Comparable key;
		
		Entry(Object e, Comparable k) {
			this.elem = e;
			this.key = k;
		}
	}

	@Override
	public void insert(Object e, Comparable k) {
		if (nElem == S.length) {
			Entry[] temp = new Entry[S.length * 2];
			for (int i = 0; i < nElem; i++) {
				temp[i] = S[i];
			}
			
			S = temp;
		}
		
		S[nElem] = new Entry(e, k);
		nElem++;
	}

	@Override
	public Object search(Comparable k) throws EccezioneStrutturaVuota {
		if (nElem == 0) throw new EccezioneStrutturaVuota("vuota");
		
		for (int i = 0; i < nElem; i++) {
			if (k.compareTo(S[i].key) == 0) {
				return S[i].elem;
			}
		}
		
		return null;
	}

	@Override
	public void delete(Comparable k) {
		for (int i = 0; i < nElem; i++) {
			if (k.compareTo(S[i].key) == 0) {
				S[i] = S[nElem - 1];
				nElem--;
				
				break;
			}
		}
		
		if (nElem > 1 && nElem <= S.length / 4) {
			Entry[] temp = new Entry[S.length / 2];
			for (int i = 0; i < nElem; i++) {
				temp[i] = S[i];
			}
			
			S = temp;
		}
	}

}
