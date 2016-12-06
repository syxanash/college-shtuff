package patterns.arch.appservice.statico;

public class Client {
	public static void main(String[] args) {
		Command cmd = CommandFactory.getCommand("power");
		cmd.execute();
	}
}
