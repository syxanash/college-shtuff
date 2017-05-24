package lab20101117;

public class Operando implements ItemEspr {
	public int value;
	
	public Operando(int op) {
		this.value = op;
	}
	
	public String toString() {
		return value + "";
	}
}
