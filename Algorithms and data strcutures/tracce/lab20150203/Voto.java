package lab20150203;

public class Voto {
	private boolean nullo = false;
	private boolean bianca = false;
	
	private ListaElettorale lista;
	
	public Voto(ListaElettorale s) {
		if (s == null) {
			nullo = true;
		}
		
		lista = s;
	}
	
	public Voto() {
		bianca = true;
	}
	
	public boolean nullo() {
		return nullo;
	}
	
	public boolean bianca() {
		return bianca;
	}
	
	public ListaElettorale voto() {
		return (!bianca && !nullo) ? lista : null;
	}
}
