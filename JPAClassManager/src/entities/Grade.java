package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Grade {
	
	private int id;
	
	private int level;
	
	//??????????
	@OneToMany(mappedBy="grade")
	private List<Student> students;

}
