package patterns.design.decorator;

/*
 * interfaccia decorator che servira' per
 * aggiungere nuove funzionalita' ad oggetti
 * gia' esistenti
 */

public abstract class Decorator extends VisualComponent {
	protected VisualComponent myComp;
	
	public Decorator(VisualComponent comp) {
		myComp = comp;
	}
	
	public void draw() {
		myComp.draw();
	}
}
