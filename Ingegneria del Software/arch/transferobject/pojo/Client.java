package patterns.arch.transferobject.pojo;

public class Client {
	public static void main(String[] args) {
		// creo un oggetto di tipo component ed invoco il metodo
		// doStuff che dovrebbe fare qualcosa con la rete e settare
		// i suoi valori interni
		Component comp = new Component();
		comp.doStuff();
		
		// successivamente al posto di chiedere al component
		// tutti i dati con dei getter sequenzialmente posso usare un unico
		// getData che me li manda tutti mediante un transferobject
		TransferObject to = comp.getData();
		System.out.println(to.name + " " + to.surname);
	}
}
