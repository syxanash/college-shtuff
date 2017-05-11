package lab20150921;

// nucleotidi
public class DNA extends Polimero {
	public DNA(String seq) {
		sequenza = new AList();
		
		char[] symbols = seq.toCharArray();
		
		for (char s : symbols) {
			sequenza.add(Nucleotidi.nucleotidi.get(s).nome);
		}
	}
	
	@Override
	public String toString() {
		String nucleotidi = "";
		
		sequenza.reset();
		
		while(sequenza.hasNext()) {
			nucleotidi += sequenza.next() + " ";
		}
		
		return nucleotidi;
	}
}
