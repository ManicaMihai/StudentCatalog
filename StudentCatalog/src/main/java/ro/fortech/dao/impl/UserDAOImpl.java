package ro.fortech.dao.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ro.fortech.bean.User;
import ro.fortech.dao.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User user) {
		
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details=" + user);

		// Criteria cr = session.createCriteria(User.class);
		// cr.add(Restrictions.like("username", user.getUsername()));
		// List<User> users = cr.list();
		//
		// if (users.size() != 0) {
		// success = 0;
		// } else {
		// session.save(user);
		// success = 1;
		// }
		//

	}

	@Override
	public void deleteUser(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(userId));
		if(null != user){
			session.delete(user);
		}
		logger.info("User deleted successfully, user details=" + user);

	}

	@Override
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully, user Details=" + user);
	}

	@Override
	public List<User> getStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> students = session.createQuery("FROM Users WHERE isTeacher = 0").list();
		for (User user : students) {
			logger.info("Students List::" + user);
		}
		return students;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details=" + user);
		return user;
	}

	@Override
	public User checkUser(String username, String password) {
		User user = null;

		Session session = this.sessionFactory.getCurrentSession();

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.like("username", username));
		List<User> users = cr.list();

		if (users.size() == 1) {
			User user2 = (User) users.get(0);
			if (user2.getPassword().compareTo(DigestUtils.md5Hex(password)) == 0) {
				user = user2;
			}
		}

		return user;
	}

	@Override
	public boolean checkIfUsernameExists(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.like("username", username));
		List<User> users = cr.list();

		if (users.size() == 1) {
			return true;
		}
		
		return false;
	}

	@Override
	public int getSize() {
		Session session = this.sessionFactory.getCurrentSession();
		return ((Long)session.createQuery("SELECT COUNT(*) FROM User").uniqueResult()).intValue();
	}

}
