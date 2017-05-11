package lab20120210;

public class Secondo {
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

	public Secondo(String nome, Event event) {
		this.nome = nome;
		this.event = event;
	}
}
