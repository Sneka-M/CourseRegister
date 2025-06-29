package com.system.crs.dto;

public class CourseRegisterDTO {
	 private int id;
    private String name;
    private String emailId;
    private String courseName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public CourseRegisterDTO(int id, String name, String emailId, String courseName) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.courseName = courseName;
	}
	public CourseRegisterDTO() {
		super();
	}
    
    
}
