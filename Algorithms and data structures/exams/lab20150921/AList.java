package lab20150921;

public class AList implements ListaSemplice {
	
	Record<Object> head, tail;
	Record<Object> pos;
	
	private class Record<T> {
		T item;
		
		Record<T> next, prev;
		
		public Record(T i) {
			item = i;
			next = prev = null;
		}
	}

	@Override
	public void add(Object o) {
		if (head == null) {
			head = new Record<Object>(o);
			pos = tail = head;
		} else {
			Record<Object> entry = new Record<Object>(o);
			
			entry.prev = tail;
			tail.next = entry;
			tail = entry;
		}
	}

	@Override
	public void reset() {
		pos = head;
	}

	@Override
	public Object next() {
		Object elem = pos.item;
		
		pos = pos.next;
		
		return elem;
	}

	@Override
	public boolean hasNext() {
		return pos != null;
	}
	
	public static void main(String... args) {
		ListaSemplice list = new AList();
		
		list.add("Simone");
		list.add("giovanni");
		list.add("morena");
		list.add("francesco");
		
		while(list.hasNext()) {
			System.out.println(list.next());
		}
		
		list.reset();
		System.out.println("and " + list.next());
	}

}
