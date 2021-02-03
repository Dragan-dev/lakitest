package main.DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.entity.Events;

@Repository
public class EventsDAOImlp  implements EventsDAO{
	
	@Autowired	
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Events> getEventsList() {
		Session session=sessionFactory.getCurrentSession();
		Query<Events> eventList=session.createQuery("from Events", Events.class);
		return eventList.getResultList();
	}
	
	
	@Transactional
	@Override
	public Events getEvent(int id) {
	Session session=sessionFactory.getCurrentSession();
	return session.get(Events.class, id);
	}
	
	
	@Transactional
	@Override
	public void saveEvent(Events event) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(event);
	}
	
	
	@Transactional
	@Override
	public void deleteEvent(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query =session.createQuery("delete from Events where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
