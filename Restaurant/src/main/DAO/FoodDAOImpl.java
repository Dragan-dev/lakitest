package main.DAO;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.entity.Food;

@Repository
public class FoodDAOImpl implements FoodDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public Food getFood(int id) {
		Session session=sessionFactory.getCurrentSession();
		return  session.get(Food.class, id);
		
	}

	@Transactional
	@Override
	public List<Food> getFoodList() {
		Session session=sessionFactory.getCurrentSession();
		Query<Food> query=session.createQuery("from Food", Food.class);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void deleteFood(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from Food where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}
	
	@Transactional
	@Override
	public void saveFood(Food food) {
		Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(food);
			}
		
		
		
	
	
	@Transactional
	@Override
	public List<Food> getFoodByCategory(int id) {
		Session session=sessionFactory.getCurrentSession();
	Query <Food> query=session.createQuery("from Food food where food.category.id=:id");
		query.setParameter("id", id);
		return query.getResultList();
	}

		

	@Transactional
	@Override
	public List<Food> getFoodsOnIndexPage() {
	Session session =sessionFactory.getCurrentSession();
	Query<Food> query=session.createQuery("select f from Food f where f.isOnIndexPage=1");
	List<Food> foodsIndex=query.getResultList();
	return foodsIndex;
			
	}

	

}
