package lab10.list.generic;

/*
 * creo una classe che implementa la lista con l'aggiunta del metodo add
 * che inserisce gli elementi in coda alla lista ma
 * estende gli stessi metodi di listdoubling che implementava a sua volta lista
 * senza il metodo add
 * 
 * questo e' un curioso caso di ereditarieta' multipla :-)
 */

public class ListDoublingArray<T> extends ListDoubling<T> implements ListaArray<T> {
	
	// aggiunge un elemento alla fine della lista

	public void add(T e) {
		L[n] = e;
		n++;

		if (n == L.length) {
			T[] temp = (T[]) new Object[L.length * 2];

			for (int i = 0; i < n; i++) {
				temp[i] = L[i];
			}

			L = temp;
		}
	}
}
