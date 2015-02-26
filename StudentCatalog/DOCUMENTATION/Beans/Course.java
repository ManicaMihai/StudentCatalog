package ro.fortech.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Courses", uniqueConstraints = {
		@UniqueConstraint(columnNames = "teacherId")})
public class Course implements Serializable{
	private static final long serialVersionUID = -7788619177798333712L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;


	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherId", nullable=false, unique=true)
	private User teacher;

	public Course() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacherId(User teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacherId="
				+ teacher + "]";
	}
}
