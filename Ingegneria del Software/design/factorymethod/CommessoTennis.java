package patterns.design.factorymethod;

public class CommessoTennis extends Commesso {
	public Scarpe getScarpe() {
		return new ScarpeTennis();
	}
}
