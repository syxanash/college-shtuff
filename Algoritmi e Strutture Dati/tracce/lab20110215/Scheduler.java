package lab20110215;

public class Scheduler {
	public static final int TIME_SLICE = 100;

	public static void main(String[] args) {
		CircList<Processo> processi = new ListaCircDL<Processo>();

		for (int i = 0; i < 6; i++) {
			processi.addCircList(new Processo());
		}

		for (Processo p : processi) {
			System.out.print("(" + p.getID() + ", " + p.getDurata() + ") ");
		}
		
		System.out.println();

		while (!processi.isEmpty()) {
			if (processi.value().execute(TIME_SLICE)) {
				System.out.println("Process " + processi.value().getID()
						+ " completed!");
				processi.delCircList();
			}

			if (!processi.isEmpty())
				processi.ruota();
		}
	}
}
