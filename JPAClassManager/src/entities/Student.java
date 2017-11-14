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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	//uni-directional
	@ManyToOne
	@JoinColumn(name="classID")
	private ClassRoster classRoster;
	
	@ManyToOne
	@JoinColumn(name="gradeID")
	private Grade grade;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="student_role",
	joinColumns=@JoinColumn(name="studentID"),
	inverseJoinColumns=@JoinColumn(name="roleID")
	)
	private List<Role> roles;
	
	//One to many student_role
	@OneToMany(mappedBy="student")
	private List<StudentRole> studentRoles;

	
	//Gets and Sets
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ClassRoster getClassRoster() {
		return classRoster;
	}

	public void setClassRoster(ClassRoster classRoster) {
		this.classRoster = classRoster;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<StudentRole> getStudentRoles() {
		return studentRoles;
	}

	public void setStudentRoles(List<StudentRole> studentRoles) {
		this.studentRoles = studentRoles;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + "]";
	}

}
