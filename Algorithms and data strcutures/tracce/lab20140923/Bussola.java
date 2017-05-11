package lab20140923;

public class Bussola {
	CircList<Cardinale> ago;

	public Bussola() {
		ago = new ListaCircolareDC<Cardinale>();
		
		for (Cardinale e : Cardinale.values()) {
			ago.addCircList(e);
		}
	}

	public void ruotaA() {
		ago.ruotaAvanti();
	}

	public void ruotaI() {
		ago.ruotaIndietro();
	}

	public Cardinale direzione() {
		try {
			return ago.value();
		} catch (EccezioneStrutturaVuota e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
