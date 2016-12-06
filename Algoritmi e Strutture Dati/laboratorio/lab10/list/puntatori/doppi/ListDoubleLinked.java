package lab10.list.puntatori.doppi;

import lab10.list.Lista;
import lab10.list.Posizione;

public class ListDoubleLinked implements Lista {

	private PuntatoreDouble inizioLista = null;

	@Override
	public boolean isEmpty() {
		return inizioLista == null;
	}

	@Override
	public Object readList(Posizione p) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("la lista è vuota!");
		}

		// non possiamo fare return ((PuntatoreDouble) p).link.elemento;
		// poichè dobbiamo controllare che il primo elemento della
		// lista non sia null

		if (p == firstList()) {
			return ((PuntatoreDouble) inizioLista).link.elemento;
		} else {
			// poichè identifichiamo il primo elemento con firstlist
			// che confrontato ci restituisce inizioLista (vedi succ)
			// la posizione p dovrà avere l'elemento successivo a p

			return ((PuntatoreDouble) p).link.successivo.link.elemento;
		}
	}

	@Override
	public void writeList(Object e, Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("la lista è vuota!");

		if (p == firstList()) {
			((PuntatoreDouble) inizioLista).link.elemento = e;
		} else {
			((PuntatoreDouble) p).link.successivo.link.elemento = e;
		}
	}

	@Override
	public Posizione firstList() {
		return null;
	}

	@Override
	public boolean endList(Posizione p) {
		if (isEmpty()) {
			return true;
		}

		// se non e' vuota e la posizione p e' la prima cella (cioe' null)
		// allora sicuramente non sara' l'ultima
		if (p == firstList()) {
			return false;
		} else {
			return ((PuntatoreDouble) p).link.successivo == null;
		}
	}

	@Override
	public Posizione succ(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista nonvalida");

		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");

		// se p e' il primo elemento della lista (ovvero null come convenzione)
		// allora restituisco l'head della lista (il secondo elemento
		// convenzionale)
		if (p == firstList())
			return inizioLista;
		else
			return ((PuntatoreDouble) p).link.successivo;
	}

	@Override
	public Posizione pred(Posizione p) {
		if (p == firstList())
			throw new IndexOutOfBoundsException(
					"non esiste nulla prima dell'elemento selezionato");

		if (isEmpty())
			throw new IndexOutOfBoundsException("la lista e' vuota");

		return ((PuntatoreDouble) p).link.precedente;
	}

	@Override
	public void insert(Object e, Posizione p) {
		PuntatoreDouble temp, doubleP, nuovo;

		if (!isEmpty()) {
			if (firstList() == p) {
				temp = inizioLista;
				inizioLista = new PuntatoreDouble(new CellaDouble(e));
				inizioLista.link.successivo = temp;
				temp.link.precedente = inizioLista;
			} else {
				nuovo = new PuntatoreDouble(new CellaDouble(e));
				doubleP = (PuntatoreDouble) p;
				temp = doubleP.link.successivo;

				nuovo.link.successivo = temp;

				// se temp è null vuol dire che double p
				// è l'ultimo elemento della lista
				if (temp != null) {
					// il nuovo elemento è fra due celle valide

					temp.link.precedente = nuovo;
				}

				doubleP.link.successivo = nuovo;
				nuovo.link.precedente = doubleP;
			}
		} else {
			inizioLista = new PuntatoreDouble(new CellaDouble(e));
		}
	}

	@Override
	public void remove(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("lista è vuota!");

		PuntatoreDouble nextP, doubleP, predP;

		if (p == firstList()) {
			nextP = ((PuntatoreDouble) inizioLista).link.successivo;
			inizioLista = nextP;
			inizioLista.link.precedente = null;
		} else {
			doubleP = ((PuntatoreDouble) p).link.successivo;
			nextP = doubleP.link.successivo;
			predP = doubleP.link.precedente;
			
			predP.link.successivo = nextP;
			
			if (nextP != null) {
				nextP.link.precedente = predP;				
			}
			
		}
	}

}
