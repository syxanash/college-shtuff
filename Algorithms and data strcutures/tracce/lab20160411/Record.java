package lab20160411;

public class Record {
	Opera opera;
	boolean prestata;
	String esposizione;
	
	public Record(Opera opera, boolean flag, String esposizione) {
		this.opera = opera;
		this.prestata = flag;
		this.esposizione = esposizione;
	}
}
