package com.system.crs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.crs.entity.Course;
import com.system.crs.entity.CourseRegistry;

@Repository
public interface CourseRegistryRepo extends JpaRepository<CourseRegistry, Integer>
{

	List<CourseRegistry> findByCourse(Course course);

	boolean existsByEmailIdAndCourse(String emailId, Course course);
	
	@Query("Select cr.id, cr.name, cr.emailId, cr.course.courseName From CourseRegistry cr")
	List<Object[]> findAllStudents();

}
