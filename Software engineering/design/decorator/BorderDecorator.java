package patterns.design.decorator;

/*
 * Decorator concreto che aggiunge la funzionalita' ad un oggetto
 * di VisualComponent gia' esistente
 */

public class BorderDecorator extends Decorator {
	public BorderDecorator(VisualComponent comp) {
		super(comp);
	}
	
	@Override
	public void draw() {
		myComp.draw();
		
		drawBorder();
	}
	
	private void drawBorder() {
		System.out.println("^ [borderd]");
	}
}
