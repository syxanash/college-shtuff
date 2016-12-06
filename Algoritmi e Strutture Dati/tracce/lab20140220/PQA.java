package lab20140220;

import java.util.Iterator;

public class PQA<Item> implements PQ<Item> {

	protected Record coda, last;
	private int num;

	private class Record {
		public Item elem;
		public int priority;
		public Record next;

		public Record(Item i, int p) {
			this.elem = i;
			this.priority = p;

			next = null;
		}
	}

	private class PQAIterator<I> implements Iterator<I> {

		PQA<I>.Record queue;
		PQA<I>.Record pos;

		public PQAIterator(PQA<I>.Record coda) {
			queue = coda;

			pos = queue;
		}

		@Override
		public boolean hasNext() {
			return pos != null;
		}

		@Override
		public I next() {
			I elem = pos.elem;
			pos = pos.next;

			return elem;
		}

	}

	@Override
	public boolean isNew() {
		return coda == null;
	}

	@Override
	public void insert(Item item, int priority) {
		if (isNew()) {
			coda = new Record(item, priority);
			last = coda;
		} else {
			last.next = new Record(item, priority);
			last = last.next;
		}

		num++;
	}

	@Override
	public Item first() throws EccezioneStrutturaVuota {
		if (coda == null) {
			throw new EccezioneStrutturaVuota();
		}

		return coda.elem;
	}

	@Override
	public void delFirst() {
		coda = coda.next;

		num--;
	}

	@Override
	public void changePriority(Item item, int priority) {
		for (Record rec = coda;; rec = rec.next) {
			if (rec.elem.equals(item)) {
				rec.priority = priority;
				break;
			}
		}
	}

	@Override
	public int getPriority(Item item) {
		for (Record rec = coda;; rec = rec.next) {
			if (rec.elem.equals(item)) {
				return rec.priority;
			}
		}
	}

	@Override
	public int size() {
		return num;
	}

	@Override
	public Iterator<Item> iterator() {
		return new PQAIterator<Item>(coda);
	}

	public static void main(String... args) throws EccezioneStrutturaVuota {
		PQ<String> queue = new PQA<String>();

		queue.insert("init.d", 0);
		queue.insert("vim", 20);
		queue.insert("Gnome", 2);

		Iterator<String> it = queue.iterator();

		while (it.hasNext()) {
			String item = it.next();

			System.out.println(item + " - " + queue.getPriority(item));
		}

	}

}
