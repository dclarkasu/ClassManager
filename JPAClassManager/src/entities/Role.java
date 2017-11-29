package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	private boolean isCurrent;
	
	
	//One to many Student_role
	@JsonIgnore
	@OneToMany(mappedBy="role")
	private List<StudentRole> studentRoles;
	
	//manytomany student
	@JsonIgnore
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="student_role",
	joinColumns=@JoinColumn(name="roleID"),
	inverseJoinColumns=@JoinColumn(name="studentID")
	)
	private List<Student> students;
	
	
	//Gets and Sets
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}


	public List<StudentRole> getStudentRoles() {
		return studentRoles;
	}

	public void setStudentRoles(List<StudentRole> studentRoles) {
		this.studentRoles = studentRoles;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", isCurrent=" + isCurrent + "]";
	}
}
