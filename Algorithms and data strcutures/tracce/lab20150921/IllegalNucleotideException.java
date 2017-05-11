package lab20150921;

public class IllegalNucleotideException extends Exception {

	public IllegalNucleotideException(String nome) {
		super(nome + " errato");
	}

	public IllegalNucleotideException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
