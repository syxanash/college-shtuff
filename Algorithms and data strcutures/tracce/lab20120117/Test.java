package lab20120117;

public class Test {
	public static void main(String... args) {
		MarketBasketAnalysis stat = new MarketBasketAnalysis();
		
		Carrello car = new Carrello();
		car.add(new Item(new Casalinghi(), 3));
		car.add(new Item(new Cucina(), 4));
		
		stat.add(car);
		
		Carrello carrellino = new Carrello();
		carrellino.add(new Item(new Casalinghi(), 45));
		carrellino.add(new Item(new Cucina(), 3));
		
		stat.add(carrellino);
		
		
		System.out.println(stat.toString());
		
	}
}
