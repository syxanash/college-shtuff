package lab20130205;

public class FatturaHD extends Fattura {

	public FatturaHD(int id, String data, Persona venditore, Persona compratore) {
		super(id, data, venditore, compratore);
		
		super.beni = new PilaHD<Bene>();
	}

}
