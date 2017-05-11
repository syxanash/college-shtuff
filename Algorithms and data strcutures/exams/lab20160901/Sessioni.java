package lab20160901;


public class Sessioni {
	AddOnlyList<SessioneLL> listaSessioni = new LinkedList<SessioneLL>();

	// anche qui ci dobbiamo inventare noi i metodi?

	public void addSessione(SessioneLL sessione) {
		listaSessioni.add(sessione);
	}

	public int numeroSessioni() {
		int q = 0;

		for (SessioneLL s : listaSessioni)
			q++;

		return q;
	}
}
