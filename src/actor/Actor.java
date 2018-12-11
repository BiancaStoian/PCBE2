package actor;

import java.util.ArrayList;
import java.util.HashSet;

import components.Event;
import components.EventType;
import components.Filter;

public interface Actor {

	public void handleEvent(Event e);
	public void registerListener();
	/*public void interestedOf(String interest);
	public ArrayList<HashSet<String>> getInterest(); */
	void addFilter(String filter);
	public Filter getFilter();
}
