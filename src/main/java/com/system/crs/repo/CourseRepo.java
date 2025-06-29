package com.system.crs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.crs.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, String>
{
	Optional<Course> findByCourseName(String courseName);
	 
	Optional<Course> findById(String id);
}
