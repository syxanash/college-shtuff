package lab20131121;

public class Articolo implements Comparable {

	String nome;
	String misura;

	public Articolo(String nome, String misura) {
		this.nome = nome;
		this.misura = misura;
	}

	// effettuo il confronto in base al nome
	@Override
	public int compareTo(Object o) {
		return this.toString().compareTo(o.toString());
	}

	public String toString() {
		return nome + " " + misura;
	}

}
