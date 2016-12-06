package lab20111115;

public class Voto {
	boolean schedaBianca;
	boolean schedaNulla;
	
	ListaElettorale lista;
	
	public Voto(ListaElettorale s) {
		if (s == null) {
			schedaNulla = true;
		} else {
			lista = s;
		}
	}
	
	public Voto() {
		schedaBianca = true;
	}
	
	public boolean nullo() {
		return schedaNulla;
	}
	
	public boolean bianca() {
		return schedaBianca;
	}
	
	public ListaElettorale voto() {
		if (!(this.nullo() && this.bianca())) {
			return lista;
		}
		
		return null;
	}
}
