package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AnonymizationRequestViewId generated by hbm2java
 */
public class AnonymizationRequestViewId implements java.io.Serializable {

	private BigDecimal anonymizationRequestId;
	private String createdBy;
	private Date dateCreated;
	private Date dateModified;
	private String modifiedBy;
	private String requestCompletionStatus;
	private String requestMessage;
	private String requestType;
	private String studyNumber;
	private BigDecimal studyProtocolId;

	public AnonymizationRequestViewId() {
	}

	public AnonymizationRequestViewId(BigDecimal anonymizationRequestId,
			BigDecimal studyProtocolId) {
		this.anonymizationRequestId = anonymizationRequestId;
		this.studyProtocolId = studyProtocolId;
	}

	public AnonymizationRequestViewId(BigDecimal anonymizationRequestId,
			String createdBy, Date dateCreated, Date dateModified,
			String modifiedBy, String requestCompletionStatus,
			String requestMessage, String requestType, String studyNumber,
			BigDecimal studyProtocolId) {
		this.anonymizationRequestId = anonymizationRequestId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.modifiedBy = modifiedBy;
		this.requestCompletionStatus = requestCompletionStatus;
		this.requestMessage = requestMessage;
		this.requestType = requestType;
		this.studyNumber = studyNumber;
		this.studyProtocolId = studyProtocolId;
	}

	public BigDecimal getAnonymizationRequestId() {
		return this.anonymizationRequestId;
	}

	public void setAnonymizationRequestId(BigDecimal anonymizationRequestId) {
		this.anonymizationRequestId = anonymizationRequestId;
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

	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getRequestCompletionStatus() {
		return this.requestCompletionStatus;
	}

	public void setRequestCompletionStatus(String requestCompletionStatus) {
		this.requestCompletionStatus = requestCompletionStatus;
	}

	public String getRequestMessage() {
		return this.requestMessage;
	}

	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}

	public String getRequestType() {
		return this.requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getStudyNumber() {
		return this.studyNumber;
	}

	public void setStudyNumber(String studyNumber) {
		this.studyNumber = studyNumber;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AnonymizationRequestViewId))
			return false;
		AnonymizationRequestViewId castOther = (AnonymizationRequestViewId) other;

		return ((this.getAnonymizationRequestId() == castOther
				.getAnonymizationRequestId()) || (this
				.getAnonymizationRequestId() != null
				&& castOther.getAnonymizationRequestId() != null && this
				.getAnonymizationRequestId().equals(
						castOther.getAnonymizationRequestId())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getDateModified() == castOther.getDateModified()) || (this
						.getDateModified() != null
						&& castOther.getDateModified() != null && this
						.getDateModified().equals(castOther.getDateModified())))
				&& ((this.getModifiedBy() == castOther.getModifiedBy()) || (this
						.getModifiedBy() != null
						&& castOther.getModifiedBy() != null && this
						.getModifiedBy().equals(castOther.getModifiedBy())))
				&& ((this.getRequestCompletionStatus() == castOther
						.getRequestCompletionStatus()) || (this
						.getRequestCompletionStatus() != null
						&& castOther.getRequestCompletionStatus() != null && this
						.getRequestCompletionStatus().equals(
								castOther.getRequestCompletionStatus())))
				&& ((this.getRequestMessage() == castOther.getRequestMessage()) || (this
						.getRequestMessage() != null
						&& castOther.getRequestMessage() != null && this
						.getRequestMessage().equals(
								castOther.getRequestMessage())))
				&& ((this.getRequestType() == castOther.getRequestType()) || (this
						.getRequestType() != null
						&& castOther.getRequestType() != null && this
						.getRequestType().equals(castOther.getRequestType())))
				&& ((this.getStudyNumber() == castOther.getStudyNumber()) || (this
						.getStudyNumber() != null
						&& castOther.getStudyNumber() != null && this
						.getStudyNumber().equals(castOther.getStudyNumber())))
				&& ((this.getStudyProtocolId() == castOther
						.getStudyProtocolId()) || (this.getStudyProtocolId() != null
						&& castOther.getStudyProtocolId() != null && this
						.getStudyProtocolId().equals(
								castOther.getStudyProtocolId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAnonymizationRequestId() == null ? 0 : this
						.getAnonymizationRequestId().hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37
				* result
				+ (getDateModified() == null ? 0 : this.getDateModified()
						.hashCode());
		result = 37
				* result
				+ (getModifiedBy() == null ? 0 : this.getModifiedBy()
						.hashCode());
		result = 37
				* result
				+ (getRequestCompletionStatus() == null ? 0 : this
						.getRequestCompletionStatus().hashCode());
		result = 37
				* result
				+ (getRequestMessage() == null ? 0 : this.getRequestMessage()
						.hashCode());
		result = 37
				* result
				+ (getRequestType() == null ? 0 : this.getRequestType()
						.hashCode());
		result = 37
				* result
				+ (getStudyNumber() == null ? 0 : this.getStudyNumber()
						.hashCode());
		result = 37
				* result
				+ (getStudyProtocolId() == null ? 0 : this.getStudyProtocolId()
						.hashCode());
		return result;
	}

}
