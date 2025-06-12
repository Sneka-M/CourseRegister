package com.system.crs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.crs.entity.Course;
import com.system.crs.entity.CourseRegistry;
import com.system.crs.repo.CourseRegistryRepo;
import com.system.crs.repo.CourseRepo;

@Service
public class CourseService
{
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	CourseRegistryRepo courseRegistry;
	
	public List<Course> availableCourses()
	{
		return courseRepo.findAll();
	}

	public List<CourseRegistry> enrolledStudents() {
		return courseRegistry.findAll();
	}

	public void enrollCourse(String name, String emailId, String courseName) {
		CourseRegistry courseRegister= new CourseRegistry(name, emailId, courseName);
		courseRegistry.save(courseRegister);
	}

	public CourseRegistry getStudentsById(Integer id) 
	{
		Optional<CourseRegistry> student= courseRegistry.findById(id);
		if(student.isPresent())
			return student.get();
		throw new RuntimeException("Student Not Found for this Id- "+ id);
	}

}
