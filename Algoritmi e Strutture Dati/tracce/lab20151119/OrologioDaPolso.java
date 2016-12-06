package lab20151119;

public class OrologioDaPolso {
	Orologio<Ora> ore;
	Orologio<Minuto> minuti;

	public OrologioDaPolso() {
		ore = new Orologio<Ora>();
		minuti = new Orologio<Minuto>();

		for (int i = 0; i <= 23; i++) {
			ore.add(new Ora(i + ""));
		}

		for (int i = 0; i < 60; i++) {
			minuti.add(new Minuto(i + ""));
		}
	}

	public void start() {
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++) {
				System.out
						.println(ore.value().nome + ":" + minuti.value().nome);
				minuti.rotateF();
			}

			ore.rotateF();
		}
	}

	// cosa intende la traccia con estende equals?
	public boolean equals(OrologioDaPolso other) {
		OrologioDaPolso current = this;

		if (current.minuti.size() != other.minuti.size()
				|| current.ore.size() != other.ore.size()) {
			return false;
		}

		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++) {
				if (current.minuti.value().nome
						.compareTo(other.minuti.value().nome) != 0
						|| current.ore.value().nome
								.compareTo(other.ore.value().nome) != 0) {
					return false;
				}

				current.minuti.rotateF();
				other.minuti.rotateF();
			}

			current.ore.rotateF();
			other.ore.rotateF();
		}

		return true;
	}

	public static void main(String... args) {
		OrologioDaPolso ww = new OrologioDaPolso();
		OrologioDaPolso second = new OrologioDaPolso();

		System.out.println(ww.equals(second));
	}
}
