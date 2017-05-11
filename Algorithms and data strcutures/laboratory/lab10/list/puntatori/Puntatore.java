package lab10.list.puntatori;

import lab10.list.Posizione;

public class Puntatore implements Posizione {
	public Cella link;

	public Puntatore(Cella c) {
		link = c;
	}

}
