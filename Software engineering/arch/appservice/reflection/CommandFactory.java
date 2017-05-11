package patterns.arch.appservice.reflection;

/**
 * Questa classe rappresenta il mapper che realizza il pattern application service
 * con il command.
 * @author tinuslorvalds
 *
 */

public class CommandFactory {
	/*
	 * Associamo ad ogni caso d'uso power o volume up
	 * una coppia di Application service specifico e il metodo che dovra'
	 * eseguire. Passiamo a TV command che eseguira questi due senza conoscere
	 * nello specifico che classe e che metodo sta trattando.
	 */
	
	public static Command getCommand(String useCase) {
		if (useCase.compareTo("power") == 0) {
			return new TVCommand(new AppServiceTV(), "power");
		} else if (useCase.compareTo("volume up") == 0) {
			return new TVCommand(new AppServiceTV(), "volumeUp");
		}		
		
		return null;
	}
}
