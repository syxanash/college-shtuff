package patterns.design.abstractfactory;

import patterns.design.abstractfactory.entity.ScarpeAdidas;
import patterns.design.abstractfactory.entity.TutaAdidas;

public class CommessoAdidas extends Commesso {
	public Scarpe getScarpe() {
		return new ScarpeAdidas();
	}
	
	public Tuta getTuta() {
		return new TutaAdidas();
	}
}
