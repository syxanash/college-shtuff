package lab20140702;

public class Test {
	public static void main(String... args) {
		Rivista riv = new Rivista();
		
		String art = "A relational perspective on spatial data mining";
		riv.addArt(art, 1);
		riv.addAut(art, "Donato Malerba");
		
		art = "Multi label large margin hierarchical perceptron";
		riv.addArt(art, 1);
		riv.addAut(art, "Clay Woolam");
		riv.addAut(art, "Latifur Khan");
		
		art = "Privacy preserving record linkage approaches";
		riv.addArt(art, 2);
		riv.addAut(art, "Vassilios S. Verykios");
		riv.addAut(art, "Alexandros Karakasidis");
		riv.addAut(art, "Vassilios K. Mitrogiannis");
		
		art = "Back to Taranto with K elements for path finding on shitty route 106";
		riv.addArt(art, 3);
		riv.addAut(art, "simone marzulli");
		riv.addAut(art, "morena deldildo");
		
		riv.pubblicaVol(3);
		
		System.out.println(riv.pubblicato(3));
	}
}
