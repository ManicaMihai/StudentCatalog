package ro.fortech.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Grades", uniqueConstraints = {
		@UniqueConstraint(columnNames = "courseId"),
		@UniqueConstraint(columnNames = "studentId")})
public class Grade implements Serializable{
	private static final long serialVersionUID = -7788619177798333712L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)  
	@JoinColumn(name = "studentId", nullable=false, unique=true)  
	private User student;  
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId", nullable=false, unique=true)
	private Course course;
	
	@Column(name = "grade")
	private Integer grade;
	
	public Grade() {
	}

	public Grade(User student, Course course, Integer grade) {
		super();
		this.student = student;
		this.course = course;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Course getCourseId() {
		return course;
	}

	public void setCourseId(Course course) {
		this.course = course;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", student=" + student + ", courseId="
				+ course + ", grade=" + grade + "]";
	}
}
