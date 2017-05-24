package lab20090202;

public interface Tabella {
	public void insert(Object e, Comparable k);
	public Object search(Comparable k) throws EccezioneStrutturaVuota;
	public void delete(Comparable k);
}
