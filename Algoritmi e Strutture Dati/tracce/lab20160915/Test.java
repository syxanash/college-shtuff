package lab20160915;

public class Test {
	public static void main(String... args) {
		ListaElettorale[] liste = {
				new ListaElettorale("Todos caballeros", null),
				new ListaElettorale("non ci siamo", null),
				new ListaElettorale("Futuro incerto", null) };

		Elezione seggio = new Elezione(30);

		for (ListaElettorale l : liste) {
			seggio.aggiungiLista(l);
		}

		seggio.scrutinaVoto(liste[0], new Voto(liste[0]));
		seggio.scrutinaVoto(liste[0], new Voto());
		seggio.scrutinaVoto(liste[1], new Voto(liste[1]));
		seggio.scrutinaVoto(liste[1], new Voto(liste[1]));
		seggio.scrutinaVoto(liste[0], new Voto(liste[0]));
		seggio.scrutinaVoto(liste[0], new Voto(liste[0]));
		seggio.scrutinaVoto(liste[0], new Voto(liste[0]));
		seggio.scrutinaVoto(liste[0], new Voto(liste[0]));
		seggio.scrutinaVoto(liste[0], new Voto(null));
		seggio.scrutinaVoto(liste[1], new Voto(liste[1]));

		for (ListaElettorale l : seggio.elencoOrdinato()) {
			l.stampa();
		}

	}
}
