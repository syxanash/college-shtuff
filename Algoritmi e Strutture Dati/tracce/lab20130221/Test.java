package lab20130221;

public class Test {
	public static void main(String... args) {
		// manca la parte della generazione casuale dei carrelli
		// questo è solo un main di prova
		
		MarketBasketAnalysis anal = new MarketBasketAnalysis();
		
		Carrello carr = new Carrello();
		carr.add(new Item(new Burro("burrone"), 3));
		carr.add(new Item(new Cereali("maxis"), 4));
		carr.add(new Item(new Piatti("test"), 12));
		
		anal.add(carr);
		anal.toString();
	}
}
