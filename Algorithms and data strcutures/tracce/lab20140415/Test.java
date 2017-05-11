package lab20140415;

public class Test {
	public static void main(String... args) {
		BagOfWords bag1 = new BagOfWords();
		BagOfWords bag2 = new BagOfWords();
		BagOfWords bag3 = new BagOfWords();
		
		String a = "Questo è un sistema innovativo per la scoperta automatica di plagi";
		String b = "Questo sistema innovativo permette la scoperta automatica di plagi";
		String c = "Questo sistema non fa proprio nulla di interessante";
		
		bag1.addText(a);
		bag2.addText(b);
		bag3.addText(c);
		
		System.out.println("------ similiarità----- ");
		
		System.out.println(bag1.similiarita(bag3));
	}
}
