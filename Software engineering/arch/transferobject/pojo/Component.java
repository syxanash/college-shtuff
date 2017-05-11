package patterns.arch.transferobject.pojo;

public class Component {
	public String name;
	public String surname;
	
	public void doStuff() {
		// faccio qualcosa comunicando con altre classi
		// e successivamente setto dei valori
		this.name = "hawwy";
		this.surname = "pottah";
	}
	
	// mi costruisco un metodo per inviare tali valori ad una classe
	// client in maniera coars grained evitando tanti getter sulla
	// classe component.
	public TransferObject getData() {
		TransferObject to = new TransferObject();
		
		to.name = this.name;
		to.surname = this.surname;
		
		return to;
	}
}
