package lab20110215;

public class Cella<T> {
	T elem;
	
	Cella<T> next, prev;
	
	public Cella(T e) {
		this.elem = e;
		
		next = prev = null;
	}
}
