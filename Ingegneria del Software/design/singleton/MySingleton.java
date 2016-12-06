package patterns.design.singleton;

public class MySingleton {
	private static MySingleton uniqueIstance;
	
	private boolean barrel = false;
	
	private MySingleton() {
		// rendendo private il costruttore non potrò
		// istanziare alcun oggetto di tipo MySingleton
		// se non con un metodo appropriato
	}
	
	public static MySingleton getIstance() {
		if (uniqueIstance == null) {
			// assegno all'attributo di classe uniqueIstance
			// la nuova istanza dell'oggetto MySingleton per la prima volta se è null
			// altrimenti ritorno direttamente quello già creato
			
			uniqueIstance = new MySingleton();
		}
		
		return uniqueIstance;
	}
	
	public void doSomething() {
		barrel = true;
		System.out.println("*barrel roll*");
	}
	
	public void undoSomething() {
		barrel = false;
		System.out.println("*flipped back*");
	}
	
	public boolean isBarreled() {
		return barrel;
	}
}
