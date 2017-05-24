package lab20101117;

public interface Pila<T> {
	public boolean isEmpty();
	public void push(T e);
	public T top() throws EccezioneStrutturaVuota;
	public void pop() throws EccezioneStrutturaVuota;
}
