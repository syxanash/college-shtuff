package lab20130903;

public abstract class BibliotecaAbs {
	protected Dictionary<String, Record> volumi;

	abstract boolean bibliotecaVuota();

	abstract void addVol(String posizione, Volume vol);

	abstract Volume volume(String posizione);

	abstract void prestito(String posizione);

	abstract void restituzione(String posizione);

	abstract boolean prestato(String posizione);

	abstract AddOnlyList<String> posizione(Volume vol);
}
