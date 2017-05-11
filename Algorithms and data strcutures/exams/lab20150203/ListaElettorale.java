package lab20150203;

import java.util.List;

public class ListaElettorale implements Comparable<ListaElettorale> {
	String nome;
	List<String> candidati;
	
	public ListaElettorale(String nome, List<String> list) {
		this.nome = nome;
		this.candidati = list;
	}

	@Override
	public int compareTo(ListaElettorale o) {
		return nome.compareTo(o.nome);
	}
	
	public void stampa() {
		System.out.println(nome.toUpperCase());
	}

}
