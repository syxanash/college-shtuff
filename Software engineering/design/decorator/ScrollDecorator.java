package patterns.design.decorator;

public class ScrollDecorator extends Decorator {

	public ScrollDecorator(VisualComponent comp) {
		super(comp);
	}
	
	public void draw() {
		myComp.draw();
		
		drawScrollBar();
	}
	
	private void drawScrollBar() {
		System.out.println("^ |scrollbarred (-)|");
	}
}
