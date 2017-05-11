package lab10.list.cursori_incompleta;

import lab10.list.Lista;
import lab10.list.Posizione;

public class CursorList implements Lista {
	public static final int MAXLUNG = 100;

	public class Cella {
		public Object elemento;
		public Posizione successivo;

		public Cella(Object elemento, Posizione successivo) {
			this.elemento = elemento;
			this.successivo = successivo;
		}
	}

	private static Cursore listaLibera = new Cursore(1);
	private Cursore inizioLista = null;

	private static Cella[] spazio = new Cella[MAXLUNG];

	static {
		int i;
		spazio[0] = (new CursorList()).new Cella(null, new Cursore(0));
		
		for (i = 1; i < spazio.length - 1; i++) {
			spazio[i] = (new CursorList()).new Cella(null, new Cursore(i + 1));
		}
		
		spazio[i] = (new CursorList()).new Cella(null, new Cursore(0));
	}

	@Override
	public boolean isEmpty() {
		return inizioLista == null;
	}

	@Override
	public Posizione firstList() {
		return new Cursore(0);
	}

	@Override
	public Object readList(Posizione p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeList(Object e, Posizione p) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean endList(Posizione p) {
		int indice = ((Cursore) p).cursore;
		
		if (isEmpty()) {
			return true;
		} else if (indice == 0) {
			return false;
		} else {
			return ((Cursore) spazio[indice].successivo).cursore == 0;
		}
		
		
	}

	@Override
	public Posizione succ(Posizione p) {
		int indice = ((Cursore) p).cursore;
		
		if (endList(p))
			throw new IndexOutOfBoundsException("fine lista!");
		
		if (indice == 0) {
			return inizioLista;
		} else {
			return spazio[indice].successivo;
		}
	}

	@Override
	public Posizione pred(Posizione p) {
		int indice = ((Cursore) p).cursore;
		
		if (indice == 0)
			throw new IndexOutOfBoundsException("Inizio lista");
		
		Posizione prec = firstList();
		
		if (indice == inizioLista.cursore)
			return prec;
		
		while(!endList(prec)) {
			if (((Cursore) succ(prec)).cursore == indice) {
				return prec;
			} else {
				prec = succ(prec);
			}
		}
		
		throw new IndexOutOfBoundsException("Posizione invalida");
	}

	@Override
	public void insert(Object e, Posizione p) {
		int indice = ((Cursore) p).cursore;
		int primaPosLibera = listaLibera.cursore;
		
		Cursore temp;
		
		if (!isEmpty()) {
			temp = (Cursore) spazio[primaPosLibera].successivo;
			spazio[primaPosLibera].elemento = e;
			
			if (indice == 0) {
				spazio[primaPosLibera].successivo = inizioLista;
				inizioLista = listaLibera;
			} else {
				spazio[primaPosLibera].successivo = spazio[indice].successivo;
				spazio[indice].successivo = listaLibera;
			}
			
			listaLibera = temp;
		} else { // lista vuota
			inizioLista = listaLibera;
			listaLibera = (Cursore) spazio[primaPosLibera].successivo;
			spazio[primaPosLibera].elemento = e;
			spazio[primaPosLibera].successivo = new Cursore(0);
		}
	}

	@Override
	public void remove(Posizione p) {
		// TODO Auto-generated method stub

	}

}
