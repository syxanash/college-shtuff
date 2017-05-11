package patterns.design.command.concrete;

import patterns.design.command.Command;
import patterns.design.command.TV;

/*
 * Classe CONCRETE COMMAND
 */

public class CommandVolumeUp extends Command {
	
	private TV myTV;
	
	// nel costruttore setto un oggetto di tipo TV receiver
	// che utilizzerò per richiamare il suo metodo specifico senza
	// farlo sapere alla classe client
	
	public CommandVolumeUp(TV someTV) {
		myTV = someTV;
	}
	
	@Override
	public void execute() {
		myTV.volumeUp();
	}

}
