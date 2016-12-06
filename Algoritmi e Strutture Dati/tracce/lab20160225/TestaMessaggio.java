package lab20160225;

import java.util.ArrayList;
import java.util.Random;

public class TestaMessaggio {
	public static void main(String... args) {
		ArrayList<Datagramma> datagrammi = new ArrayList<Datagramma>();
		datagrammi.add(new Datagramma("192.168.3.2", "192.168.3.5", 0, "oggi ", false));
		datagrammi.add(new Datagramma("192.168.3.2", "192.168.3.5", 1, "mi ", false));
		datagrammi.add(new Datagramma("192.168.3.2", "192.168.3.5", 2, "sento ", false));
		datagrammi.add(new Datagramma("192.168.3.2", "192.168.3.5", 3, "proprio ", false));
		datagrammi.add(new Datagramma("192.168.3.2", "192.168.3.5", 4, "come ", false));
		datagrammi.add(new Datagramma("192.168.3.2", "192.168.3.5", 5, "ar ", false));
		datagrammi.add(new Datagramma("192.168.3.2", "192.168.3.5", 6, "ca", true));
		
		Random rnd = new Random();
		Messaggio msg = new Messaggio();
		
		while(datagrammi.size() > 0) {
			int index = rnd.nextInt(datagrammi.size());
			
			msg.addDatagramma(datagrammi.get(index));
			datagrammi.remove(index);
		}		
				
		System.out.println(msg.toString());
	}
}
