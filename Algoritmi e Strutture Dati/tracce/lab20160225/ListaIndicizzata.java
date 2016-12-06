package lab20160225;

public interface ListaIndicizzata<T> {
	public boolean isEmpty(int i);
	public void addElement(T e, int i);
	public T getElement(int i) throws UndefinedElementException;
	public int numberElements();
}
