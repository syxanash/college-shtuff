package lab20120403;

public class Test {
	public static void main(String... args) {
		BagOfWords[] bags = new BagOfWords[3];
		
		for (int i = 0; i < bags.length; i++)
			bags[i] = new BagOfWords();
		
		bags[0].addText("La scienza vale più delle perle e nessuna cosa preziosa la uguaglia");
		bags[1].addText("Le perle di scienza popolare sono tante, ma la più preziosa è quella di sopra");
		bags[2].addText("Non ci sono molti termini comuni con le altre frasi");
		
		for(String word : bags[1].bagOfWords) {
			System.out.println(word + " - " + bags[1].bagOfWords.occurrences(word));
		}
		
		System.out.println(bags[0].occurences);
	}
}
