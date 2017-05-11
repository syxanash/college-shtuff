package patterns.arch.transferobject.updatable;

public class Client {
	public static void main(String[] args) {
		TransferObject myTO = new TransferObject("simone", "marzulli");
		
		// invio con un metodo coars grained i miei dati al remote
		// component con un setdata
		RemoteComponent remote = new RemoteComponent();
		remote.setData(myTO);
		
		// prelevo i dati dal remote component con un getData		
		TransferObject newTo = remote.getData();
		System.out.println(newTo.name + " " + newTo.surname);
	}
}
