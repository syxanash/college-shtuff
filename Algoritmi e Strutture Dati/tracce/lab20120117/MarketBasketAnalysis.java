package lab20120117;

import java.util.HashMap;
import java.util.Iterator;

public class MarketBasketAnalysis {
	HashMap<Class, Integer> qTotArticolo;
	
	public MarketBasketAnalysis() {
		qTotArticolo = new HashMap<Class, Integer>();
	}
	
	void add(Carrello trolley) {
		Iterator<Item> it = trolley.iterator();
		
		while(it.hasNext()) {
			Item tempItem = it.next();
			System.out.println(tempItem.getArticolo().getClass().getSimpleName());
			
			if (qTotArticolo.containsKey(tempItem.getArticolo().getClass())) { // check getclass
				int tempQuantita = qTotArticolo.get(tempItem.getArticolo().getClass());
				tempQuantita += tempItem.getQuantita();
				
				qTotArticolo.put(tempItem.getArticolo().getClass(), tempQuantita);
			} else {
				qTotArticolo.put(tempItem.getArticolo().getClass(), tempItem.getQuantita());
			}
		}
	}
	
	public String toString() {
		String msg = "";	
		
		msg += new Casalinghi().getClass() + " " + qTotArticolo.get(new Casalinghi().getClass()) + "\n";
		msg += new Cucina().getClass() + " " + qTotArticolo.get(new Cucina().getClass()) + "\n";
		
		
		return msg;
	}
}
