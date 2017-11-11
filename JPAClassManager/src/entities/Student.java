package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	@ManyToMany
	@JoinTable(name="student_role")
	private List<Role> roles;

}
