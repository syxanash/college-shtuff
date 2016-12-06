package patterns.arch.transferobject.updatable;

public class RemoteComponent {
	public String name;
	public String surname;
	
	// metodo che setta i valori delle entità a partire
	// da un transfer object preso come parametro

	public void setData(TransferObject to) {
		mergeProjectData(to);
	}
	
	// metodo effettivo che effettua un merge dei valori
	// del transfer object con quelli d'istanza del remote component
	
	private void mergeProjectData(TransferObject to) {
		// prima di effettuare un merge si dovrebbe fare un controllo
		// di versionamento per vedere se effettivamente i valori sono aggiornati
		// o sono obsoleti
		
		this.name = to.name;
		this.surname = to.surname;
	}
	
	// metodo che ritorna il transfer object in maniera
	// coars grained in modo da evitare tutte le chiamate al remote
	// Object

	public TransferObject getData() {
		TransferObject to = new TransferObject();
		
		to.name = name;
		to.surname = surname;
		
		return to;
	}
}
