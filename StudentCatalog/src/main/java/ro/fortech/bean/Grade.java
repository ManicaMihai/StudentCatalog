package ro.fortech.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Grade")
public class Grade implements Serializable{
	private static final long serialVersionUID = -7788619177798333712L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "studentId")
	private Integer studentId;  
	
	@Column(name = "courseName")
	private String courseName;
	
	@Column(name = "grade")
	private Integer grade;
	
	public Grade() {
	}
	
	public Grade(int studentId, String courseName, Integer grade) {
		super();
		this.studentId = studentId;
		this.courseName = courseName;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", studentId=" + studentId + ", courseName="
				+ courseName + ", grade=" + grade + "]";
	}	
}
