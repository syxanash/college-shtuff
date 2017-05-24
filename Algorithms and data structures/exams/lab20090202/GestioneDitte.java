package lab20090202;

public class GestioneDitte {
	public Tabella tab = new ArrayDoubling();
	
	public void inizializza() {
		InfoDitta temp = new InfoCliente(20150806);
		temp.ragioneSociale = "1";
		
		tab.insert(temp, temp.ragioneSociale);
		
		temp = new InfoFornitore(TipoFornitore.PRINCIPALE);
		temp.ragioneSociale = "69";
		
		tab.insert(temp, temp.ragioneSociale);
		
		temp = new InfoCliente(20100311);
		temp.ragioneSociale = "33";
		
		tab.insert(temp, temp.ragioneSociale);
	}
	
	public TipoDitta ricerca(String ragioneSociale) {
		
		try {
			InfoDitta found = (InfoDitta) tab.search(ragioneSociale);
			
			if (found != null) {
				if (found.getClass() == InfoCliente.class) {
					return TipoDitta.CLIENTE;
				} else if (found.getClass() == InfoFornitore.class) {
					return TipoDitta.FORNITORE;
				}
			}
			
		} catch (EccezioneStrutturaVuota e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TipoDitta.UNDEFINED;
	}
	
	public static void main(String... args) {
		GestioneDitte manage = new GestioneDitte();
		manage.inizializza();
		
		System.out.println(manage.ricerca("1"));
		
		if (manage.ricerca("1") == TipoDitta.CLIENTE) {
			manage.tab.delete("1");
		}
		
		System.out.println(manage.ricerca("1"));
	}
}
