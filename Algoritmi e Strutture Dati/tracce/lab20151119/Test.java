package lab20151119;

public class Test {
	public static void main(String... args) {
		OrologioDaPolso firstWW = new OrologioDaPolso();
		OrologioDaPolso secondWW = new OrologioDaPolso();

		firstWW.start();

		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++) {
				if (firstWW.ore.value().nome.compareTo("3") == 0
						&& firstWW.minuti.value().nome.compareTo("59") == 0) {
					System.out.println("stopped at 3:59 -> "
							+ firstWW.equals(secondWW));
				}
				firstWW.minuti.rotateF();
			}
			firstWW.ore.rotateF();
		}

		System.out.println("end of the day -> " + firstWW.equals(secondWW));
	}
}
