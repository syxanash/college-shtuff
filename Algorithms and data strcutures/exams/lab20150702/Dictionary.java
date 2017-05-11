package lab20150702;

public interface Dictionary<S> extends Iterable<Comparable> {
	public void insert(S e, Comparable k);
	public void delete(Comparable k) throws StrutturaVuotaException;
	public S search(Comparable k) throws StrutturaVuotaException;
}
