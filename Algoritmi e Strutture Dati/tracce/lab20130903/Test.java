package lab20130903;

import java.util.Iterator;

public class Test {
	public static void main(String... args) {
		Dictionary<String, Record> volumi = new LinkedList<String, Record>();
		AddOnlyList<String> autori = new VectorList<String>();
		Volume volume;

		for (int i = 0; i < 3; i++) {
			autori.add("Camil Demetrescu");
			autori.add("Umberto Ferraro Petrillo");
			autori.add("Irene Finocchi");
			autori.add("Giuseppe F. Italiano");
			volume = new Volume(
					"Progetto di algoritmi e strutture dati in Java",
					"McGraw Hill", 2007, autori);
			volumi.insert("scaffale principale " + i, new Record(volume, false));
		}

		autori = new VectorList<String>();
		autori.add("Alan Bertossi");
		volume = new Volume("Algoritmi e Strutture di Dati",
				"CittaStudi Edizioni", 2009, autori);
		volumi.insert("scaffale principale succ", new Record(volume, false));

		for (int i = 0; i < 2; i++) {
			autori = new VectorList<String>();
			autori.add("Deitel & Deitel");
			volume = new Volume("Programmazione Java: Fondamenti",
					"Pearson-Prentiece Hall", 2008, autori);
			volumi.insert("Armadio piano terra anta " + i, new Record(volume, false));
		}

		autori = new VectorList<String>();
		autori.add("John Lewis");
		autori.add("Joseph Chase");
		volume = new Volume("Java Software Structures", "Pearson Education",
				2010, autori);
		volumi.insert("Scrivania 2", new Record(volume, false));

		Biblioteca comunale = new Biblioteca(volumi);
		
		comunale.prestito("Armadio piano terra anta 0");
		comunale.prestito("scaffale principale succ");
		
		Iterator<String> it = comunale.volumi.iterator();
		
		while(it.hasNext()) {
			String pos = it.next();
			
			System.out.println("*** Posizione: " + pos);
			System.out.println("Disponibilità: " + !comunale.prestato(pos));
			System.out.println("Titolo: " + comunale.volume(pos).titolo);
			System.out.println("Casa Editrice: " + comunale.volume(pos).casaEditrice);
			System.out.println("Anno Pub: " + comunale.volume(pos).annoPub);
		}
	}
}
