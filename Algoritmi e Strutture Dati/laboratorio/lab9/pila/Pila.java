package lab9.pila;

public interface Pila<T> {
	boolean isEmpty();
	void push(T elem);
	T top() throws EccezioneStrutturaVuota;
	void pop() throws EccezioneStrutturaVuota;
}
