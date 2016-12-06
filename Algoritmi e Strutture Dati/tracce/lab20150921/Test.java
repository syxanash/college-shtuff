package lab20150921;

public class Test {
	public static void main(String... args) {
		DNA msg = new DNA("TTCAGGC");
		Proteina prot = new Proteina("CQVDAHCSAGHSCIFT");
		
		System.out.println("DNA: " + msg.toString());
		System.out.println("PROTEINA: " + prot.toString());
	}
}
