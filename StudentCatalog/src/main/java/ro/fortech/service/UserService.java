package ro.fortech.service;

import java.util.List;
import ro.fortech.bean.User;

public interface UserService {

	public void addUser(User user);

	public void deleteUser(int userId);

	public void updateUser(User user);

	public List<User> getStudents();

	public User getUserById(int id);

	public User checkUser(String username, String password);

	public boolean checkIfUsernameExists(String username);

}
