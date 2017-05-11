package lab20120210;

public class OrologioDaPolso {
	Orologio<Ora> ore;
	Orologio<Minuto> minuti;

	public OrologioDaPolso() {
		ore = new Orologio<Ora>();
		minuti = new Orologio<Minuto>();
		Event alarm;

		for (int i = 23; i >= 0; i--) {
			ore.add(new Ora(i + "", new Event("")));
		}

		for (int i = 59; i >= 0; i--) {
			alarm = new Event("");

			if (i == 0)
				alarm = new Event("Bip bip");

			if (i == 30)
				alarm = new Event("Bip");

			minuti.add(new Minuto(i + "", alarm));
		}
	}
	
	public void start() {
		//TODO utilizzare il metodo rotateF()
		
		for (Ora h : ore) {
			for (Minuto m : minuti) {
				System.out.println(h.getNome() + ":" + m.getNome() + " "
						+ m.getEvent());
			}
		}
	}
}
