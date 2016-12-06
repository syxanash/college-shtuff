package patterns.design.command;

/*
 * Classe INVOKER
 * memorizza il comando concreto da eseguire
 * e successivamente chiede al command di eseguire tale operazione
 */

public class RemoteControl {
	private Command buttonVolumeUp;
	private Command buttonPower;
	private Command buttonVolumeDown;

	public RemoteControl(Command volumeUp, Command power, Command volumeDown) {
		this.buttonVolumeUp = volumeUp;
		this.buttonPower = power;
		this.buttonVolumeDown = volumeDown;
	}
	
	public void pressButtonVolumeDown() {	
		buttonVolumeDown.execute();
	}

	public void pressButtonPower() {		
		buttonPower.execute();
	}
	
	public void pressButtonVolumeUp() {
		buttonVolumeUp.execute();
	}
}
