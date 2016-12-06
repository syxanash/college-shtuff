package patterns.arch.appservice.statico;

public class TVVolumeUpCommand implements Command {
	private TV myTV;
	
	public TVVolumeUpCommand(TV someTV) {
		myTV = someTV;
	}
	
	public void execute() {
		myTV.volumeUp();
	}
}
