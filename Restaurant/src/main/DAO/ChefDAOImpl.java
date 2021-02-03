package main.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.entity.Chef;

@Repository
public class ChefDAOImpl implements ChefDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
		
	@Transactional
	@Override
	public List<Chef> getChefList() {
		Session session=sessionFactory.getCurrentSession();
		Query<Chef> chefList=session.createQuery("from Chef", Chef.class);
		return chefList.getResultList();
	}
	
	@Transactional
	@Override
	public void deleteChef(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query =session.createQuery("delete from Chef  where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	@Transactional
	@Override
	public void saveChef(Chef chef) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(chef);
		
	}
	
	@Transactional
	@Override
	public Chef getChef(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Chef.class, id);
	}

}
