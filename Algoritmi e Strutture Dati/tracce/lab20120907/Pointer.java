package lab20120907;

public class Pointer<T> implements Posizione<T> {
	public T elem;
	public Pointer<T> next;
	
	public Pointer(T elem) {
		this.elem = elem;
		this.next = null;
	}
}
