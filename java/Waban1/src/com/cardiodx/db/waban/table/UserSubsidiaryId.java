package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * UserSubsidiaryId generated by hbm2java
 */
public class UserSubsidiaryId implements java.io.Serializable {

	private BigDecimal subsidiaryId;
	private String username;

	public UserSubsidiaryId() {
	}

	public UserSubsidiaryId(BigDecimal subsidiaryId, String username) {
		this.subsidiaryId = subsidiaryId;
		this.username = username;
	}

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserSubsidiaryId))
			return false;
		UserSubsidiaryId castOther = (UserSubsidiaryId) other;

		return ((this.getSubsidiaryId() == castOther.getSubsidiaryId()) || (this
				.getSubsidiaryId() != null
				&& castOther.getSubsidiaryId() != null && this
				.getSubsidiaryId().equals(castOther.getSubsidiaryId())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSubsidiaryId() == null ? 0 : this.getSubsidiaryId()
						.hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		return result;
	}

}
