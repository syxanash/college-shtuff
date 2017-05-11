package lab20101117;

public class PilaDoubling<T> implements Pila<T> {

	private T[] pila = (T[]) new Object[1];
	private int size = 0;

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void push(T e) {
		pila[size] = e;

		size++;

		// raddoppio la dimensione dell'array
		if (size == pila.length) {
			T[] temp = (T[]) new Object[pila.length * 2];

			for (int i = 0; i < size; i++) {
				temp[i] = pila[i];
			}

			pila = temp;
		}
	}

	@Override
	public T top() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota(
					"non posso rimuovere, struttura vuota!");

		return pila[size - 1];
	}

	@Override
	public void pop() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota(
					"non posso aggiungere, struttura vuota!");

		size--;

		// dimezzo l'array se il numero di elementi scende dim/4
		if (size > 1 && size <= pila.length / 4) {
			T[] temp = (T[]) new Object[pila.length / 2];

			for (int i = 0; i < size; i++) {
				temp[i] = pila[i];
			}

			pila = temp;
		}
	}

}
