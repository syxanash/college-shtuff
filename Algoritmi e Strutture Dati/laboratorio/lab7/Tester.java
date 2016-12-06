package lab7;

public class Tester {
	public static void main(String... args) {
		Dizionario diz = new ArrayDoubling();
		
		diz.insert("ciao", "3");
		diz.insert("simone", "4");
		diz.insert("francesca", "45");
		diz.delete("3");
		System.out.println(diz.search("3"));
	}
}
