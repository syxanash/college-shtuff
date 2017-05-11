package lab20160225;

public class Messaggio {
	private ListaIndicizzata<Datagramma> messaggio = new ListaIndicizzataRD<Datagramma>();
	private int ultimo = -1;

	public void addDatagramma(Datagramma dat) {
		// se il datagramma ha un identificativo troppo grande rispetto
		// alla grandezza della struttura lista indicizzata
		// allora riempio le posizioni con valori nulli e aggiungo l'elemento
		// nella posizione desiderata

		if (dat.getIdentificativo() > messaggio.numberElements()) {
			for (int i = messaggio.numberElements(); i < dat
					.getIdentificativo(); i++) {
				messaggio.addElement(null, messaggio.numberElements());
			}
		}

		messaggio.addElement(dat, dat.getIdentificativo());

		// se il datagramma inserito è l'ultimo allora memorizzo la sua
		// posizione
		if (dat.isUltimo()) {
			ultimo = dat.getIdentificativo();
		}
	}

	public boolean completo() {
		//TODO non funziona
		boolean isLast = true;
		
		for (int i = 0; i <= ultimo; i++)
			if (!esisteDatagramma(i) || datagramma(i) == null)
				isLast = false;
		
		return isLast;
	}

	public boolean esisteDatagramma(int p) {
		try {
			return messaggio.getElement(p) != null;
		} catch (UndefinedElementException e) {
			return false;
		}
	}

	public Datagramma datagramma(int p) {
		try {
			return messaggio.getElement(p);
		} catch (UndefinedElementException e) {
			return null;
		}
	}

	public String toString() {
		String msg = "";

		for (int i = 0; i <= ultimo; i++) {
			msg += datagramma(i).getDati();
		}

		return msg;
	}
}
