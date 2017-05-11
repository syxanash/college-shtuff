package patterns.design.command.concrete;

import patterns.design.command.Command;
import patterns.design.command.TV;

public class CommandVolumeDown extends Command {

	private TV myTV;
	
	public CommandVolumeDown(TV someTV) {
		myTV = someTV;
	}
	
	@Override
	public void execute() {
		myTV.volumeDown();
	}

}
