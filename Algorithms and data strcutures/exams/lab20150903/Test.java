package lab20150903;

// traccia incompleta

public class Test {
	public static void main(String... args) {
		PurchaseSystem sys = new PurchaseSystem(20);

		int s = 0;
		for (ALSession ses : sys.sessioni.sessions) {
			System.out.println("--- nuova sessione " + ((s++) + 1) + " ---");

			for (Item i : ses.getItems()) {
				System.out.println(i.name + " - " + i.price);
			}
		}
	}
}
