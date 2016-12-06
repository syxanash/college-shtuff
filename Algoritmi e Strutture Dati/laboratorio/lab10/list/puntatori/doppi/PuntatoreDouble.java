package lab10.list.puntatori.doppi;

import lab10.list.Posizione;

public class PuntatoreDouble implements Posizione {
	CellaDouble link;
	
	public PuntatoreDouble(CellaDouble c) {
		link = c;
	}
}
