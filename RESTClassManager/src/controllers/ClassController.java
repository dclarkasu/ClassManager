package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.ClassDAO;

@RestController
public class ClassController {
	
	//Will control ClassRoster, ClassSchedule, WeekDay
	
//	@Autowired
//	private ClassDAO classDAO;
	
	@RequestMapping(path = "classping", method = RequestMethod.GET)
	public String ping() {
	  return "pong";
	}

}
