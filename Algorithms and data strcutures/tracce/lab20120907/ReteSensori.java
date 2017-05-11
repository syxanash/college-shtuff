package lab20120907;

import java.util.HashMap;

public class ReteSensori {
	public int n;
	public int t;
	
	HashMap<Integer, Float> snapshot;
	Lista<Collegamento> rete;
	
	public ReteSensori(int n, int t) {
		this.n = n;
		this.t = t;
	}
}
