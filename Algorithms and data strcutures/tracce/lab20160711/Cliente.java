package lab20160711;

public class Cliente {
	private static int PRIVATE_ID = 0;
	
	private Posto seat;
	private int id = 0;
	
	public Cliente(Posto p) {
		this.seat = p;
		this.id = PRIVATE_ID++;
	}
	
	public int getID() {
		return id;
	}
	
	public Posto getPosto() {
		return seat;
	}
	
	public String toString() {
		return seat.fila + " " + seat.posizione;
	}
}
