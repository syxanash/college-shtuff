package lab20150921;

//Aminoacidi
public class Proteina extends Polimero {
	public Proteina(String seq) {
		sequenza = new AList();
		
		char[] symbols = seq.toCharArray();
		
		for (char s : symbols) {
			sequenza.add(Aminoacidi.aminoacidi.get(s).nome);
		}
	}
	
	@Override
	public String toString() {
		String aminoacidi = "";
		
		sequenza.reset();
		
		while(sequenza.hasNext()) {
			aminoacidi += sequenza.next() + " ";
		}
		
		return aminoacidi;
	}
}
