package com.system.crs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.crs.dto.CourseDetailsResponse;
import com.system.crs.dto.CourseRegisterDTO;
import com.system.crs.entity.Course;
import com.system.crs.entity.CourseRegistry;
import com.system.crs.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController 
{
	@Autowired
	CourseService courseService;
	
	@GetMapping("/available")
	public List<Course> availableCourses()
	{
		return courseService.availableCourses();
	}
	
	@GetMapping("/enrolledStudents")
	public List<CourseRegisterDTO> enrolledStudents()
	{
		return courseService.enrolledStudents();
	}
	
	@GetMapping("/student/{id}")
	public CourseRegistry getStudentById(@PathVariable("id") Integer id)
	{
		return courseService.getStudentsById(id);
	}
	
	@GetMapping("/getCourse/{courseName}")
	public ResponseEntity<CourseDetailsResponse> getByName(@PathVariable String courseName) {
	    CourseDetailsResponse response = courseService.getCourseDetailsByName(courseName);
	    return ResponseEntity.ok(response);
	}
	
	@PostMapping("/registerStudent")
	public String enrollCourse(@RequestParam("name") String name, 
			@RequestParam("emailId") String emailId, 
			@RequestParam("courseName") String courseName)
	{
		courseService.registerUserToCourse(name, emailId, courseName);
		return "Congratulations! "+name + " Enrollment Successful for "+ courseName;
	}
}
