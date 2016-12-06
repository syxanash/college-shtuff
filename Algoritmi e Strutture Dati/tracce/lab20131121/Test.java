package lab20131121;

import java.util.Random;

public class Test {
	public static void main(String... args) {
		Market shop = new Market(3);
		Random rnd = new Random();
		
		for (int i = 0; i < shop.acquisti.length; i++) {
			shop.acquisti[i] = new Carrello();
			
			int daComprare = rnd.nextInt(8);
			
			for (int j = 0; j < daComprare; j++) {
				shop.acquisti[i].aggArticolo(
						shop.merce[ rnd.nextInt(shop.merce.length) ]
				);
			}
		}
		
		shop.stampa();
		shop.istogramma();
	}
}
