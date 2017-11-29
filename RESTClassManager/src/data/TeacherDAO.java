package data;

import java.util.List;

import entities.ClassRoster;

public interface TeacherDAO {
	//Controls Teacher, User
	public List<ClassRoster> showClassesByTeacherId(int tid);

}
