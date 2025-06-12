package com.system.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.crs.entity.Course;
import com.system.crs.entity.CourseRegistry;
import com.system.crs.service.CourseService;

@RestController
public class CourseController 
{
	@Autowired
	CourseService courseService;
	
	@GetMapping("courses")
	public List<Course> availableCourses()
	{
		return courseService.availableCourses();
	}
	
	@GetMapping("courses/enrolled")
	public List<CourseRegistry> enrolledStudents()
	{
		return courseService.enrolledStudents();
	}
	
	@GetMapping("courses/{id}")
	public CourseRegistry getStudentById(@PathVariable("id") Integer id)
	{
		return courseService.getStudentsById(id);
	}
	
	@PostMapping("courses/register")
	public String enrollCourse(@RequestParam("name") String name, 
			@RequestParam("emailId") String emailId, 
			@RequestParam("courseName") String courseName)
	{
		courseService.enrollCourse(name, emailId, courseName);
		return "Congratulations! "+name + " Enrollment Successful for "+ courseName;
	}
}
