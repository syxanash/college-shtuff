package lab20150921;

import java.util.HashMap;

public class Nucleotidi {
	public static HashMap<Character, Nucleotide> nucleotidi;

	static {
		nucleotidi = new HashMap<Character, Nucleotide>();
		try {
			
			for (String n : Nucleotide.plain) {
				Nucleotide temp = new Nucleotide(n);
				
				nucleotidi.put(temp.getSymbol(), temp);
			}

		} catch (IllegalNucleotideException e) {
			System.err.println("nucleotide inserito è errato!");
		}
	}
}
