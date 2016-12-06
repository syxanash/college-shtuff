package lab20120210;

public class Ora {
	private String nome;
	private Event event;
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getNome() {
		return nome;
	}

	public Ora(String nome, Event event) {
		this.nome = nome;
		this.event = event;
	}
}
