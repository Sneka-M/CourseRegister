package com.system.crs.dto;

import java.util.List;

public class CourseDetailsResponse {
    private CourseDTO course;
    private List<StudentDTO> enrolledStudents;

    public CourseDetailsResponse(CourseDTO course, List<StudentDTO> enrolledStudents) {
        this.course = course;
        this.enrolledStudents = enrolledStudents;
    }

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

	public List<StudentDTO> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<StudentDTO> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

    
}
