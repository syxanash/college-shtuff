package patterns.design.singleton;

public class Client {
	public static void main(String[] args) {
		
		// non posso fare MySingleton singolo = new MySingleton();
		// poichè il costruttore è privato, per creare una sola
		// istanza dell'oggetto MySingleton dovrò fare come segue
		
		MySingleton singolo = MySingleton.getIstance();
		
		// ora posso eseguire operazioni su "singolo"
		singolo.doSomething();
		System.out.println(singolo.isBarreled());
		singolo.undoSomething();
		System.out.println(singolo.isBarreled());
		
		System.out.println("provo con una nuova istanza...");
		
		MySingleton nuovo = MySingleton.getIstance();
		nuovo.doSomething(); // ho cambiato a true anche nell'istanza di singolo
		
		System.out.println("l'istanza singolo che valore ha? " + singolo.isBarreled());
		
		System.out.println("le istanze sono uguali? " + (singolo == nuovo));
	}
}
