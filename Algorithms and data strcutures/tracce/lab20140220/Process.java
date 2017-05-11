package lab20140220;

import java.util.Random;

public class Process {
	private String path;
	private int id;

	public Process(String path) {
		Random rnd = new Random();
		
		this.path = path;
		this.id = rnd.nextInt(99999);
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public String toString() {
		return this.id + "\t" + this.path;
	}
}
