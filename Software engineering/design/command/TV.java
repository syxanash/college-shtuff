package patterns.design.command;

/*
 * Classe RECEIVER
 */

public class TV {
	private boolean state = false;
	
	public void power() {
		state = !state;
		
		String tvState = state ? "ON" : "OFF";
		
		System.out.println("you pressed power button TV is now " + tvState + "! *ZAP*");
	}
	
	public void volumeUp() {
		System.out.println("volume is now up! *BOOM* *BOOM*");
	}
	
	public void volumeDown() {
		System.out.println("volume is now down! *bzz* *bzz*");
	}
}
