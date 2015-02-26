package ro.fortech.dao.impl;

import junit.framework.TestCase;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import ro.fortech.bean.Grade;
import ro.fortech.dao.GradeDAO;

public class GradeDAOImplTest extends TestCase {
	
	private static GradeDAO gradeDao;

    public void setUp() throws Exception {
        super.setUp();
        gradeDao = new GradeDAOImpl();
    }

    @Test
    public void testAddGrade() throws Exception {
    	int initialSize = gradeDao.getSize();
    	
    	Grade grade = new Grade(1, "computer science", 9);
        gradeDao.addGrade(grade);
        assertThat(gradeDao.getSize()).isEqualTo(initialSize+1);
        Grade grade2 = new Grade(1, "math", 8);
        gradeDao.addGrade(grade2);
        assertThat(gradeDao.getSize()).isEqualTo(initialSize+2);
    }

}
