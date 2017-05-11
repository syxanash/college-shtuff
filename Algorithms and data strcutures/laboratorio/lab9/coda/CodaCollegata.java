package lab9.coda;

import lab9.pila.EccezioneStrutturaVuota;

public class CodaCollegata implements Coda {
	private Record inizio, fine = null;

	private class Record {
		Object elem;
		Record next;

		public Record(Object e) {
			this.elem = e;
			this.next = null;
		}
	}

	@Override
	public boolean isEmpty() {
		return inizio == null;
	}

	@Override
	public void enqueue(Object elem) {
		if (isEmpty()) {
			inizio = fine = new Record(elem);
		} else {
			fine.next = new Record(elem);
			fine = fine.next;
		}
	}

	@Override
	public Object first() throws EccezioneStrutturaVuota {
		if (isEmpty()) {
			throw new EccezioneStrutturaVuota();
		}

		return inizio.elem;
	}

	@Override
	public void dequeue() throws EccezioneStrutturaVuota {
		if (isEmpty()) {
			throw new EccezioneStrutturaVuota();
		}

		inizio = inizio.next;
	}
	
	public static void main(String... args) {
		Coda queue = new CodaCollegata();
		
		queue.enqueue("simone");
		queue.enqueue("morena");
		queue.enqueue("pippo");
		
		try {
			while(!queue.isEmpty()) {
				System.out.println(queue.first());
				queue.dequeue();
			}
			
			//queue.first();
		} catch (EccezioneStrutturaVuota e) {
			System.out.println("struttura vuota");
		}
	}
}
