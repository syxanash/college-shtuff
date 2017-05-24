package lab20150921;

public class Nucleotide extends Monomero {
	static final String[] plain = {
		"adenina", "citosina", "guanina", "timina"
	};
	
	static final char[] simbolo = {
		'A', 'C', 'G', 'T'
	};
	
	public Nucleotide(String nome) throws IllegalNucleotideException {
		boolean found = false;
		
		for(String s : plain) {
			if (s.compareTo(nome.toLowerCase()) == 0) {
				this.nome = nome;
				found = true;
			}
		}
		
		if (!found)
			throw new IllegalNucleotideException(nome);
	}
	
	@Override
	public char getSymbol() throws IllegalNucleotideException {
		if (nome == null)
			throw new IllegalNucleotideException();
		
		char symbol = '0';
		
		for (int i = 0; i < plain.length; i++) {
			if (plain[i].compareTo(this.nome) == 0) {
				symbol = simbolo[i];
			}
		}
		
		return symbol;
	}
}
