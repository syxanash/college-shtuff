package lab20141120;

public class Record {
	public Volume volume;
	public boolean prestato = false;
	
	public Record(Volume volume, boolean prestato) {
		this.volume = volume;
		this.prestato = prestato;
	}
}
