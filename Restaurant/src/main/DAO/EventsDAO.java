package main.DAO;

import java.util.List;

import main.entity.Events;

public interface EventsDAO {
	
	public List<Events> getEventsList();
	public Events getEvent(int id);
	public void saveEvent(Events event);
	public void deleteEvent(int id);
	
	
	
}
