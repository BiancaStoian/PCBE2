package actor;

import java.util.ArrayList;
import java.util.HashSet;

import components.Article;
import components.Event;
import components.EventType;
import components.Filter;
import dispatcher.Dispatcher;

public class Subscriber implements Actor{
	private String name;
	private Filter filter; 
	
	public Subscriber (String name) {
		this.name = name;
		this.filter = new Filter();
	}
	
	@Override
	public void handleEvent(Event e) {
		// TODO Auto-generated method stub
		switch (e.getType()) {
		case CREATE_ARTICLE: handleCreateArticle(e.getArticle()); break;
		case MODIFY_ARTICLE: handleModifyArticle(e.getArticle()); break;
		case REMOVE_ARTICLE: handleRemoveArticle(e.getArticle()); break;
		default: break;
		}
	}
	
	public void handleCreateArticle (Article article) {
		System.out.println("Subscriber " + this.name + " received notification: " + article.getTitle() + " was published.");
		readOrNot(article);
	}
	
	public void handleModifyArticle (Article article) {
		System.out.println("Subscriber " + this.name + " received notification: " + article.getTitle() + " was modified.");
		readOrNot(article);
	}
	
	public void handleRemoveArticle (Article article) {
		System.out.println("Subscriber " + this.name + " received notification: " + article.getTitle() + " was removed.");
	}
	
	private void readOrNot(Article article) {
		int rand = (int)(Math.random()*10); 
		if (rand % 2 == 1) {
			System.out.println("Subscriber " + this.name + " reads article " + article.getTitle() + ".");
			Dispatcher.getInstance().notify(new Event(EventType.READ_ARTICLE, article));
		} else {
			System.out.println("Subscriber " + this.name + " does not read article " + article.getTitle() + ".");
		}
	}
	
	@Override
	public void registerListener(EventType e) {
		Dispatcher.getInstance().registerListener(e, this);
	}

	@Override 
	public void addFilter (String filter) {
		if (this.filter == null) {
			this.filter = new Filter();
		}
		this.filter.addFilter(filter);
	}
	
	@Override
	public Filter getFilter () {
		return this.filter;
	}
}
