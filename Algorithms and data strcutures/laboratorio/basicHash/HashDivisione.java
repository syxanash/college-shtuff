package basicHash;

public class HashDivisione implements Hash {
	
	@Override
	public int h(Comparable k, int n) {
		return Math.abs(k.hashCode()) % n;
	}

}
