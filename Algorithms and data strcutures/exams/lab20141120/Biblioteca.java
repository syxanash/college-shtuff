package lab20141120;

public class Biblioteca extends BibliotecaAbs {
	public Biblioteca(ArrayDict<String, Record> diz) {
		volumi = diz;
	}

	public boolean bibliotecaVuota() {
		return volumi.n == 0;
	}

	public void addVol(String pos, Record vol) {
		volumi.insert(pos, vol);
	}

	public Volume volume(String pos) {
		return volumi.search(pos).volume;
	}

	public void prestito(String pos) {
		volumi.search(pos).prestato = true;
	}

	public void restituzione(String pos) {
		volumi.search(pos).prestato = false;
	}

	public boolean prestato(String pos) {
		return volumi.search(pos).prestato;
	}

	public String posizione(Record vol) {
		String titolo = vol.volume.titolo;

		for (String pos : this.volumi) {
			Record rec = volumi.search(pos);

			if (rec.volume.titolo.equals(titolo))
				return pos;
		}
		return null;
	}
}
