package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudCdxFaxAttempt generated by hbm2java
 */
public class AudCdxFaxAttempt implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal cdxFaxAttemptId;
	private BigDecimal accessionId;
	private String faxNumber;
	private String faxNumberType;
	private String faxStatus;
	private String faxComment;
	private BigDecimal hylafaxId;
	private BigDecimal versionedDocumentId;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;

	public AudCdxFaxAttempt() {
	}

	public AudCdxFaxAttempt(BigDecimal auditId, BigDecimal cdxFaxAttemptId,
			BigDecimal accessionId, String faxStatus) {
		this.auditId = auditId;
		this.cdxFaxAttemptId = cdxFaxAttemptId;
		this.accessionId = accessionId;
		this.faxStatus = faxStatus;
	}

	public AudCdxFaxAttempt(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal cdxFaxAttemptId, BigDecimal accessionId,
			String faxNumber, String faxNumberType, String faxStatus,
			String faxComment, BigDecimal hylafaxId,
			BigDecimal versionedDocumentId, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified, String changedBy,
			Date dateChanged, String changeType) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.cdxFaxAttemptId = cdxFaxAttemptId;
		this.accessionId = accessionId;
		this.faxNumber = faxNumber;
		this.faxNumberType = faxNumberType;
		this.faxStatus = faxStatus;
		this.faxComment = faxComment;
		this.hylafaxId = hylafaxId;
		this.versionedDocumentId = versionedDocumentId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public BigDecimal getChangeReasonId() {
		return this.changeReasonId;
	}

	public void setChangeReasonId(BigDecimal changeReasonId) {
		this.changeReasonId = changeReasonId;
	}

	public BigDecimal getCdxFaxAttemptId() {
		return this.cdxFaxAttemptId;
	}

	public void setCdxFaxAttemptId(BigDecimal cdxFaxAttemptId) {
		this.cdxFaxAttemptId = cdxFaxAttemptId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getFaxNumberType() {
		return this.faxNumberType;
	}

	public void setFaxNumberType(String faxNumberType) {
		this.faxNumberType = faxNumberType;
	}

	public String getFaxStatus() {
		return this.faxStatus;
	}

	public void setFaxStatus(String faxStatus) {
		this.faxStatus = faxStatus;
	}

	public String getFaxComment() {
		return this.faxComment;
	}

	public void setFaxComment(String faxComment) {
		this.faxComment = faxComment;
	}

	public BigDecimal getHylafaxId() {
		return this.hylafaxId;
	}

	public void setHylafaxId(BigDecimal hylafaxId) {
		this.hylafaxId = hylafaxId;
	}

	public BigDecimal getVersionedDocumentId() {
		return this.versionedDocumentId;
	}

	public void setVersionedDocumentId(BigDecimal versionedDocumentId) {
		this.versionedDocumentId = versionedDocumentId;
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

	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public String getChangeType() {
		return this.changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

}