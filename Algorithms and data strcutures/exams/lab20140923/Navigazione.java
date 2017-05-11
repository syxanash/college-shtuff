package lab20140923;

import java.util.Iterator;
import java.util.LinkedList;

public class Navigazione {
	LinkedList<Record> registrazione = new LinkedList<Record>();
	Bussola bussola = new Bussola();
	
	private class Record {
		String direzione;
		String date;
		
		public Record(String direzione, String date) {
			this.direzione = direzione;
			this.date = date;
		}
	}
	
	public void naviga(int N) {
		//TODO finire procedura generazione casuale
		
		bussola.ruotaA();
		bussola.ruotaA();
		
		Record rec = new Record(bussola.direzione().toString(), "15:35");
		registrazione.add(rec);
		
		bussola.ruotaI();
		bussola.ruotaI();
		bussola.ruotaI();
		
		rec = new Record(bussola.direzione().toString(), "20:40");
		registrazione.add(rec);
	}
	
	public String toString() {
		String result = "";
		
		Iterator<Record> it = registrazione.iterator();
		
		while(it.hasNext()) {
			result += it.next().direzione + " ";
		}
		
		return result;
	}
	
	public static void main(String... args) {
		Navigazione nave = new Navigazione();
		nave.naviga(10);
		
		System.out.println(nave.toString());
	}
}
