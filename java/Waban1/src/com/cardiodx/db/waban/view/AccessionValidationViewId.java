package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * AccessionValidationViewId generated by hbm2java
 */
public class AccessionValidationViewId implements java.io.Serializable {

	private String studyNumber;
	private String accessionNumber;
	private String sampleTubeId;
	private Date dateCreated;
	private String clientSampleTubeId;
	private String value;

	public AccessionValidationViewId() {
	}

	public AccessionValidationViewId(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public AccessionValidationViewId(String studyNumber,
			String accessionNumber, String sampleTubeId, Date dateCreated,
			String clientSampleTubeId, String value) {
		this.studyNumber = studyNumber;
		this.accessionNumber = accessionNumber;
		this.sampleTubeId = sampleTubeId;
		this.dateCreated = dateCreated;
		this.clientSampleTubeId = clientSampleTubeId;
		this.value = value;
	}

	public String getStudyNumber() {
		return this.studyNumber;
	}

	public void setStudyNumber(String studyNumber) {
		this.studyNumber = studyNumber;
	}

	public String getAccessionNumber() {
		return this.accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public String getSampleTubeId() {
		return this.sampleTubeId;
	}

	public void setSampleTubeId(String sampleTubeId) {
		this.sampleTubeId = sampleTubeId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getClientSampleTubeId() {
		return this.clientSampleTubeId;
	}

	public void setClientSampleTubeId(String clientSampleTubeId) {
		this.clientSampleTubeId = clientSampleTubeId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AccessionValidationViewId))
			return false;
		AccessionValidationViewId castOther = (AccessionValidationViewId) other;

		return ((this.getStudyNumber() == castOther.getStudyNumber()) || (this
				.getStudyNumber() != null && castOther.getStudyNumber() != null && this
				.getStudyNumber().equals(castOther.getStudyNumber())))
				&& ((this.getAccessionNumber() == castOther
						.getAccessionNumber()) || (this.getAccessionNumber() != null
						&& castOther.getAccessionNumber() != null && this
						.getAccessionNumber().equals(
								castOther.getAccessionNumber())))
				&& ((this.getSampleTubeId() == castOther.getSampleTubeId()) || (this
						.getSampleTubeId() != null
						&& castOther.getSampleTubeId() != null && this
						.getSampleTubeId().equals(castOther.getSampleTubeId())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getClientSampleTubeId() == castOther
						.getClientSampleTubeId()) || (this
						.getClientSampleTubeId() != null
						&& castOther.getClientSampleTubeId() != null && this
						.getClientSampleTubeId().equals(
								castOther.getClientSampleTubeId())))
				&& ((this.getValue() == castOther.getValue()) || (this
						.getValue() != null && castOther.getValue() != null && this
						.getValue().equals(castOther.getValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudyNumber() == null ? 0 : this.getStudyNumber()
						.hashCode());
		result = 37
				* result
				+ (getAccessionNumber() == null ? 0 : this.getAccessionNumber()
						.hashCode());
		result = 37
				* result
				+ (getSampleTubeId() == null ? 0 : this.getSampleTubeId()
						.hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37
				* result
				+ (getClientSampleTubeId() == null ? 0 : this
						.getClientSampleTubeId().hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}
