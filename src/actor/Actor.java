package actor;

import java.util.ArrayList;

import components.Event;
import components.EventType;

public interface Actor {

	public void handleEvent(Event e);
	public void registerListener(EventType e);
	public void interestedOf(String interest);
	public ArrayList<ArrayList<String>> getInterest();
}
