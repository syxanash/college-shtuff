package patterns.arch.transferobject.inherited;

public class TransferObject {
	public String name;
	public String surname;
	
	public TransferObject(){}
	
	public TransferObject (TransferObject to) {
		this.name = to.name;
		this.surname = to.surname;
	}
	
	public TransferObject getData() {
		// passo al costruttore creato precedentemente
		// una istanza della classe che eredita TO ovvero Component
		// così da settare nel transfer object i valori
		// settati nel doStuff di component
		return new TransferObject(this);
	}
}
