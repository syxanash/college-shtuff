package lab20150921;

public class IllegalAminoacidoException extends Exception {

	public IllegalAminoacidoException(String nome) {
		super(nome + " errato");
	}

	public IllegalAminoacidoException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
