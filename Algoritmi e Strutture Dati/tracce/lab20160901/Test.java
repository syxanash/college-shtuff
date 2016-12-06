package lab20160901;

public class Test {
	public static void main(String... args) {
		ItemRecommender system = new ItemRecommender(20);
		
		int numSess = 0;
		
		for (SessioneLL sessione : system.sessioni.listaSessioni) {
			System.out.println("==== Sessione " + (++numSess) + " ====");
			
			for (Prodotto prod : sessione.prodotti) {
				System.out.println(prod.nome + " - " + prod.prezzo);
			}
		}
		
		// se ho capito cosa significa cooccorrenza
		System.out.println("Cooccorrenza di iLife e Apple II: " + system.acquistiAssociati(new Prodotto("iLife", 11), new Prodotto("Apple II", 11)));
	}
}
