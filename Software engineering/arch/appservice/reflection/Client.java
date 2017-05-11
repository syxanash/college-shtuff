package patterns.arch.appservice.reflection;

public class Client {
	public static void main(String[] args) {
		Command cmd = CommandFactory.getCommand("volume up");
		cmd.execute();
	}
}
