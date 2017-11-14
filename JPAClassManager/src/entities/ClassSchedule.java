package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClassSchedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="classID")
	private ClassRoster classRoster;
	
	@ManyToOne
	@JoinColumn(name="weekDayID")
	private WeekDay weekDay;

	public ClassRoster getClassRoster() {
		return classRoster;
	}

	public void setClassRoster(ClassRoster classRoster) {
		this.classRoster = classRoster;
	}

	public WeekDay getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ClassSchedule [id=" + id + ", classRoster=" + classRoster.getName() + ", weekDay=" + weekDay.getName() + "]";
	}
}
