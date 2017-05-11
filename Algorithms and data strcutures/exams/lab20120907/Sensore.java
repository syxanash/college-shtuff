package lab20120907;

import java.util.Random;

public class Sensore {
	public static final int NO_VALUE = 36;
	
	private static int ID = 0;
	
	int identificativo;
	int x, y;
	
	public Sensore(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.identificativo = ID++;
	}
	
	public float poll() {
		float min = -5;
		
		Random rnd = new Random();
				
		return rnd.nextFloat() * (NO_VALUE - min) + min;
	}
}
