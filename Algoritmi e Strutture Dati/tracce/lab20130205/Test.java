package lab20130205;

public class Test {
	public static void main(String... args) {
		FatturaHD fat1 = new FatturaHD(0, "21/04/1994", new Persona("simone"), new Persona("morena del"));
		FatturaHD fat2 = new FatturaHD(25, "05/06/2015", new Persona("Gianni"), new Persona("Ciccarelli SRL"));
		FatturaHD fat3 = new FatturaHD(4, "21/04/1994", new Persona("simone"), new Persona("morena del"));

		
		fat1.aggiungiBene("BMW", 2, 10544.66);
		fat1.aggiungiBene("Orologio", 1, 24.8);
		fat1.aggiungiBene("Apple I", 1, 666.0);
	}
}
