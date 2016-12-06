package patterns.design.factorymethod;

public class Client {
	public static void main(String[] args) {
		Commesso persona = Commesso.getCommesso("tennis");
		Scarpe daVendere = persona.getScarpe();
		
		System.out.println(daVendere.getClass());
	}
}
