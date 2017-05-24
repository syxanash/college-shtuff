package lab20160915;

public class Voto {
	private ListaElettorale listaVotata;	
	private boolean isNullo = false;
	private boolean isBianca = false;
	
	Voto(ListaElettorale s) {
		if (s == null)
			isNullo = true;
		else
			listaVotata = s;
	}
	
	public Voto() {
		isBianca = true;
	}
	
	public boolean nullo() {
		return isNullo;
	}
	
	public boolean bianca() {
		return isBianca;
	}
	
	public ListaElettorale voto() {
		if (this.nullo() || this.bianca()) {
			return null;
		} else {
			return listaVotata;
		}
	}
	
	
}
