package lab20120210;

public interface CircList<S> extends Iterable<S> {
	public void add(S e);
	public S value();
	public boolean isEmpty();
	public void rotateF();
	public int size();
	public boolean equals(CircList<S> s);
}
