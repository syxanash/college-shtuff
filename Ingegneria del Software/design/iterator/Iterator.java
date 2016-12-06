package patterns.design.iterator;

public interface Iterator {
	public boolean hasNext();
	public Object next();
	public Object first();
	public Object currentItem();
}
