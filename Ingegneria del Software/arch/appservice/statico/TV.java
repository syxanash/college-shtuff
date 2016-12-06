package patterns.arch.appservice.statico;

/*
 * application service che possiede due metodi
 */

public class TV {
	public void power() {
		System.out.println("pressed button POWER");
	}
	
	public void volumeUp() {
		System.out.println("pressed VOLUME UP");
	}
}
