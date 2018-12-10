package actor;

import java.util.ArrayList;
import java.util.HashMap;

import components.Article;
import components.Event;
import components.EventType;
import dispatcher.Dispatcher;

public class Publisher implements Actor {
	
	private String name;
	private static HashMap<String, Article> articles = new HashMap<>();
	
	public Publisher (String name) {
		this.name = name;
	}
	
	@Override
	public void handleEvent(Event e) {
		e.getArticle().readArticle();
		System.out.println("Publisher " + this.name + " received notification: " + e.getArticle().getTitle() + " was read. Total: " + e.getArticle().getViews());
	}
	
	@Override
	public void registerListener(EventType e){
		Dispatcher.getInstance().registerListener(e, this);
	}

	@Override
	public void interestedOf (String interest) {
		
	}

	@Override
	public ArrayList<ArrayList<String>> getInterest() {
		return null;
	}
	
	public void publishArticle (String title, String domain, String subdomain) {
		Article a = new Article(title, domain, subdomain, this.name);
		articles.put(title, a);
		Dispatcher.getInstance().notify(new Event(EventType.CREATE_ARTICLE, a));
	}
	
	public void modifyArticle (String title){
		Dispatcher.getInstance().notify(new Event(EventType.MODIFY_ARTICLE, articles.get(title)));
	}
	
	public void deteleArticle (String title){
		Dispatcher.getInstance().notify(new Event(EventType.REMOVE_ARTICLE, articles.get(title)));
		articles.remove(title);
	}
}
