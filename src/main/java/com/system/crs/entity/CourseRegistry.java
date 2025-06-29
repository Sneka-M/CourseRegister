package com.system.crs.entity;

import jakarta.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(
	    name = "course_registry",
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = {"course_id", "email_id"})
	    }
	)
public class CourseRegistry 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private String emailId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
	@JsonIgnore
	private Course course;
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
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public CourseRegistry(int id, String name, String emailId, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.course = course;
	}
	public CourseRegistry(String name, String emailId, Course course) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.course = course;
	}
	public CourseRegistry()
	{
		
	}
}
