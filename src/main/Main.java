package main;

import actor.Publisher;
import actor.Subscriber;
import components.EventType;

public class Main {
	public static void main (String args[]) {
		Publisher p1 = new Publisher("Publisher1");
		Subscriber c1 = new Subscriber("Cititor1");
		Subscriber c2 = new Subscriber("Cititor2");
		
		c1.registerListener();
		c1.addFilter("Domain: Sport");
		
		c2.registerListener();
		c2.addFilter("Author: Publisher1");
		
		p1.registerListener();
		p1.publishArticle("Titlu1", "Sport", "Tennis");
		
		System.out.println();
		p1.publishArticle("Vreme Timisoara", "Vreme", null);
	}
}