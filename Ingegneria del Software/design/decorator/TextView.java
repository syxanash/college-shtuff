package patterns.design.decorator;

/*
 * una classe CONCRETE COMPONENT
 * che estende l'interfaccia VisualComponent
 */

public class TextView extends VisualComponent {
	private String values;

	public TextView(String input) {
		values = input;
	}

	public void draw() {
		System.out.println("*" + values + "*");
	}
}
