package patterns.design.factorymethod;

/* questo metodo offre una interfaccia alla classe client
 * che non sa il criterio di selezione della classe che verra' istanziata
 * per cui questa astrazione Commesso delega a delle sotto classi
 * la funzione di istanziare una specifica classe che può essere
 * scarpe Tennis o ginnastica
 */

public abstract class Commesso  {
	public abstract Scarpe getScarpe();  // il famoso factory method
	
	public static Commesso getCommesso(String tipo) {
		Commesso personale = null;
		
		if (tipo.compareTo("tennis") == 0 ) {
			personale = new CommessoTennis();
		} else if (tipo.compareTo("ginnastica") == 0) {
			personale = new CommessoGinnastica();
		}
		
		return personale;
	}
}
