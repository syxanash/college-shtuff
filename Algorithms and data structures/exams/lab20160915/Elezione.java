package lab20160915;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Elezione {
	protected Dictionary<Integer> listeElettorali;

	private int nulle = 0;
	private int bianche = 0;
	private int votiTotali = 0;

	private int nListe = 0;

	public Elezione(int n) {
		listeElettorali = new HashDict<Integer>(n);
	}

	public void aggiungiLista(ListaElettorale lista) {
		listeElettorali.insert(0, lista);
		nListe++;
	}

	public void scrutinaVoto(ListaElettorale lista, Voto voto) {
		if (listeElettorali.search(lista) != null) {
			int voti = listeElettorali.search(lista);

			if (voto.bianca()) {
				bianche++;
			} else if (voto.nullo()) {
				nulle++;
			} else if (voto.voto() == lista) {
				listeElettorali.delete(lista);
				listeElettorali.insert(++voti, lista);

				votiTotali++;
			}
		} else {
			System.err.println("Lista Elettorale inesistente!");
		}
	}

	public int numVoti() {
		return votiTotali;
	}

	public int nulle() {
		return nulle;
	}

	public int bianche() {
		return bianche;
	}

	public List<ListaElettorale> elencoOrdinato() {
		List<ListaElettorale> toReturn = new ArrayList<ListaElettorale>();

		int[] voti = new int[nListe];
		ListaElettorale[] liste = new ListaElettorale[nListe];

		int contListe = 0, contVoti = 0;

		// prelevo gli elementi dalla struttura e li inserisco negli array
		Iterator<Comparable> it = listeElettorali.iterator();
		while (it.hasNext()) {
			ListaElettorale currentList = (ListaElettorale) it.next();

			liste[contListe++] = currentList;
			voti[contVoti++] = listeElettorali.search(currentList);
		}

		// ordino gli array
		for (int i = 0; i < voti.length; i++) {
			for (int j = i + 1; j < voti.length; j++) {
				if (voti[i] < voti[j]) {
					int temp = voti[i];
					voti[i] = voti[j];
					voti[j] = temp;

					ListaElettorale tempList = liste[i];
					liste[i] = liste[j];
					liste[j] = tempList;
				}
			}
		}

		for (ListaElettorale l : liste) {
			toReturn.add(l);
		}

		return toReturn;
	}
}
