package ro.fortech.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.fortech.bean.Grade;
import ro.fortech.bean.User;
import ro.fortech.dao.GradeDAO;
import ro.fortech.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService{

	private GradeDAO gradeDAO;

	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}
	
	@Override
	@Transactional
	public void addGrade(Grade grade) {
		this.gradeDAO.addGrade(grade);
	}

	@Override
	@Transactional
	public void deleteGrade(int gradeId) {
		this.gradeDAO.deleteGrade(gradeId);
	}

	@Override
	@Transactional
	public void updateGrade(Grade grade) {
		this.gradeDAO.updateGrade(grade);
	}

	@Override
	@Transactional
	public List<Grade> getAllGrades() {
		return this.gradeDAO.getAllGrades();
	}

	@Override
	@Transactional
	public List<Grade> getAllGradesForStudentById(int studentId) {
		return this.gradeDAO.getAllGradesForStudentById(studentId);
	}

	@Override
	@Transactional
	public Grade getGradeById(int gradeId) {
		return this.gradeDAO.getGradeById(gradeId);
	}

	@Override
	@Transactional
	public List<User> getAllStudents() {
		return this.gradeDAO.getStudents();
	}

}
