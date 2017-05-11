package lab20111115;

import java.util.List;

public class ListaElettorale implements Comparable {
	String nome;
	List candidati;
	
	public ListaElettorale(String nome, List candidati) {
		this.nome = nome;
		this.candidati = candidati;
	}

	@Override
	public int compareTo(Object o) {
		return nome.compareTo(((ListaElettorale) o).nome);
	}
	
	public void stampa() {
		System.out.println(nome.toUpperCase());
	}
}
