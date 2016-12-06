package patterns.design.iterator;

/*
 * classe concreta che implementa l'interfaccia Aggregate
 */

public class NameRepository implements Container {

	public String names[] = {"simone", "morena", "chiara"};
	
	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}
	
	/*
	 * abbiamo costruito una classe astratta name iterator
	 * che implementa l'iteratore in maniera tale da nascondere
	 * al client l'implementazione e la navigazione di elementi aggregati
	 * che sono names[].
	 */
	
	private class NameIterator implements Iterator {
		
		int index;
		
		@Override
		public boolean hasNext() {
			if (index < names.length) {
				return true;
			}
			
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return names[index++];
			}
			
			return null;
		}

		@Override
		public Object first() {
			return names[0];
		}

		@Override
		public Object currentItem() {
			return names[index];
		}
		
	}

}
