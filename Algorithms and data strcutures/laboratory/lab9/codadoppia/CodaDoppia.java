package lab9.codadoppia;

import lab9.pila.EccezioneStrutturaVuota;

public interface CodaDoppia {
	boolean isEmpty();
	
	void enqueue(Object elem);					    // inserisci alla fine
	void dequeue() throws EccezioneStrutturaVuota;  // rimuovi valore iniziale
	Object first() throws EccezioneStrutturaVuota;  // leggi valore iniziale
	
	void push(Object elem);                      // inserisci dalla fine
	void pop()   throws EccezioneStrutturaVuota; // rimuovi dalla fine
	Object top() throws EccezioneStrutturaVuota; // leggi valore finale
}
