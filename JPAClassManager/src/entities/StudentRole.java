package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_role")
public class StudentRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//student manytoone
	@ManyToOne
	@JoinColumn(name="studentID")
	private Student student;
	
	//role manytoone
	@ManyToOne
	@JoinColumn(name="roleID")
	private Role role;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "StudentRole [id=" + id + ", student=" + student.getFirstName() + ", role=" + role.getName() + "]";
	}
	
	
}
