package lab20130221;

import java.util.HashMap;
import java.util.Iterator;

public class MarketBasketAnalysis {
	HashMap<Class, Integer> qTotArticolo;
	
	public void add(Carrello trolley) {
		qTotArticolo = new HashMap<Class, Integer>();
		
		Iterator<Item> it = trolley.iterator();
		
		while(it.hasNext()) {
			Item elem = it.next();
			
			qTotArticolo.put(elem.getArticolo().getClass(), elem.getQuantita());
			
			System.out.println(elem.getArticolo().getNome() + " " + elem.getArticolo().getClass());
		}
	}
	
	public String toString() {
		Class[] classi = { Burro.class, Alimenti.class, Articolo.class, Casalinghi.class, Cereali.class,
				Dentifricio.class, Igiene.class, Pane.class, Piatti.class, Sapone.class, Spaghetti.class, Tovagliolini.class,
		};
		
		for (Class c : classi) {
			if (qTotArticolo.get(c) != null)
				System.out.println(c.getSimpleName() + " " + qTotArticolo.get(c));
		}
		
		return null;
	}
}
