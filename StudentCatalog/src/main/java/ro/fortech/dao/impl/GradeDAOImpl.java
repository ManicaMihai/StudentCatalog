package ro.fortech.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ro.fortech.bean.Grade;
import ro.fortech.bean.User;
import ro.fortech.dao.GradeDAO;

@Repository
public class GradeDAOImpl implements GradeDAO{

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addGrade(Grade grade) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(grade);
		logger.info("Grade saved successfully, grade Details=" + grade);		
	}

	@Override
	public void deleteGrade(int gradeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Grade grade = (Grade) session.load(Grade.class, new Integer(gradeId));
		if(null != grade){
			session.delete(grade);
			logger.info("Grade deleted successfully, grade details=" + grade);
		}
	}

	@Override
	public void updateGrade(Grade grade) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(grade);
		logger.info("Grade updated successfully, grade Details=" + grade);	
	}

	@Override
	public List<Grade> getAllGrades() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Grade> grades = session.createQuery("FROM Grade").list();
		for (Grade grade : grades) {
			logger.info("Grades List::" + grade);
		}
		return grades;
	}

	@Override
	public List<Grade> getAllGradesForStudentById(int studentId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Grade> grades = session.createQuery("FROM Grade WHERE studentId = " + studentId).list();
		for (Grade grade : grades) {
			logger.info("Grades List::" + grade);
		}
		return grades;
	}

	@Override
	public Grade getGradeById(int gradeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Grade grade = (Grade) session.load(Grade.class, new Integer(gradeId));
		logger.info("Grade loaded successfully, Grade details=" + grade);
		return grade;
	}

	@Override
	public List<User> getStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> students = session.createQuery("FROM User WHERE isTeacher = " + 0).list();
		for (User user : students) {
			logger.info("Grades List::" + user);
		}
		return students;
	}

	@Override
	public int getSize() {
		Session session = this.sessionFactory.getCurrentSession();
		return ((Long)session.createQuery("SELECT COUNT(*) FROM Grade").uniqueResult()).intValue();
	}

}
