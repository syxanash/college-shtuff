package lab20150224;

import java.util.Iterator;

public class Graduatoria {
	private ListaOrdinata graduatoria;
	
	public Graduatoria() {
		graduatoria = new WOListLinked();
	}
	
	public void aggG(float punteggio, Progetto progetto) {
		Record tempRecord = new Record(progetto, punteggio);
		
		graduatoria.insert(tempRecord);
	}
	
	public float primoV() {
		if (!this.eVuota()) {
			Iterator<Record> it = graduatoria.iterator();
			
			return it.next().punteggio;
		}
		
		return 0;
	}
	
	public Progetto primoP() {
		if (!this.eVuota()) {
			Iterator<Record> it = graduatoria.iterator();
			
			return it.next().progetto;
		}
		
		return null;
	}
	
	public ListaOrdinata restoG() {
		ListaOrdinata lista = new WOListLinked();
		
		Iterator<Record> it = graduatoria.iterator();
		
		while(it.hasNext()) {
			Record rec = it.next();
			
			if (!(rec.progetto.equals(this.primoP()) && rec.punteggio == this.primoV())) {
				lista.insert(rec);
			}
		}
		
		return lista;
	}
	
	public float media() {
		float media = 0;
		
		if (!this.eVuota()) {
			float somma = 0;
			
			Iterator<Record> it = graduatoria.iterator();
			
			while(it.hasNext()) {
				somma += it.next().punteggio;
			}
			
			media = somma / this.dim();
		}
		
		return media;
	}
	
	public boolean contenuta(ListaOrdinata prima, ListaOrdinata seconda) {
		return false;
		//TODO finish...
	}
	
	public int dim() {
		return ((WOListLinked) graduatoria).numElementi();
	}
	
	public boolean eVuota() {
		return this.dim() == 0;
	}
}
