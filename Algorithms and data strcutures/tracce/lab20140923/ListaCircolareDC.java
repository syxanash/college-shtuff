package lab20140923;

import java.util.Iterator;

public class ListaCircolareDC<T> implements CircList<T> {

	private Record<T> items;

	private class Record<I> {
		I elem;
		Record<I> next;
		Record<I> prev;

		public Record(I elem) {
			this.elem = elem;
			next = prev = this;
		}
	}

	private class ListaCircolareDCIterator<I> implements Iterator<I> {

		ListaCircolareDC<I>.Record<I> items;
		ListaCircolareDC<I>.Record<I> pos;

		public ListaCircolareDCIterator(ListaCircolareDC<I>.Record<I> items) {
			this.items = items;
			pos = this.items;
		}

		@Override
		public boolean hasNext() {
			return pos != items.prev;
		}

		@Override
		public I next() {
			I item = pos.elem;
			pos = pos.next;

			return item;
		}
	}

	@Override
	public void addCircList(T item) {
		if (items == null) {
			items = new Record(item);
		} else {
			Record<T> newElem = new Record(item);
			Record<T> pos = items.prev;

			pos.next = newElem;
			items.prev = newElem;
			newElem.next = items;
			newElem.prev = pos;
		}
	}

	@Override
	public void delCircList() throws EccezioneStrutturaVuota {
		if (items == null)
			throw new EccezioneStrutturaVuota();
		
		if (items.next == items) {
			items = null;
		} else {
			Record<T> temp = items.next;
			temp.prev = items.prev;
			temp.prev.next = temp;

			items = temp;
		}
	}

	@Override
	public T value() throws EccezioneStrutturaVuota {
		if (items == null)
			throw new EccezioneStrutturaVuota();
		
		return items.elem;
	}

	@Override
	public boolean isEmpty() {
		return items == null;
	}

	@Override
	public void ruotaAvanti() {
		items = items.next;
	}

	@Override
	public void ruotaIndietro() {
		items = items.prev;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListaCircolareDCIterator<T>(items);
	}

	public static void main(String... args) {
		CircList<String> bussola = new ListaCircolareDC<String>();
		bussola.addCircList("nord");
		bussola.addCircList("nord-est");
		bussola.addCircList("est");
		bussola.addCircList("sud-est");
		bussola.addCircList("sud");
		bussola.addCircList("sud-ovest");
		bussola.addCircList("ovest");
		bussola.addCircList("nord-ovest");

		Iterator<String> it = bussola.iterator();

		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println(it.next());

		bussola.ruotaAvanti();
		bussola.ruotaAvanti();

		try {
			bussola.delCircList();
		} catch (EccezioneStrutturaVuota e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		it = bussola.iterator();

		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println(it.next());
	}

}
