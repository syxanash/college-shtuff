package lab20130221;

public interface AddOnlyList<S> extends Iterable<S> {
	public void add(S e);
	public void forward();
	public void backward();
}
