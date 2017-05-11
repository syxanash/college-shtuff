package patterns.design.command.concrete;

import patterns.design.command.Command;
import patterns.design.command.TV;

/*
 * Classe CONCRETE COMMAND
 * E' la classe che si occupa di fare un binding tra
 * la classe receiver TV e l'operazione corrispondente ad esempio
 * Power sulla classe receiver.
 */

public class CommandPower extends Command {
	private TV myTV;
	
	public CommandPower(TV someTV) {
		myTV = someTV;
	}

	@Override
	public void execute() {
		myTV.power();
	}
}
