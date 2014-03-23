package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * UserRole generated by hbm2java
 */
public class UserRole implements java.io.Serializable {

	private String role;
	private Set<Users> userses = new HashSet<Users>(0);

	public UserRole() {
	}

	public UserRole(String role) {
		this.role = role;
	}

	public UserRole(String role, Set<Users> userses) {
		this.role = role;
		this.userses = userses;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
