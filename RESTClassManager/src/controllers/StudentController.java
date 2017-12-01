package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.StudentDAO;
import entities.Student;

@RestController
public class StudentController {
	//Controls Student, StudentRole, Role, Grade
	
	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping(path = "studentping", method = RequestMethod.GET)
	public String ping() {
	  return "pong";
	}
	
	@RequestMapping(path="students", method=RequestMethod.GET)
	public List<Student> indexStudents(HttpServletResponse res) {
		List<Student> students = studentDAO.indexStudents();
		return students;
	}
	
}
