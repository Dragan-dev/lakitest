package main.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import main.entity.Reservation;

@Repository
public class ReservationDAOImpl implements ReservationDAO{

		@Autowired
		private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public Reservation getReservation(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Reservation.class, id);
	}
	
	@Transactional
	@Override
	public List<Reservation> getReservationList() {
		Session session=sessionFactory.getCurrentSession();
		Query<Reservation> query=session.createQuery("from Reservation", Reservation.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void saveReservation(Reservation reservation) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(reservation);
	}
	
	@Transactional
	@Override
	public void deleteReservation(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Reservation where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Transactional
	@Override
	public long getUnreadResCount() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select count(*) from Reservation r where r.isRead=0");
		return (long)query.uniqueResult();
	}

}
