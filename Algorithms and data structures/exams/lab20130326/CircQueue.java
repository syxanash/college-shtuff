package lab20130326;

public interface CircQueue<S> extends Iterable<S> {
	public void add(S e);
	public S value();
	public boolean isEmpty();
	public void rotateF();
	public int size();
	public boolean equals(CircQueue<S> s);
	public void stop();
	public void restart();
}
