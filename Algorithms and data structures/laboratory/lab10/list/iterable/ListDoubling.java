package lab10.list.iterable;

import java.util.Iterator;

import lab10.list.Indice;
import lab10.list.Posizione;

public class ListDoubling<T> implements Lista<T> {

	protected T[] L = (T[]) new Object[1];
	protected int n;

	public boolean isEmpty() {
		return n == 0;
	}

	public boolean endList(Posizione p) {
		return n == ((Indice) p).indice;
	}

	public T readList(Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException("Posizione non valida");

		return (T) L[((Indice) p).indice];
	}

	/*
	 * writeList differisce da insert in quanto esegue solo una riscrittura
	 * nella posizione p del valore e quindi una sostituizine del valore
	 * attualmente presente nella lista
	 */

	public void writeList(T e, Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException("Posizione non valida");

		L[((Indice) p).indice] = e;
	}

	public Posizione firstList() {
		return new Indice();
	}

	public Posizione succ(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(((Indice) p).indice
					+ " e' ultima posizione della lista");

		// creiamo un nuova nuova posizione contente
		// un valore incrementato di una unita' rispetto
		// al valore presente come parametro formale del metodo

		Indice pos = new Indice();
		pos.indice = ((Indice) p).indice + 1;

		return pos;
	}

	public Posizione pred(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException(((Indice) p).indice
					+ " e' prima posizione della lista");

		Indice pos = new Indice();
		pos.indice = ((Indice) p).indice - 1;

		return pos;
	}

	// aggiunge un elemento alla fine della lista

	public void insert(T e, Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di inserimento non valida");

		for (int i = n; i > ((Indice) p).indice; i--) {
			L[i] = L[i - 1];
		}

		L[((Indice) p).indice] = e;

		n++;

		if (n == L.length) {
			T[] temp = (T[]) new Object[L.length * 2];

			for (int i = 0; i < n; i++) {
				temp[i] = L[i];
			}

			L = temp;
		}
	}

	public void remove(Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di rimozione non valida");

		for (int i = ((Indice) p).indice; i < n; i++) {
			L[i] = L[i + 1];
		}

		n--;

		if (n > 1 && n == (L.length / 4)) {
			T[] temp = (T[]) new Object[L.length / 2];

			for (int i = 0; i < n; i++) {
				temp[i] = L[i];
			}

			L = temp;
		}
	}

	// metodo usato esclusivamente per controllare che la posizione
	// inserita come parametro rientri nei valori posizionali
	// dell'array effettivamente creato.

	protected boolean checkPosition(Posizione p) {
		if (((Indice) p).indice < 0 || ((Indice) p).indice > n)
			return false;
		else
			return true;
	}

	public Iterator iterator() {
		return new ListIterator(this);
	}

}
