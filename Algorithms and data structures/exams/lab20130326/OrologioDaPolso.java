package lab20130326;


public class OrologioDaPolso {
	Orologio<Ora> ore;
	Orologio<Minuto> minuti;
	
	public OrologioDaPolso() {
		ore = new Orologio<Ora>();
		minuti = new Orologio<Minuto>();
		
		for (int i = 0; i < 24; i++) {
			ore.add(new Ora(i + ""));
		}
		
		for (int i = 0; i < 60; i++) {
			minuti.add(new Minuto(i + ""));
		}
		
		for(Ora h : ore) {
			for (Minuto m : minuti) {
				System.out.println(h.nome + ":" + m.nome);
			}
		}
	}
}

// RESTO DEI METODI SIMILI A QUALSIASI ALTRA TRACCIA SUGLI OROLOGI DA POLSO...
