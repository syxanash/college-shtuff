package lab8;

public class HashDivisione implements Hash {

	// magia nera
	
	public int h(Comparable k, int n) {
		return Math.abs(k.hashCode()) % n;
	}

}
