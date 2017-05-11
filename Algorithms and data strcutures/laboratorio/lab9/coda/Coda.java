package lab9.coda;

import lab9.pila.EccezioneStrutturaVuota;

public interface Coda {
	boolean isEmpty();
	void enqueue(Object elem);
	Object first() throws EccezioneStrutturaVuota;
	void dequeue() throws EccezioneStrutturaVuota;
}
