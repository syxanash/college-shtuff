package lab20160411;

import java.util.Iterator;

public class Test {
	public static void main(String... args) {
		MuseoAbs museo = new Museo(new LinkedDict<String, Record>());
		
		museo.addOp("La Gioconda", new Opera("Leonardo Da Vinci", 1804, "olio su tavola"));
		museo.addOp("Madonna del Lucherino", new Opera("Albrecht Durer", 1915, "olio su tavola di pioppo"));
		museo.addOp("Venere di Milo", new Opera("Alessandro di Antiochia", 1820, "scultura di marmo"));
		museo.addOp("David", new Opera("Michelangelo buonarotti", 1850, "olio di marmo"));
		museo.addOp("Mosè", new Opera("Michelangelo buonarotti", 1850, "scultura di tavola"));
		
		Iterator<String> it = museo.opere.iterator();
		
		while(it.hasNext()) {
			String codice = it.next();
			Opera opera = museo.opera(codice);
			
			System.out.println("OPERA--------");
			System.out.println("Codice: " + codice + "\n"
					+ "Autore: " + opera.autore + "\n"
					+ "Anno Acqu: " + opera.annoAcquisizione + "\n"
					+ "Tipo: " + opera.tipo + "\n");
		}
		
		museo.prestito("La Gioconda", "Esposizione Universale di Parigi");
		museo.prestito("David", "Esposizione Universale di Parigi");
		
		Iterator<Opera> listaPrestiti = museo.prestiti("Esposizione Universale di Parigi").iterator();
		
		while(listaPrestiti.hasNext()) {
			System.out.println(listaPrestiti.next().autore);
		}
		
		System.out.println(museo.prestata("David"));
		
		museo.restituzione("La Gioconda", "Esposizione Universale di Parigi");
		museo.restituzione("David", "Esposizione Universale di Parigi");
		
		System.out.println(museo.prestata("David"));
	}
}
