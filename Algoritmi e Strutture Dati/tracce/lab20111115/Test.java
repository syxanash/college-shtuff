package lab20111115;

import java.util.ArrayList;
import java.util.List;

// main di prova non rispetta le specifiche della traccia

public class Test {
	public static void main(String... args) {		
		Elezione elect = new Elezione();
		
		List<String> candi = new ArrayList<String>();
		candi.add("morena");
		candi.add("simone");
		ListaElettorale lista1 = new ListaElettorale("W l'Italia", candi);
		
		elect.aggiungiLista(lista1);
		
		candi = new ArrayList<String>();
		candi.add("maly");
		ListaElettorale lista2 = new ListaElettorale("In medium statz virus", candi);
		
		elect.aggiungiLista(lista2);
		
		candi = new ArrayList<String>();
		candi.add("anonymous");
		ListaElettorale lista3 = new ListaElettorale("i meglio!!1", candi);
		
		elect.aggiungiLista(lista3);
		
		candi = new ArrayList<String>();
		candi.add("gianni");
		candi.add("francesco");
		candi.add("miguel");
		ListaElettorale lista4 = new ListaElettorale("Fate l'amore non linux", candi);
		
		elect.aggiungiLista(lista4);
		
		elect.scrutinaVoto(new Voto(lista2));
		elect.scrutinaVoto(new Voto(lista4));
		elect.scrutinaVoto(new Voto());
		elect.scrutinaVoto(new Voto(lista1));
		elect.scrutinaVoto(new Voto(null));
		elect.scrutinaVoto(new Voto(lista4));
		
		System.out.println(elect.elencoOrdinato());
		
		
	}
}
