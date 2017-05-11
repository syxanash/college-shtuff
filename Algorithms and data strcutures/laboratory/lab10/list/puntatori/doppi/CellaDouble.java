package lab10.list.puntatori.doppi;

public class CellaDouble {
	Object elemento;
	PuntatoreDouble successivo;
	PuntatoreDouble precedente;
	
	public CellaDouble() {		
		successivo = precedente = null;
	}
	
	public CellaDouble(Object e) {
		this();
		
		elemento = e;		
	}
}
