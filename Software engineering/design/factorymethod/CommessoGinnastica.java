package patterns.design.factorymethod;

public class CommessoGinnastica extends Commesso {
	public Scarpe getScarpe() {
		return new ScarpeGinnastica();
	}
}
