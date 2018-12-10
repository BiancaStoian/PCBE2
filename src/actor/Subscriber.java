package actor;

import java.util.ArrayList;

import components.Article;
import components.Event;
import components.EventType;
import dispatcher.Dispatcher;

public class Subscriber implements Actor{
	private String name;
	private ArrayList<ArrayList<String>> interests;
	
	public Subscriber (String name) {
		this.name = name;
		this.interests = new ArrayList<ArrayList<String>>();
		this.interests.add(new ArrayList<String>()); // Authors
		this.interests.add(new ArrayList<String>()); // Domains
		this.interests.add(new ArrayList<String>()); // Subdomains
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
	public void interestedOf (String interest) {
		int c = interest.indexOf(':');
		switch (interest.substring(0,c)) {
			case "Author": this.interests.get(0).add(interest.substring(c+1));
			case "Domain": this.interests.get(1).add(interest.substring(c+1));
			case "Subdomain": this.interests.get(2).add(interest.substring(c+1));
		}
		
	}

	@Override
	public ArrayList<ArrayList<String>> getInterest() {
		return this.interests;
	}
}
