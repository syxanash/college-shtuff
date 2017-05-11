package patterns.arch.appservice.statico;

public class CommandFactory {
	public static Command getCommand(String useCase) {
		Command result = null;
		
		if (useCase.compareTo("power") == 0) {
			result = new TVPowerCommand(new TV());
		} else if (useCase.compareTo("volume up") == 0) {
			result = new TVVolumeUpCommand(new TV());
		}
		
		return result;
	}
}
