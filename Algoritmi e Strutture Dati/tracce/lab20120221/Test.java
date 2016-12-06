package lab20120221;

public class Test {
	public static void main(String... args) {		
		Biblioteca acclavio = new Biblioteca(15);
		
		acclavio.registra("A-10", "1984", "orwell", "1948");
		acclavio.registra("B-11", "Il mondo nuovo", "Aldus Hauxley", "1914");
		acclavio.registra("A-11", "Profondo blu", "jeffrey deaver", "2004");
		acclavio.registra("B-12", "Il mondo nuovo", "Aldus Hauxley", "1914");
		
		for (String s : acclavio.codice( "Il mondo nuovo", "Aldus Hauxley", "1914")) {
			System.out.println(s);
		}
		
		acclavio.prestito("B-11");
		acclavio.prestito("B-12");
		
		System.out.println(acclavio.copie( "Il mondo nuovo", "Aldus Hauxley", "1914"));
	}
}
