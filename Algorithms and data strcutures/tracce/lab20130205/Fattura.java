package lab20130205;

import java.util.Iterator;

public abstract class Fattura {
	Pila<Bene> beni;
	
	Persona venditore;
	Persona compratore;
	String data;
	int id;
	
	public Fattura(int id, String data, Persona venditore, Persona compratore) {
		this.id = id;
		this.data = data;
		this.venditore = venditore;
		this.compratore = compratore;
	}
	
	public void aggiungiBene(String bene, int quantita, double importo) {
		this.beni.push(new Bene(bene, quantita, importo));
	}
	
	public Bene ultimoBene() {
		return beni.top();
	}
	
	public int quantitaUltimoBene() {
		return beni.top().quantita;
	}
	
	public Double importoUltimoBene() {
		return beni.top().importo;
	}
	
	public void rimuoviUltimoBene() {
		beni.pop();
	}
	
	public float totaleImporto() {
		Iterator<Bene> it = beni.iterator();
		
		float tot = 0;
		
		while(it.hasNext()) {
			double current = it.next().importo;
			tot += current; // il vero calcolo dell'importo non si calcola così
		}
		
		return tot;
	}
	
	public int numeroBeniFatturati() {
		Iterator<Bene> it = beni.iterator();
		
		int num = 0;
		
		while(it.hasNext()) {
			it.next();
			num++;
		}
		
		return num;
	}
	
	//TODO da controllare questo metodo
	public boolean uguali(Fattura first, Fattura second) {
		boolean same = true;
		
		if (first.data.compareTo(second.data) != 0)
			same = false;
		
		if (first.venditore.nome.compareTo(second.venditore.nome) != 0)
			same = false;
		
		if (first.compratore.nome.compareTo(second.compratore.nome) != 0)
			same = false;
		
		if (first.numeroBeniFatturati() == second.numeroBeniFatturati()) {
			Iterator<Bene> it1 = first.beni.iterator();
			Iterator<Bene> it2 = second.beni.iterator();
			
			while(it1.hasNext()) {
				Bene good1 = it1.next();
				Bene good2 = it2.next();
				
				if (good1 != good2) {
					same = false;
					break;
				}
			}
		} else {
			same = false;
		}
		
		return same;
	}
}
