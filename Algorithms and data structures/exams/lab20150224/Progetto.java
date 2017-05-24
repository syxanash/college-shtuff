package lab20150224;

import java.util.Random;

public class Progetto {
	String nome;
	int codice;

	public Progetto(String nome) {
		this.nome = nome;

		this.codice = this.codice();
	}

	public int codice() {
		Random rnd = new Random();

		return rnd.nextInt();
	}
}
