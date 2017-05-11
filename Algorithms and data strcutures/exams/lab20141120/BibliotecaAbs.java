package lab20141120;

public abstract class BibliotecaAbs {
	protected ArrayDict<String, Record> volumi;

	public abstract boolean bibliotecaVuota();

	public abstract void addVol(String pos, Record vol);

	public abstract Volume volume(String pos);

	public abstract void prestito(String pos);

	public abstract void restituzione(String pos);

	public abstract boolean prestato(String pos);

	public abstract String posizione(Record vol);

}
