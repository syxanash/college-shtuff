package patterns.arch.appservice.statico;

/*
 * Quando si implementa il pattern command senza la riflessione
 * dovremo implementare una classe per ogni comando associato
 * all'application service (TV nel nostro caso)
 */

public class TVPowerCommand implements Command {

	private TV myTV;
	
	public TVPowerCommand(TV someTV) {
		myTV = someTV;
	}
	
	public void execute() {
		myTV.power();
	}
}
