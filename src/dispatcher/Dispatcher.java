package dispatcher;

import actor.Actor;
import components.EventType;
import components.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class Dispatcher {
	
	// Singleton.
	private static Dispatcher instance = null;
	
	// Events are mapped to interested actors. 
	private HashMap<EventType, ArrayList<Actor>> eventListeners = new HashMap<>();
	
	public static Dispatcher getInstance(){
		if(instance == null){
			instance = new Dispatcher();
		}
		return instance;
	}
	
	public void registerListener(EventType type, Actor actor){
		if (eventListeners.containsKey(type)) {
			eventListeners.get(type).add(actor);
		} else {
			ArrayList<Actor> list = new ArrayList<Actor>();
			list.add(actor);
			eventListeners.put(type, list);
		}
	}
	
	public void notify (Event e) {
		ArrayList<Actor> actors = eventListeners.get(e.getType());
		for (Actor a : actors) {
			//if(e.getArticle().compareInterests(a.getInterest()))
				a.handleEvent(e);
		}
	}
}
