package patterns.design.abstractfactory;

public class Client {
	public static void main(String[] args) {
		Commesso persona = Commesso.getCommesso("adidas");
		Commesso commessoSpeciale = Commesso.getCommesso("nike");
		
		Scarpe nike = commessoSpeciale.getScarpe();
		
		Scarpe nuovoPaia = persona.getScarpe();
		Tuta completo = persona.getTuta();
		
		System.out.println(nuovoPaia.getClass());
		System.out.println(completo.getClass());
		System.out.println(nike.getClass());
	}
}
