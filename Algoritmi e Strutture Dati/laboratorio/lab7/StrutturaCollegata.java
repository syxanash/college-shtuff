package lab7;

public class StrutturaCollegata implements Dizionario {

	private Record list = null;

	private final class Record {
		public Object elem;
		public Comparable chiave;

		public Record next;
		public Record prev;

		public Record(Object e, Comparable k) {
			elem = e;
			chiave = k;
			next = prev = null;
		}
	}

	public void delete(Comparable k) {
		if (list == null) {
			// controllo che la lista sia vuota in tal caso non faccio nulla
			return;
		} else if (list.next == list) { //FIXME potentially harmfull
			// controllo che nella lista ci sia un solo elemento,
			// pongo la lista a null
			list = null;
		} else if (list.chiave.compareTo(k) == 0) {
			// se l'elemento da eliminare e' il primo nella lista lo elimino
			// cambiando i puntatori al precedente ed al successivo
			Record a2 = list.next;

			a2.prev = list.prev;
			list.prev.next = a2;
			list = a2;
		} else {
			// altrimenti cerco iterativamente tutti gli altri puntatori
			// finche' non trovo quello che mi interessa
			// se non viene trovato non faccio nulla
			Record newElem = list.next;

			while (newElem != list) {
				if (newElem.chiave.compareTo(k) == 0) {
					Record a2 = newElem.next;
					a2.prev = newElem.prev;
					newElem.prev.next = a2;

					return;
				} else { // CONTROLLO l'elemento successivo
					newElem = newElem.next;
				}
			}

		}
	}

	public Object search(Comparable k) {
		if (list == null) {
			return null;
		} else if (list.chiave.compareTo(k) == 0) {
			return list.elem;
		} else {
			Record newElem = list.next;

			while (newElem != list) {
				if (newElem.chiave.compareTo(k) == 0) {
					return newElem.elem;
				} else {
					newElem = newElem.next;
				}
			}
		}

		return null;
	}

	public void insert(Object e, Comparable k) {
		Record p = new Record(e, k);

		if (list == null) {
			list = p.prev = p.next = p;
		} else {
			Record a2 = list.next;

			list.next = p;
			p.prev = list;
			a2.prev = p;
			p.next = a2;
		}

	}

	public static void main(String[] args) {
		Dizionario rubrica = new StrutturaCollegata();
		rubrica.insert("simone", "666");
		rubrica.insert("morena", "69");
		rubrica.insert("vito", "456");
		rubrica.insert("pippo", "0");
		rubrica.insert("antonio", "666");

		String key = "77777";

		System.out.println(rubrica.search(key));
		rubrica.delete(key);
		System.out.println(rubrica.search(key));
	}
}
