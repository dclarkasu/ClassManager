package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.TeacherDAO;
import entities.ClassRoster;

@RestController
public class TeacherController {
	//Controls Teacher, User
	
	@Autowired
	private TeacherDAO teacherDAO;
	
	@RequestMapping(path = "teacherping", method = RequestMethod.GET)
	public String ping() {
	  return "pong";
	}
	
	@RequestMapping(path="user/classes/{tid}", method=RequestMethod.GET)
	public List<ClassRoster> showClassesByTeacherId(HttpServletResponse res,@PathVariable int tid) {
		List<ClassRoster> classes = teacherDAO.showClassesByTeacherId(tid);
		System.out.println("in show classes controller");
		if (classes != null) {
			return classes;
		}
		else {
			res.setStatus(404);
			return null;
		}
	}
}
