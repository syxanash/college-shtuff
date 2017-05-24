package lab20150224;

import java.util.Iterator;
import java.util.Random;

public class Test {
	public static void main(String... args) {
		Progetto[] progetti = {
				new Progetto("HL7"), new Progetto("CIA"),
				new Progetto("THOR"), new Progetto("TESTONE"),
				new Progetto("LOL"), new Progetto("BLACKMORTE"),
				new Progetto("NEVER"), new Progetto("ENDING"),
				new Progetto("AGAIN"), new Progetto("STORY")
		};
		
		Graduatoria grad = new Graduatoria();
		
		for (int i = 0; i < progetti.length; i++) {
			Random rnd = new Random();
			
			grad.aggG((float) rnd.nextInt(100), progetti[i]);
		}
		
		ListaOrdinata gradResto = grad.restoG();
		Iterator<Record> it = gradResto.iterator();
		
		System.out.println(grad.primoV() + " " + grad.primoP().nome);
		
		while(it.hasNext()) {
			Record temp = it.next();
			System.out.println(temp.punteggio + " " + temp.progetto.nome);
		}
		
		System.out.println("media: " + grad.media());
		
		// testare l'inclusione
	}
}
