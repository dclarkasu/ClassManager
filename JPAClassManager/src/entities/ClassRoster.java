package entities;

import java.sql.Date;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Class")
public class ClassRoster {
	
	//ManyToMany bw classRoster to weekDay -->classSchedule
	//ManyToOne from classSchedule to classRoster
	//ManyToOne from weekDay to classSchedule
	//classSchedule: id, weekDayID, classRosterID
	//weekDay: id, name, potentially start and end times
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	
	//bi-directional
	@JsonBackReference(value="teacherToClass")
	@ManyToOne
	@JoinColumn(name="teacherID")
	private Teacher teacher;
	
	//bi-directional
	@JsonManagedReference(value="classToStudent")
	@OneToMany(mappedBy="classRoster")
	private List<Student> students;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="classSchedule",
	joinColumns=@JoinColumn(name="classID"),
	inverseJoinColumns=@JoinColumn(name="weekDayID")
	)
	private List<WeekDay> weekDays;
	
	@OneToMany(mappedBy="classRoster")
	private List<ClassSchedule> classSchedules;

	//Gets and Sets
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

	public List<WeekDay> getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(List<WeekDay> weekDays) {
		this.weekDays = weekDays;
	}

	public List<ClassSchedule> getClassSchedules() {
		return classSchedules;
	}

	public void setClassSchedules(List<ClassSchedule> classSchedules) {
		this.classSchedules = classSchedules;
	}

	@Override
	public String toString() {
		return "ClassRoster [id=" + id + ", name=" + name + ", teacher=" + teacher.getFirstName() + "]";
	}

}
