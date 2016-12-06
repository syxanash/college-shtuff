package lab20150203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Elezione {
	protected Dictionary<Integer> listeElettorali;

	private int bianche = 0, nulle = 0, voti = 0, listeNum = 0;

	public void creaElezione(int n) {
		listeElettorali = new HashDict<Integer>(n);
	}

	public void aggiungiLista(ListaElettorale lista) {
		listeElettorali.insert(0, lista);
		
		listeNum++;
	}

	public void scrutinaVoto(Voto voto) {
		ListaElettorale tempLista = voto.voto();

		if (tempLista != null) {
			int currentVoto = listeElettorali.search(tempLista);

			currentVoto++;

			listeElettorali.delete(tempLista);
			listeElettorali.insert(currentVoto, tempLista);
		} else if (voto.bianca()) {
			bianche++;
		} else if (voto.nullo()) {
			nulle++;
		}
	}

	public int numVoti(ListaElettorale lista) {
		return listeElettorali.search(lista);
	}

	public int nulle() {
		return nulle;
	}

	public int bianche() {
		return bianche;
	}

	public ArrayList<Integer> elencoOrdinato() {
		int[] voti = new int[listeNum];
		int contListe = 0;

		Iterator<Comparable> it = listeElettorali.iterator();
		
		while(it.hasNext()) {
			ListaElettorale lista = (ListaElettorale) it.next();

			voti[contListe++] = listeElettorali.search(lista);
		}
		
		Arrays.sort(voti);
		ArrayList<Integer> stack = new ArrayList<Integer>();
		
		for(int v : voti) {
			stack.add(v);
		}

		return stack;
	}
}
