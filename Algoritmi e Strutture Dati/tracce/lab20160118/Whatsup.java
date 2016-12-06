package lab20160118;


public class Whatsup {
	private IndexedList<Pacchetto> comunicazione = new IndexedAL<Pacchetto>();
	private int last = -1;

	public void addPacchetto(Pacchetto pack) {
		comunicazione.addItem(pack, pack.identificativo);

		if (pack.ultimo) {
			last = pack.identificativo;
		}
	}

	public boolean complete() {
		if (last < 0)
			return false;
		
		try {
			for (int i = 0; i < comunicazione.numberItems(); i++) {
				comunicazione.getElem(i);
			}
		} catch (ItemNotPresentException e) {
			return false;
		}

		return true;
	}

	public String toString() {
		String msg = "";

		for (Pacchetto data : comunicazione) {
			msg += data.dati;
		}

		return msg;
	}
}
