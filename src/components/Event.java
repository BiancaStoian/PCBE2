package components;

public class Event {
	private EventType type;
	private Article article;
	
	public Event(EventType type, Article article){
		this.type = type;
		this.article = article;
	}
	
	public EventType getType () {
		return this.type;
	}
	
	public Article getArticle () {
		return this.article;
	}
	
	public String toString () {
		return "Event type: " + this.type + "\n"+ this.article;
	}
}
