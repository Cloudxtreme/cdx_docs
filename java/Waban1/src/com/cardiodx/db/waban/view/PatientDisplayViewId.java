package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * PatientDisplayViewId generated by hbm2java
 */
public class PatientDisplayViewId implements java.io.Serializable {

	private BigDecimal studyProtocolId;
	private String studyNumber;
	private String sponsorStudyNumber;
	private BigDecimal patientId;
	private String displayId;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

	public PatientDisplayViewId() {
	}

	public PatientDisplayViewId(BigDecimal studyProtocolId,
			BigDecimal patientId, String displayId) {
		this.studyProtocolId = studyProtocolId;
		this.patientId = patientId;
		this.displayId = displayId;
	}

	public PatientDisplayViewId(BigDecimal studyProtocolId, String studyNumber,
			String sponsorStudyNumber, BigDecimal patientId, String displayId,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified) {
		this.studyProtocolId = studyProtocolId;
		this.studyNumber = studyNumber;
		this.sponsorStudyNumber = sponsorStudyNumber;
		this.patientId = patientId;
		this.displayId = displayId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public String getStudyNumber() {
		return this.studyNumber;
	}

	public void setStudyNumber(String studyNumber) {
		this.studyNumber = studyNumber;
	}

	public String getSponsorStudyNumber() {
		return this.sponsorStudyNumber;
	}

	public void setSponsorStudyNumber(String sponsorStudyNumber) {
		this.sponsorStudyNumber = sponsorStudyNumber;
	}

	public BigDecimal getPatientId() {
		return this.patientId;
	}

	public void setPatientId(BigDecimal patientId) {
		this.patientId = patientId;
	}

	public String getDisplayId() {
		return this.displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PatientDisplayViewId))
			return false;
		PatientDisplayViewId castOther = (PatientDisplayViewId) other;

		return ((this.getStudyProtocolId() == castOther.getStudyProtocolId()) || (this
				.getStudyProtocolId() != null
				&& castOther.getStudyProtocolId() != null && this
				.getStudyProtocolId().equals(castOther.getStudyProtocolId())))
				&& ((this.getStudyNumber() == castOther.getStudyNumber()) || (this
						.getStudyNumber() != null
						&& castOther.getStudyNumber() != null && this
						.getStudyNumber().equals(castOther.getStudyNumber())))
				&& ((this.getSponsorStudyNumber() == castOther
						.getSponsorStudyNumber()) || (this
						.getSponsorStudyNumber() != null
						&& castOther.getSponsorStudyNumber() != null && this
						.getSponsorStudyNumber().equals(
								castOther.getSponsorStudyNumber())))
				&& ((this.getPatientId() == castOther.getPatientId()) || (this
						.getPatientId() != null
						&& castOther.getPatientId() != null && this
						.getPatientId().equals(castOther.getPatientId())))
				&& ((this.getDisplayId() == castOther.getDisplayId()) || (this
						.getDisplayId() != null
						&& castOther.getDisplayId() != null && this
						.getDisplayId().equals(castOther.getDisplayId())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getModifiedBy() == castOther.getModifiedBy()) || (this
						.getModifiedBy() != null
						&& castOther.getModifiedBy() != null && this
						.getModifiedBy().equals(castOther.getModifiedBy())))
				&& ((this.getDateModified() == castOther.getDateModified()) || (this
						.getDateModified() != null
						&& castOther.getDateModified() != null && this
						.getDateModified().equals(castOther.getDateModified())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudyProtocolId() == null ? 0 : this.getStudyProtocolId()
						.hashCode());
		result = 37
				* result
				+ (getStudyNumber() == null ? 0 : this.getStudyNumber()
						.hashCode());
		result = 37
				* result
				+ (getSponsorStudyNumber() == null ? 0 : this
						.getSponsorStudyNumber().hashCode());
		result = 37 * result
				+ (getPatientId() == null ? 0 : this.getPatientId().hashCode());
		result = 37 * result
				+ (getDisplayId() == null ? 0 : this.getDisplayId().hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37
				* result
				+ (getModifiedBy() == null ? 0 : this.getModifiedBy()
						.hashCode());
		result = 37
				* result
				+ (getDateModified() == null ? 0 : this.getDateModified()
						.hashCode());
		return result;
	}

}
