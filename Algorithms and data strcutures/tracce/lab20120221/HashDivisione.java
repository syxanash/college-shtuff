package lab20120221;

public class HashDivisione implements Hash {
	public int h(Comparable k, int n) {
		return Math.abs(k.hashCode()) % n;
	}
}
