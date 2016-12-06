package patterns.design.abstractfactory;

import patterns.design.abstractfactory.entity.ScarpeNike;
import patterns.design.abstractfactory.entity.TutaNike;

public class CommessoNike extends Commesso {
	public Scarpe getScarpe() {
		return new ScarpeNike();
	}
	
	public Tuta getTuta() {
		return new TutaNike();
	}
}
