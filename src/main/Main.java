package main;

import actor.Publisher;
import actor.Subscriber;
import components.EventType;

public class Main {
	public static void main (String args[]) {
		Publisher p1 = new Publisher("Publisher1");
		Subscriber c1 = new Subscriber("Cititor1");
		Subscriber c2 = new Subscriber("Cititor2");
		
		c1.registerListener(EventType.CREATE_ARTICLE);
		c1.registerListener(EventType.REMOVE_ARTICLE);
		c1.registerListener(EventType.MODIFY_ARTICLE);
		
		c2.registerListener(EventType.CREATE_ARTICLE);
		c2.registerListener(EventType.REMOVE_ARTICLE);
		c2.registerListener(EventType.MODIFY_ARTICLE);
		
		p1.registerListener(EventType.READ_ARTICLE);
		
		p1.publishArticle("Titlu1", "Sport", "Tennis");
		
		System.out.println();
		p1.publishArticle("Vreme Timisoara", "Vreme", null);
	}
}