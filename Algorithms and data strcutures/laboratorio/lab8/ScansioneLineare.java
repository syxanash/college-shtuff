package lab8;

public class ScansioneLineare implements Scansione {

	public int c(int hk, int i, int length) {
		return (hk + i) % length;		
	}

}
