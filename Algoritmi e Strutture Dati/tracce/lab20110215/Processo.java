package lab20110215;

import java.util.Random;

public class Processo {
	private static int PROG = 1;
	private static final int MAX = 800;
	private static final int MIN = 50;

	private Random rnd = new Random();

	private int id;
	private int ttl;

	public Processo() {

		id = PROG++;
		ttl = rnd.nextInt((MAX - MIN) + 1) + MIN;
	}
	
	public boolean execute(int timeSlice) {
		ttl -= timeSlice;
		
		if (ttl <= 0)
			return true;
		
		return false;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getDurata() {
		return this.ttl;
	}
}
