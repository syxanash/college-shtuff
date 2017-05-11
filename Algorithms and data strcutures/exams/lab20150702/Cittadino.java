package lab20150702;

public class Cittadino implements Comparable {
	
	private static int progressivo = 1;
	
	String nome, cognome;
	int id;
	
	public Cittadino (String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		
		this.id = nextId();
	}
	
	public String toString() {
		return id + " " + cognome + " " + nome;
	}

	@Override
	public int compareTo(Object o) {
		if (this.id == ((Cittadino) o).id) {
			return 0;
		} else if (this.id > ((Cittadino) o).id) {
			return 1;
		} else if (this.id < ((Cittadino) o).id) {
			return -1;
		}
		
		return 0;
	}
	
	private static int nextId() {
		return progressivo++;
	}

}
