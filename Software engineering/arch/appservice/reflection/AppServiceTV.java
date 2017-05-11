package patterns.arch.appservice.reflection;

public class AppServiceTV implements ApplicationService {
	public void power() {
		System.out.println("you pressed power on TV");
	}
	
	public void volumeUp() {
		System.out.println("volume is now up");
	}
}
