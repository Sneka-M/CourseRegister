package com.system.crs.exceptionHandler;

public class CourseNotFoundException extends RuntimeException
{
	public CourseNotFoundException(String msg)
	{
		super(msg);
	}
	
}
