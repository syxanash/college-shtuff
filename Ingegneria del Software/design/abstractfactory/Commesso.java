package patterns.design.abstractfactory;

public abstract class Commesso {
	public abstract Scarpe getScarpe();
	public abstract Tuta getTuta();
	
	public static Commesso getCommesso(String tipo) {
		Commesso persona = null;
		
		if (tipo.compareTo("adidas") == 0) {
			persona = new CommessoAdidas();
		} else if (tipo.compareTo("nike") == 0) {
			persona = new CommessoNike();
		}
		
		return persona;
	}
}
