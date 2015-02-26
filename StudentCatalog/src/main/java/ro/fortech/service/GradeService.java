package ro.fortech.service;

import java.util.List;

import ro.fortech.bean.Grade;
import ro.fortech.bean.User;

public interface GradeService {

	public void addGrade(Grade grade);

	public void deleteGrade(int gradeId);

	public void updateGrade(Grade grade);

	public List<Grade> getAllGrades();

	public List<Grade> getAllGradesForStudentById(int studentId);

	public Grade getGradeById(int gradeId);

	public List<User> getAllStudents();
	
}
