package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

/**
 * PendingSubjectAttributeNameId generated by hbm2java
 */
public class PendingSubjectAttributeNameId implements java.io.Serializable {

	private String sponsorStudyNumber;
	private String variableName;

	public PendingSubjectAttributeNameId() {
	}

	public PendingSubjectAttributeNameId(String sponsorStudyNumber,
			String variableName) {
		this.sponsorStudyNumber = sponsorStudyNumber;
		this.variableName = variableName;
	}

	public String getSponsorStudyNumber() {
		return this.sponsorStudyNumber;
	}

	public void setSponsorStudyNumber(String sponsorStudyNumber) {
		this.sponsorStudyNumber = sponsorStudyNumber;
	}

	public String getVariableName() {
		return this.variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PendingSubjectAttributeNameId))
			return false;
		PendingSubjectAttributeNameId castOther = (PendingSubjectAttributeNameId) other;

		return ((this.getSponsorStudyNumber() == castOther
				.getSponsorStudyNumber()) || (this.getSponsorStudyNumber() != null
				&& castOther.getSponsorStudyNumber() != null && this
				.getSponsorStudyNumber().equals(
						castOther.getSponsorStudyNumber())))
				&& ((this.getVariableName() == castOther.getVariableName()) || (this
						.getVariableName() != null
						&& castOther.getVariableName() != null && this
						.getVariableName().equals(castOther.getVariableName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSponsorStudyNumber() == null ? 0 : this
						.getSponsorStudyNumber().hashCode());
		result = 37
				* result
				+ (getVariableName() == null ? 0 : this.getVariableName()
						.hashCode());
		return result;
	}

}
