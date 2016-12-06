package lab20150224;

public class Record implements Comparable {
	Progetto progetto;
	float punteggio;
	
	public Record(Progetto progetto, float punteggio) {
		this.progetto = progetto;
		
		this.punteggio = punteggio;
	}
	
	public String toString() {
		return punteggio + " " + progetto.nome;
	}

	@Override
	public int compareTo(Object o) {
		double primoP = this.punteggio;
		double secondoP = ((Record) o).punteggio;
		
		if (primoP == secondoP) {			
			return 0;
		} else if (primoP > secondoP) {
			return 1;
		} else if (primoP < secondoP) {
			return -1;
		}
		
		return 0;
	}
	

}
