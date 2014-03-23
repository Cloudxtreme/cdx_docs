package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudDnaDestructionRequest generated by hbm2java
 */
public class AudDnaDestructionRequest implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal destructionRequestId;
	private BigDecimal checklistId;
	private BigDecimal contactId;
	private String status;
	private String assignStudyTechnician;
	private String requestMode;
	private String createdBy;
	private Date dateCreated;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;

	public AudDnaDestructionRequest() {
	}

	public AudDnaDestructionRequest(BigDecimal auditId,
			BigDecimal destructionRequestId, BigDecimal checklistId) {
		this.auditId = auditId;
		this.destructionRequestId = destructionRequestId;
		this.checklistId = checklistId;
	}

	public AudDnaDestructionRequest(BigDecimal auditId,
			BigDecimal changeReasonId, BigDecimal destructionRequestId,
			BigDecimal checklistId, BigDecimal contactId, String status,
			String assignStudyTechnician, String requestMode, String createdBy,
			Date dateCreated, String changedBy, Date dateChanged,
			String changeType, String modifiedBy, Date dateModified,
			BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.destructionRequestId = destructionRequestId;
		this.checklistId = checklistId;
		this.contactId = contactId;
		this.status = status;
		this.assignStudyTechnician = assignStudyTechnician;
		this.requestMode = requestMode;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
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

	public BigDecimal getDestructionRequestId() {
		return this.destructionRequestId;
	}

	public void setDestructionRequestId(BigDecimal destructionRequestId) {
		this.destructionRequestId = destructionRequestId;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public BigDecimal getContactId() {
		return this.contactId;
	}

	public void setContactId(BigDecimal contactId) {
		this.contactId = contactId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignStudyTechnician() {
		return this.assignStudyTechnician;
	}

	public void setAssignStudyTechnician(String assignStudyTechnician) {
		this.assignStudyTechnician = assignStudyTechnician;
	}

	public String getRequestMode() {
		return this.requestMode;
	}

	public void setRequestMode(String requestMode) {
		this.requestMode = requestMode;
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

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

}
