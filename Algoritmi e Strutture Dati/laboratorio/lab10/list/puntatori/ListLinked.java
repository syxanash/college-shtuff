package lab10.list.puntatori;

import lab10.list.Lista;
import lab10.list.Posizione;

public class ListLinked implements Lista {

	private Puntatore inizioLista = null;

	@Override
	public boolean isEmpty() {
		return inizioLista == null;
	}

	@Override
	public Object readList(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");

		if (p == firstList()) {
			return ((Cella) inizioLista.link).elemento;
		} else {
			return ((Puntatore) p).link.successivo.link.elemento;
		}
	}

	@Override
	public void writeList(Object e, Posizione p) {
		// TODO Auto-generated method stub

	}

	// per convenzione usiamo la prima posizione come null
	// cosi' facendo se confrontiamo la posizione con firstList
	// in caso positivo restituiamo inizioLista (prima cella della lista)
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
			return ((Puntatore) p).link.successivo == null;
		}
	}

	@Override
	public Posizione succ(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista nonvalida");

		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");

		if (p == firstList())
			return inizioLista;
		else
			return ((Puntatore) p).link.successivo;
	}

	@Override
	public Posizione pred(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("lista vuota");

		if (p == firstList())
			throw new IndexOutOfBoundsException("posizione errata!");

		// non conoscendo la posizione precedente avremo una complessita
		// di tipo O(n) poichè dobbiamo scorrere tutta la lista fino al punto p
		
		Posizione tempPunt;
		
		for (tempPunt = inizioLista; ((Puntatore) tempPunt).link.successivo != p;) {
			tempPunt = ((Puntatore) tempPunt).link.successivo;
		}
		
		//TOFIX probabilmente è sbagliato...

		return tempPunt;
	}

	@Override
	public void insert(Object e, Posizione p) {
		Puntatore temp, q;

		if (!isEmpty()) {
			// controllo se la posizione p e' primo elemento della lista
			if (p == firstList()) {
				temp = inizioLista; // memorizzo l'head vecchio
				inizioLista = new Puntatore(new Cella(e)); // assegno un nuovo
															// head
				inizioLista.link.successivo = temp; // collego il nuovo head al
													// vecchio head
			} else {
				// l'elemento e' da inserire tra due celle
				temp = ((Puntatore) p).link.successivo;
				q = new Puntatore(new Cella(e));
				((Puntatore) p).link.successivo = q;
				q.link.successivo = temp;
			}
		} else {
			// la lista e' vuota
			inizioLista = new Puntatore(new Cella(e));
		}
	}

	@Override
	public void remove(Posizione p) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("La lista e' vuota!");
		} else {
			// controllo il primo elemento della lista
			
			if (p == firstList()) {
				inizioLista = ((Puntatore) p).link.successivo;
			} else {
				//TODO FINIRE
			}
		}

	}

}
