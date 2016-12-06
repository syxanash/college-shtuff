package lab20160711;

import java.util.Random;

public class Test {
	// traccia del Lab20160711
	// non ho ben compreso cosa dovesse fare il main...
	
	public static void main(String... args) {
		Random rnd = new Random();
		PQA<Cliente>[] code = new PQA[3];
		
		char[] pos = { 'a', 'b', 'c' };
		int posto = 0;
		int prioritaMax = 37;
		int[] classe = { 17, 13, 11 };
		
		for (int i = 0; i < 3; i++)
			code[i] = new PQA<Cliente>();
		
		
		for (int j = 0; j < 3; j++) {
			posto = 1;
			for (int i = 0; i < classe[j]; i++) {
				Posto seat = new Posto(posto++, pos[i % pos.length]);
				code[j].insert(new Cliente(seat), i % prioritaMax);
			}
		}
		
		// checkout
		
		for(PQA<Cliente> queue : code) {
			System.out.println("==== NUOVA CODA ====");
			System.out.println("coda size: " + queue.size());
			for (Cliente client : queue) {
				System.out.println(client.getID() + " " + client.getPosto().fila + "-" + client.getPosto().posizione);
			}
		}
	}
}
