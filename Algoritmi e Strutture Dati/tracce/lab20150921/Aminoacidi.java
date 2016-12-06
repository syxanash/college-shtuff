package lab20150921;

import java.util.HashMap;

public class Aminoacidi {
	public static HashMap<Character, Aminoacido> aminoacidi;

	static {
		aminoacidi = new HashMap<Character, Aminoacido>();

		try {
			for (String n : Aminoacido.plain) {
				Aminoacido temp = new Aminoacido(n);
				
				aminoacidi.put(temp.getSymbol(), temp);
			}

		} catch (IllegalAminoacidoException e) {
			System.err.println("aminoacido inserito è errato");
		}
	}
}
