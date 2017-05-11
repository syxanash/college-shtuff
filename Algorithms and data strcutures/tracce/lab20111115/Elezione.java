package lab20111115;

import java.util.Arrays;
import java.util.LinkedList;

public class Elezione {
	protected Dictionary<Integer> listeElettorali;

	private int nulle = 0;
	private int bianche = 0;

	public Elezione() {
		listeElettorali = new LinkedDict<Integer>();
	}

	public void aggiungiLista(ListaElettorale list) {
		listeElettorali.insert(0, list);
	}

	public void scrutinaVoto(Voto v) {
		if (v.voto() != null) {
			ListaElettorale currentLista = v.voto();

			int currentVoto = this.numVoti(currentLista);
			listeElettorali.delete(currentLista);
			listeElettorali.insert(currentVoto + 1, currentLista);
		} else if (v.nullo()) {
			nulle++;
		} else if (v.bianca()) {
			bianche++;
		}
	}

	public int numVoti(ListaElettorale list) {
		return listeElettorali.search(list);
	}

	public int nulle() {
		return nulle;

	}

	public int bianche() {
		return bianche;
	}
	
	public String elencoOrdinato() {
		String res = "";
		
		LinkedList<Integer> elenco = new LinkedList<Integer>();
		
		for (int voto : listeElettorali) {
			elenco.add(voto);
		}
		
		Object[] sorted = elenco.toArray();
		Arrays.sort(sorted);
		
		for (int i = 0; i < sorted.length; i++)
			res += " " + sorted[i];
		
		return res;
	}
}
