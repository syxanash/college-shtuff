package lab20160118;

public class WhatsupTest {
	public static void main(String... args) {
		Whatsup conv1 = new Whatsup();
		Whatsup conv2 = new Whatsup();
		
		conv1.addPacchetto(new Pacchetto("Simone", "morena", 0, "hey ", false));
		conv1.addPacchetto(new Pacchetto("Simone", "morena", 3, "come ", false));
		conv1.addPacchetto(new Pacchetto("Simone", "morena", 1, "ciao ", false));
		conv1.addPacchetto(new Pacchetto("Simone", "morena", 4, "stay?", true));
		conv1.addPacchetto(new Pacchetto("Simone", "morena", 2, "luca ", false));
		
		//conv2.addPacchetto(new Pacchetto("Simone", "morena", 0, "hey ", false));
		conv2.addPacchetto(new Pacchetto("Simone", "morena", 3, "come ", false));
		conv2.addPacchetto(new Pacchetto("Simone", "morena", 1, "ciao ", false));
		conv2.addPacchetto(new Pacchetto("Simone", "morena", 4, "stai?", true));
		conv2.addPacchetto(new Pacchetto("Simone", "morena", 2, "luca ", false));
		
		System.out.println(conv2.toString());
		
		System.out.println(conv1.toString().compareTo(conv2.toString()));
	}
}
