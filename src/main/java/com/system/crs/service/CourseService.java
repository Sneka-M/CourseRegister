package com.system.crs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.crs.dto.CourseDTO;
import com.system.crs.dto.CourseDetailsResponse;
import com.system.crs.dto.CourseRegisterDTO;
import com.system.crs.dto.StudentDTO;
import com.system.crs.entity.Course;
import com.system.crs.entity.CourseRegistry;
import com.system.crs.exceptionHandler.CourseNotFoundException;
import com.system.crs.exceptionHandler.StudentNotFoundException;
import com.system.crs.repo.CourseRegistryRepo;
import com.system.crs.repo.CourseRepo;

@Service
public class CourseService
{
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	CourseRegistryRepo registerRepo;
	
	public List<Course> availableCourses()
	{
		return courseRepo.findAll();
	}

	public List<CourseRegisterDTO> enrolledStudents() {
		List<Object[]> results= registerRepo.findAllStudents();
		List<CourseRegisterDTO> lstDto= results.stream().map(result->
		{
			CourseRegisterDTO dto= new CourseRegisterDTO();
			dto.setId((int) result[0]);
			dto.setName((String) result[1]);
			dto.setEmailId((String) result[2]);
			dto.setCourseName((String) result[3]);
			return dto;
		}).collect(Collectors.toList());
		return lstDto;
	}

	public void registerUserToCourse(String name, String emailId, String courseName) {
	    // 1. Fetch the Course by courseId
	    Course course = courseRepo.findByCourseName(courseName)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid course ID: " + courseName));
	    
	    // 2. Optional: Prevent duplicate registration
	    boolean exists = registerRepo.existsByEmailIdAndCourse(emailId, course);
	    if (exists) {
	        throw new IllegalStateException("User already registered for this course.");
	    }

	    // 3. Save to CourseRegistry
	    CourseRegistry registry = new CourseRegistry();
	    registry.setName(name);
	    registry.setEmailId(emailId);
	    registry.setCourse(course); 

	    registerRepo.save(registry);
	}

	 public CourseDetailsResponse getCourseDetailsByName(String courseName) {
		    Course course = courseRepo.findByCourseName(courseName)
		            .orElseThrow(() -> new CourseNotFoundException("Given course not found"));

		    List<CourseRegistry> registries = registerRepo.findByCourse(course);

		    CourseDTO courseDTO = new CourseDTO(
		        course.getCourseId(), course.getCourseName(),
		        course.getTrainer(), course.getDurationInWeeks()
		    );

		    List<StudentDTO> students = registries.stream()
		            .map(reg -> new StudentDTO(reg.getId(), reg.getName(), reg.getEmailId()))
		            .collect(Collectors.toList());

		    return new CourseDetailsResponse(courseDTO, students);
		}

	 
	public CourseRegistry getStudentsById(Integer id) 
	{
		    return registerRepo.findById(id)
		            .orElseThrow(() -> new StudentNotFoundException("Student Not Found for this Id - " + id));
	}

}
