package lab20130903;

import java.util.Iterator;

public class Biblioteca extends BibliotecaAbs {

	public Biblioteca(Dictionary<String, Record> volumi) {
		this.volumi = volumi;
	}

	@Override
	boolean bibliotecaVuota() {
		return volumi == null;
	}

	@Override
	void addVol(String posizione, Volume vol) {
		volumi.insert(posizione, new Record(vol, false));
	}

	@Override
	Volume volume(String posizione) {
		return volumi.search(posizione).volume;
	}

	@Override
	void prestito(String posizione) {
		if (volumi.search(posizione) != null)
			volumi.search(posizione).prestato = true;
	}

	@Override
	void restituzione(String posizione) {
		if (volumi.search(posizione) != null)
			volumi.search(posizione).prestato = false;
	}

	@Override
	boolean prestato(String posizione) {
		if (volumi.search(posizione) == null) {
			return false;
		} else {
			return volumi.search(posizione).prestato;
		}
	}

	@Override
	AddOnlyList<String> posizione(Volume vol) {
		Iterator<String> it = volumi.iterator();
		AddOnlyList<String> posizioni = new VectorList<String>();

		while (it.hasNext()) {
			String pos = it.next();

			if (volumi.search(pos).volume.compareTo(vol) == 0) {
				posizioni.add(pos);
			}
		}

		return posizioni;
	}

}
