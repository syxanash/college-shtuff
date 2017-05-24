package lab20160225;

public class ListaIndicizzataRD<T> implements ListaIndicizzata<T> {
	
	private T[] items = (T[]) new Object[1];
	private int num = 0;
	
	@Override
	public boolean isEmpty(int i) {
		return num == 0;
	}

	@Override
	public void addElement(T e, int i) {		
		items[i] = e;
		num++;
		
		if (num == items.length) {
			T[] temp = (T[]) new Object[items.length * 2];
			
			for (int j = 0; j < num; j++) {
				temp[j] = items[j];
			}
			
			items = temp;
		}
	}

	@Override
	public T getElement(int i) throws UndefinedElementException {
		if (i >= num)
			throw new UndefinedElementException();
		
		if (items[i] == null)
			throw new UndefinedElementException();
		
		return items[i];
	}

	@Override
	public int numberElements() {
		return num;
	}

}
