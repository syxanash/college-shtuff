package lab20150921;

public abstract class Monomero {
	protected String nome;
	
	public String getName() {
		return this.nome;
	}
	
	public char getSymbol() throws IllegalAminoacidoException, IllegalNucleotideException {
		return 0;
	}
}
