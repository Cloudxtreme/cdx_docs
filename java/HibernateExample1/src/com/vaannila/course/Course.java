package com.vaannila.course;

// Generated Jul 12, 2011 5:20:14 PM by Hibernate Tools 3.4.0.CR1

/**
 * 	This class contains the course details.
 * 	
 */
public class Course implements java.io.Serializable {

	private long courseId;
	private String courseName;

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
