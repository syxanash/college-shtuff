package patterns.design.iterator;

/*
 * classe AGGREGATE che fornisce l'interfaccia
 * al client per utilizzare l'iterator della classe
 * concreta
 */

public interface Container {
	public Iterator getIterator();
}
