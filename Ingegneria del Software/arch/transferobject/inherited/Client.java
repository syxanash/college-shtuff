package patterns.arch.transferobject.inherited;

public class Client {
	public static void main(String[] args) {
		Component remote = new Component();
		remote.doStuff();
		
		TransferObject to = remote.getData();
		System.out.println(to.name + " " + to.surname);
	}
}
