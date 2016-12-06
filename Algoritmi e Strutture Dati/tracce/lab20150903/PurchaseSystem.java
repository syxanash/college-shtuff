package lab20150903;

import java.util.Random;

public class PurchaseSystem {
	Sessions sessioni;

	public PurchaseSystem(int n) {
		Random rnd = new Random();
		sessioni = new Sessions();
		sessioni.sessions = new ArrList<ALSession>();
		
		Item[] list = { new Item("Polenta", 23), new Item("Banane", 4),
				new Item("iPhone", 800), new Item("Borsa bella", 45),
				new Item("MAcbook", 1100), new Item("Mele", 23),
				new Item("Mouse", 5), new Item("Apple I", 666) };
		
		for (int i = 0; i < n; i++) {
			ALSession sessione = new ALSession();
			int nProdotti = rnd.nextInt((5 - 2) + 1) + 2;
			
			for (int j = 0; j < nProdotti; j++) {
				sessione.addItem(list[rnd.nextInt(list.length)]);
			}
			
			sessioni.sessions.add(sessione);
		}
	}
	
	public int associatePurchase(Item a, Item b) { // co-occorrenza?!?
		return 0;
	}
}
