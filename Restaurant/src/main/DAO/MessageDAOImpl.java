package main.DAO;


import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import main.entity.Message;


@Repository
public class MessageDAOImpl implements MessageDAO{
	
		@Autowired
		private SessionFactory sessionFactory;

		@Transactional	
		@Override
		public Message getMessage(int id) {
			Session session=sessionFactory.getCurrentSession();
			return session.get(Message.class, id);
			
		}
			
			 
		@Transactional
		@Override
		public void deleteMessage(int id) {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("delete from Message where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();
		}
			
		@Transactional
		@Override
		public void saveMessage(Message message) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(message);
			
		}

		@Transactional
		@Override
		public long getUnreadMessageCount() {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("select count(*) from Message m where m.isSeen=0");		
			
			return (long)query.uniqueResult();
		}

		
		@Transactional
		@Override
		public List<Message> getMessageList() {
			Session session= sessionFactory.getCurrentSession();
			Query<Message> query=session.createQuery("from Message", Message.class);
			return query.getResultList();
		}

		
		
		
		
		
}
