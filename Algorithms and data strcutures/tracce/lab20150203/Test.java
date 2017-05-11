package lab20150203;

import java.util.ArrayList;

public class Test {
	public static void main(String... args) {
		Elezione elezione = new Elezione();
		
		elezione.creaElezione(30);
		
		ListaElettorale[] liste = { 
				new ListaElettorale("Todos Caballeros", new ArrayList<String>()),
				new ListaElettorale("Non ci siamo", new ArrayList<String>()),
				new ListaElettorale("Futuro incerto", new ArrayList<String>())
		};
		
		for (ListaElettorale l : liste) {
			elezione.aggiungiLista(l);
		}
		
		elezione.scrutinaVoto(new Voto());
		elezione.scrutinaVoto(new Voto(null));
		elezione.scrutinaVoto(new Voto(liste[1]));
		elezione.scrutinaVoto(new Voto(liste[1]));
		elezione.scrutinaVoto(new Voto(liste[2]));
		elezione.scrutinaVoto(new Voto(liste[0]));
		elezione.scrutinaVoto(new Voto());
		elezione.scrutinaVoto(new Voto(null));
		elezione.scrutinaVoto(new Voto(liste[2]));
		elezione.scrutinaVoto(new Voto(liste[1]));
		
		//System.out.println(elezione.numVoti(liste[0]));
		
		for (int e : elezione.elencoOrdinato()) {
			System.out.println(e);
		}
	}
}
