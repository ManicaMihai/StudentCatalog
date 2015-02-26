package ro.fortech.dao;

import java.util.List;

import ro.fortech.bean.Grade;
import ro.fortech.bean.User;

public interface GradeDAO {

	public void addGrade(Grade grade);

	public void deleteGrade(int gradeId);

	public void updateGrade(Grade grade);

	public List<Grade> getAllGrades();
	
	public List<Grade> getAllGradesForStudentById(int studentId);

	public Grade getGradeById(int gradeId);
	
	public int getSize();

	public List<User> getStudents();

}
