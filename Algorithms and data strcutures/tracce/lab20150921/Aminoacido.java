package lab20150921;

public class Aminoacido extends Monomero {
	static final String[] plain = { 
			"alanina", "cisteina", "acido aspartico", "acido glutammico",
			"fenilalanina", "glicina", "istidina", "isoleucina", "lisina",
			"leucina", "metionina", "asparagina", "prolina", "glutammina",
			"arginina", "serina", "treonina", "valina", "triptofano", "tirosina"
	};
	
	static final char[] simbolo = {
		'A', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N',
		'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'Y'
	};
	
	public Aminoacido(String nome) throws IllegalAminoacidoException {
		
		boolean found = false;
		
		for (int i = 0; i < plain.length; i++) {
			if (plain[i].compareTo(nome.toLowerCase()) == 0) {
				this.nome = plain[i];
				found = true;
			}
		}
		
		if (!found)
			throw new IllegalAminoacidoException(nome);
	}
	
	@Override
	public char getSymbol() throws IllegalAminoacidoException {
		if (nome == null)
			throw new IllegalAminoacidoException();
		
		char symbol = '0';
		
		for (int i = 0; i < plain.length; i++) {
			if (plain[i].compareTo(this.nome) == 0) {
				symbol = simbolo[i];
			}
		}
		
		return symbol;
	}
}
