package lab20120907;

import java.util.Random;

public class Test {
	public static void main(String... args) {
		Sensore[] sensori = new Sensore[6];
		Random rnd = new Random();
		
		for (int i = 0; i < sensori.length; i++) {
			sensori[i] = new Sensore(rnd.nextInt(100), rnd.nextInt(100));
		}
		
		// concludere main
	}
}
