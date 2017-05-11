package patterns.design.command;

import patterns.design.command.concrete.CommandPower;
import patterns.design.command.concrete.CommandVolumeDown;
import patterns.design.command.concrete.CommandVolumeUp;

public class Client {
	public static void main(String[] args) {
		TV vintageTV = new TV();
		
		// creo i comandi della TV
		
		Command cmdVolumeUp = new CommandVolumeUp(vintageTV);
		Command cmdPower = new CommandPower(vintageTV);
		Command cmdVolumeDown = new CommandVolumeDown(vintageTV);
		
		// costruisco un telecomando basandomi sui comandi creati per la tv
		
		RemoteControl remote = new RemoteControl(cmdVolumeUp, cmdPower, cmdVolumeDown);
		
		// ora posso usare il telecomando
		
		remote.pressButtonPower();  // turn on
		remote.pressButtonVolumeUp();
		remote.pressButtonVolumeDown();
		remote.pressButtonPower();  // turn off
	}
}
