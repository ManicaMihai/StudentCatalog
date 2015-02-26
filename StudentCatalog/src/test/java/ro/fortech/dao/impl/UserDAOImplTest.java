package ro.fortech.dao.impl;

import junit.framework.TestCase;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import ro.fortech.bean.User;
import ro.fortech.dao.UserDAO;

public class UserDAOImplTest extends TestCase {
	
	private static UserDAO userDao;

    public void setUp() throws Exception {
        super.setUp();
        userDao = new UserDAOImpl();
    }

    @Test
    public void testAddUser() throws Exception {
    	int initialSize = userDao.getSize();

    	User user = new User("UserProba1", "UserProba1", false, "UserProba1", "UserProba1");
    	userDao.addUser(user);
        assertThat(userDao.getSize()).isEqualTo(initialSize+1);
        
        User user2 = new User("UserProba2", "UserProba2", false, "UserProba2", "UserProba2");
    	userDao.addUser(user2);
        assertThat(userDao.getSize()).isEqualTo(initialSize+2);
    }

}
