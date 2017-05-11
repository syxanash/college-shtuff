package lab20140904;

public class Skype implements Comparable<Skype> {
	private IndexedList<Pacchetto> comunicazione = new IndexedLL<Pacchetto>();
	private boolean gotLast = false;

	public void addPacchetto(Pacchetto pack) {
		comunicazione.addItem(pack, pack.identificativo);

		if (pack.ultimo) {
			gotLast = true;
		}
	}

	public boolean complete() {
		if (gotLast) {
			try {
				for (int i = 0; i < comunicazione.numberItems(); i++) {
					comunicazione.getItem(i);
				}

				return true;
			} catch (ItemNotPresentException e) {
			}
		}

		return false;
	}

	public String toString() {
		String msg = "";

		for (Pacchetto p : comunicazione) {
			msg += p.dati;
		}

		return msg;
	}

	@Override
	public int compareTo(Skype o) {
		if (o.complete() && this.complete()) {
			return o.toString().compareTo(this.toString());
		} else {
			throw new CommunicatioinNotComplete();
		}
	}
}
