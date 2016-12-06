package lab20160711;

import java.util.Iterator;

public class PQA<Item> implements PQ<Item> {
	protected Record coda;
	private int size = 0;

	private class Record {
		public Item elem;
		public int priority;
		public Record next;

		public Record(Item e, int p) {
			this.elem = e;
			this.priority = p;
			this.next = null;
		}
	}
	
	private class PQAIterator implements Iterator<Item> {

		Record queue;
		int n, pos;
		
		public PQAIterator(Record queue, int n) {
			this.queue = queue;
			this.n = n;
			this.pos = 0;
		}
		
		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public Item next() {
			Item elem = queue.elem;
			queue = queue.next;
			pos++;
			
			return elem;
		}
		
	}

	@Override
	public boolean isNew() {
		return coda == null;
	}

	@Override
	public void insert(Item item, int priority) {
		Record entry = new Record(item, priority);

		if (this.isNew()) {
			coda = entry;
		} else {
			if (priority <= coda.priority) {
				entry.next = coda;
				coda = entry;
			} else {
				for (Record rec = coda; rec != null; rec = rec.next) {
					if (rec.next == null) {
						rec.next = entry;
						break;
					}

					if (priority <= rec.next.priority) {
						entry.next = rec.next;
						rec.next = entry;

						break;
					}
				}
			}
		}
		
		size++;
	}

	@Override
	public Item first() {
		if (this.isNew())
			throw new StrutturaVuotaException();
		
		return coda.elem;
	}

	@Override
	public void delFirst() {
		if (this.isNew())
			throw new StrutturaVuotaException();
		
		coda = coda.next;
		
		size--;
	}

	@Override
	public void changePriority(Item item, int priority) {
		if (this.isNew()) {
			throw new StrutturaVuotaException();
		}
		
		// cerco l'elemento e lo cancello
		if (coda.elem == item) {
			coda = coda.next;
		} else {
			for (Record rec = coda; rec != null; rec = rec.next) {
				if (rec.next == null && rec.elem != item)
					throw new ItemNotFoundException();
				
				if (rec.next.elem == item) {
					rec.next = rec.next.next;
					break;
				}
			}
		}
		
		// inserisco l'elemento nella nuova posizione
		this.insert(item, priority);
	}

	@Override
	public int getPriority(Item item) {
		if (this.isNew())
			throw new StrutturaVuotaException();
		
		if (coda.elem.equals(item)) {
			return coda.priority;
		} else {
			for (Record rec = coda; rec != null; rec = rec.next) {
				if (rec.next == null && !rec.elem.equals(item))
					throw new ItemNotFoundException();
				
				if (rec.next.elem.equals(item)) {
					return rec.next.priority;
				}
			}
		}
		
		return 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new PQAIterator(coda, size);
	}

	public static void main(String... args) {
		PQA<String> queue = new PQA<String>();

		queue.insert("simone", 4);
		queue.insert("luca", 1);
		queue.insert("gianni", 5);
		queue.insert("morena", 2);
		
		System.out.println("size: " + queue.size());
		
		Iterator<String> it = queue.iterator();
		
		while(it.hasNext()) {
			System.out.println(queue.getPriority(it.next()));
		}
		
		queue.delFirst();
		queue.changePriority("gianni", 1);
		
		System.out.println(queue.first());
	}

}
