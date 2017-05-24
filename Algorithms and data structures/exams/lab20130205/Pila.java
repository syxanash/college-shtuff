package lab20130205;

public interface Pila<T> extends Iterable<T> {
	boolean isEmpty();
	void push(T e);
	T top();
	void pop();
}
