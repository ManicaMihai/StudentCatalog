package ro.fortech.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.fortech.bean.User;
import ro.fortech.dao.UserDAO;
import ro.fortech.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	@Transactional
	public void addUser(User user) {
		this.userDAO.addUser(user);		
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		this.userDAO.deleteUser(userId);		
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		this.userDAO.updateUser(user);
	}

	@Override
	@Transactional
	public List<User> getStudents() {
		return this.userDAO.getStudents();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public User checkUser(String username, String password) {
		return this.userDAO.checkUser(username, password);
	}

	@Override
	@Transactional
	public boolean checkIfUsernameExists(String username) {
		return this.userDAO.checkIfUsernameExists(username);
	}

}
