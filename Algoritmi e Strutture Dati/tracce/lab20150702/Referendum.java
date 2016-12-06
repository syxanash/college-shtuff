package lab20150702;

import java.util.Iterator;

public class Referendum {
	protected Dictionary<Voto> referendum;

	private AddOnlyList<Cittadino> cittadini = new AddOnlyLinkedList<Cittadino>();
	private boolean aperto = false;

	public Referendum() {
		referendum = new ArrayDoubling<Voto>();
	}

	public void addCittadino(Cittadino citt) {
		cittadini.add(citt);
	}

	public AddOnlyList<Cittadino> registrati() {
		return cittadini;
	}

	public void apriReferendum() {
		aperto = true;
	}

	public void chiudiReferendum() {
		aperto = false;
	}

	public void vota(Cittadino citt, Voto voto) {
		if (aperto) {
			boolean trovato = false;
			Iterator<Cittadino> it = cittadini.iterator();

			while (it.hasNext()) {
				Cittadino current = it.next();

				if (current.compareTo(citt) == 0) {
					referendum.insert(voto, citt);
					trovato = true;
				}
			}
			
			if (!trovato)
				System.err.println(citt.cognome + " " + citt.nome + " cittadino non registrato!");
		} else {
			System.err.println("Referendum chiuso!");
		}
	}

	public AddOnlyList<Cittadino> votanti() {
		Iterator<Comparable> it = referendum.iterator();
		AddOnlyList<Cittadino> votanti = new AddOnlyLinkedList<Cittadino>();

		while (it.hasNext()) {
			Cittadino current = (Cittadino) it.next();

			votanti.add(current);
		}

		return votanti;
	}

	public int votiSI() {
		return searchVoti(Voto.si);
	}

	public int votiNo() {
		return searchVoti(Voto.no);
	}

	public int schedeNulle() {
		return searchVoti(Voto.nulla);
	}

	public int schedeBianche() {
		return searchVoti(Voto.bianca);
	}

	private int searchVoti(Voto valore) {
		Iterator<Comparable> it = referendum.iterator();

		int voti = 0;

		try {
			while (it.hasNext()) {
				Voto tempVoto = referendum.search(it.next());

				if (tempVoto == valore)
					voti++;
			}
		} catch (StrutturaVuotaException e) {
			System.err.println("Struttura è vuota!");
		}

		return voti;
	}
}
