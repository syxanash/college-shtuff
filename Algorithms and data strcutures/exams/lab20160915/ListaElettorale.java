package lab20160915;

import java.util.List;

public class ListaElettorale implements Comparable<ListaElettorale> {
	String nome;
	List<String> candidati;
	
	public ListaElettorale(String nome, List<String> candidati) {
		this.nome = nome;
		this.candidati = candidati;
	}
	
	public void stampa() {
		System.out.println(nome.toUpperCase());
	}

	@Override
	public int compareTo(ListaElettorale o) {
		return nome.compareTo(o.nome);
	}	
	
}
