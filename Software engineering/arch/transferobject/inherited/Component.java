package patterns.arch.transferobject.inherited;

public class Component extends TransferObject {
	// abbiamo evitato di riscrivere gli stessi
	// attributi e metodi setter e getter
	// poichè c'è una relazione 1-a-1 con la classe
	// transferobject
	
	public void doStuff() {
		this.name = "Dorena";
		this.surname = "Seliddo";
	}
}
