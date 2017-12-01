package data;

import java.util.List;

import entities.ClassRoster;
import entities.Teacher;
import entities.User;

public interface TeacherDAO {
	//Controls Teacher, User
	
	//Teacher Home
	public Teacher showTeacherByTeacherID(int tid);
	public Teacher updateTeacher(int tid, String teacherJSON);
	
	public List<ClassRoster> showClassesByTeacherID(int tid);
	
	
	
	//User
	public User registerNewUser(String userJSON);
	//Login method??
	//Not sure if these are required or if you will just show, update, delete through teacher
	public User showUserByID(int uid);
	//or
	//public User showUserByTeacherID(int tid);
	public User updateUser(int uid, String userJSON);
	public boolean deleteUserByID(int uid);//or teacher id?
}
