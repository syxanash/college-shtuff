package lab10.list;

public class ListDoubling implements Lista {
	
	private Object[] L = new Object[1];
	private int n = 0;
	
	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public boolean endList(Posizione p) {
		return ((Indice) p).indice == n;
	}

	@Override
	public Posizione firstList() {
		return new Indice();
	}

	@Override
	public Posizione succ(Posizione p) {
		if (endList(p)) {
			throw new IndexOutOfBoundsException(((Indice) p).indice + " e' ultima posizione della lista");
		}
		
		Indice pos = new Indice();
		pos.indice = ((Indice) p).indice + 1;
		return pos;
	}

	@Override
	public Posizione pred(Posizione p) {
		if (p == firstList()) {
			throw new IndexOutOfBoundsException(((Indice) p).indice + " e' la prima posizione della lista");
		}
		
		Indice pos = new Indice();
		pos.indice = ((Indice) p).indice - 1;
		return pos;
	}
	
	protected boolean checkPosition(Posizione p) {
		if (((Indice) p).indice < 0 || ((Indice) p).indice > n) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object readList(Posizione p) {
		if (!checkPosition(p)) {
			throw new IndexOutOfBoundsException("Posizione non valida");
		}
		
		return L[((Indice) p).indice];
	}

	@Override
	public void writeList(Object e, Posizione p) {
		if (!checkPosition(p)) {
			throw new IndexOutOfBoundsException("Posizione non valida");
		}
		
		L[((Indice) p).indice] = e;
	}

	@Override
	public void insert(Object e, Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException("posizione di inserimento non valida");
		
		for (int i = n; i > ((Indice) p).indice; i--) {
			L[i] = L[i - 1];
		}
		
		L[((Indice) p).indice] = e;
		n++;
		
		if (n == L.length) {
			Object[] temp = new Object[L.length * 2];
			
			for (Indice pos = (Indice) firstList();
				 !endList(pos);
				 pos = (Indice) succ(pos)) {
				
				temp[pos.indice] = L[pos.indice];
			}
			
			L = temp;
		}
	}

	@Override
	public void remove(Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException("posizione di eliminazione errata");
		
		for(int i = ((Indice) p).indice; i < n; i++) {
			L[i] = L[i + 1];
		}
		
		n--;
		
		if (n > 1 && n <= L.length / 4) {
			Object[] temp = new Object[L.length / 2];
			
			for (Indice pos = (Indice) firstList(); !endList(pos); pos = (Indice) succ(pos)) {
				temp[pos.indice] = L[pos.indice];
			}
			
			L = temp;
		}
	}

}
