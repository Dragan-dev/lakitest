package main.DAO;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.entity.Category;


@Repository

	public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public Category getCategory(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Category.class,id);
		
	}
	
	@Transactional
	@Override
	public List<Category> getCategoryList() {
		Session session=sessionFactory.getCurrentSession();
		Query<Category> query =session.createQuery("from Category", Category.class);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void deleteCategory(int id) {
	Session session= sessionFactory.getCurrentSession();
	Query query=session.createQuery("delete from Category where id=:id");
	query.setParameter("id", id);
	query.executeUpdate();
	}
	
	
	@Transactional
	@Override
	public void saveCategory(Category category) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		
	}

}
