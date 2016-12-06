package lab20120705;

public class testaMessaggio {
	public static void main(String... args) {
		//TODO questo main non rispetta i requisiti della traccia ma è stato
		// creato per testare i metodi
		
		Messaggio msg = new Messaggio();
		
		msg.addDatagramma(new Datagramma("simone", "morena", 2, "come ", false));
		msg.addDatagramma(new Datagramma("simone", "morena", 0, "ciao ", false));
		msg.addDatagramma(new Datagramma("simone", "morena", 3, "stai?", true));
		msg.addDatagramma(new Datagramma("simone", "morena", 1, "morena ", false));
		
		System.out.println(msg.toString());
		
		Messaggio secondo = new Messaggio();
		
		secondo.addDatagramma(new Datagramma("simone", "morena", 0, "ciao ", false));
		secondo.addDatagramma(new Datagramma("simone", "morena", 1, "morena ", false));
		secondo.addDatagramma(new Datagramma("simone", "morena", 3, "stai?", true));
		
		System.out.println(secondo.toString());
		
		System.out.println(msg.confronta(secondo));
		
		System.out.println(secondo.completo());
		
	}
}
