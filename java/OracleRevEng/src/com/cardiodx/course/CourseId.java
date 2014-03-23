package com.cardiodx.course;

// Generated Jul 14, 2011 9:07:31 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * CourseId generated by hbm2java
 */
public class CourseId implements java.io.Serializable {

	private BigDecimal courseid;
	private String coursename;

	public CourseId() {
	}

	public CourseId(BigDecimal courseid, String coursename) {
		this.courseid = courseid;
		this.coursename = coursename;
	}

	public BigDecimal getCourseid() {
		return this.courseid;
	}

	public void setCourseid(BigDecimal courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CourseId))
			return false;
		CourseId castOther = (CourseId) other;

		return ((this.getCourseid() == castOther.getCourseid()) || (this
				.getCourseid() != null && castOther.getCourseid() != null && this
				.getCourseid().equals(castOther.getCourseid())))
				&& ((this.getCoursename() == castOther.getCoursename()) || (this
						.getCoursename() != null
						&& castOther.getCoursename() != null && this
						.getCoursename().equals(castOther.getCoursename())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCourseid() == null ? 0 : this.getCourseid().hashCode());
		result = 37
				* result
				+ (getCoursename() == null ? 0 : this.getCoursename()
						.hashCode());
		return result;
	}

}
