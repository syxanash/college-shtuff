package lab20120705;

import java.util.Iterator;


public class Messaggio {
	private ListaIndicizzata<Datagramma> messaggio = new IndexedList<Datagramma>();
	private int ultimo = -1;

	public void addDatagramma(Datagramma dat) {
		messaggio.addElement(dat, dat.identificativo);

		if (dat.ultimo) {
			ultimo = dat.identificativo;
		}
	}

	public boolean completo() {
		if (ultimo < 0)
			return false;

		boolean isComplete = true;

		for (int i = 0; i < ultimo; i++)
			if (messaggio.isEmpty(i))
				isComplete = false;

		return isComplete;
	}

	public String toString() {
		String msg = "";

		Iterator<Datagramma> it = messaggio.iterator();
		
		while(it.hasNext()) {
			Datagramma datag = it.next();
			
			if (datag == null)
				continue;
			
			msg += datag.dati;
		}

		return msg;
	}

	public boolean confronta(Messaggio msg) {
		if (!this.completo() && !msg.completo())
			return false;

		return this.toString().compareTo(msg.toString()) == 0;
	}
}
