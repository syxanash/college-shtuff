package lab20140923;

public interface CircList<T> extends Iterable<T> {
	void addCircList(T item);
	void delCircList() throws EccezioneStrutturaVuota;
	T value() throws EccezioneStrutturaVuota;
	boolean isEmpty();
	void ruotaAvanti();
	void ruotaIndietro();
}
