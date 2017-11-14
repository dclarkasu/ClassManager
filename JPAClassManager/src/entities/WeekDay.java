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

@Entity
public class WeekDay {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String startTime;
	
	private String endTime;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="classSchedule",
	joinColumns=@JoinColumn(name="weekDayID"),
	inverseJoinColumns=@JoinColumn(name="classID")
	)
	private List<ClassRoster> classes;
	
	@OneToMany(mappedBy="weekDay")
	private List<ClassSchedule> classSchedules;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<ClassRoster> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassRoster> classes) {
		this.classes = classes;
	}

	public List<ClassSchedule> getClassSchedules() {
		return classSchedules;
	}

	public void setClassSchedules(List<ClassSchedule> classSchedules) {
		this.classSchedules = classSchedules;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "WeekDay [id=" + id + ", name=" + name + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
