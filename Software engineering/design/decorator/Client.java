package patterns.design.decorator;

public class Client {
	public static void main(String[] args) {
		VisualComponent comp = new TextView("this is text");
		
		BorderDecorator borderedComp = new BorderDecorator(comp);
		ScrollDecorator scrollComp = new ScrollDecorator(borderedComp);
		
		// il primo draw mi esegue il metodo di textview
		// ereditato quindi da visualcomponent
		
		comp.draw();
		
		System.out.println();
		
		// il draw successivo mi esegue anche i metodi draw all'interno
		// di boredecorator e scrolldecorator
		
		scrollComp.draw();
	}
}
