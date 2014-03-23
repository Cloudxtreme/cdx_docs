package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudDnaDestructionVendor generated by hbm2java
 */
public class AudDnaDestructionVendor implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal destructionVendorId;
	private BigDecimal organizationId;
	private Boolean contacted;
	private Boolean responded;
	private BigDecimal sampleId;
	private String sampleStatus;
	private String reason;
	private BigDecimal outboundRequestId;
	private BigDecimal pendingSampleId;
	private BigDecimal checklistId;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudDnaDestructionVendor() {
	}

	public AudDnaDestructionVendor(BigDecimal auditId,
			BigDecimal destructionVendorId, BigDecimal organizationId,
			String createdBy) {
		this.auditId = auditId;
		this.destructionVendorId = destructionVendorId;
		this.organizationId = organizationId;
		this.createdBy = createdBy;
	}

	public AudDnaDestructionVendor(BigDecimal auditId,
			BigDecimal changeReasonId, BigDecimal destructionVendorId,
			BigDecimal organizationId, Boolean contacted, Boolean responded,
			BigDecimal sampleId, String sampleStatus, String reason,
			BigDecimal outboundRequestId, BigDecimal pendingSampleId,
			BigDecimal checklistId, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified, String changedBy,
			Date dateChanged, String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.destructionVendorId = destructionVendorId;
		this.organizationId = organizationId;
		this.contacted = contacted;
		this.responded = responded;
		this.sampleId = sampleId;
		this.sampleStatus = sampleStatus;
		this.reason = reason;
		this.outboundRequestId = outboundRequestId;
		this.pendingSampleId = pendingSampleId;
		this.checklistId = checklistId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
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

	public BigDecimal getDestructionVendorId() {
		return this.destructionVendorId;
	}

	public void setDestructionVendorId(BigDecimal destructionVendorId) {
		this.destructionVendorId = destructionVendorId;
	}

	public BigDecimal getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(BigDecimal organizationId) {
		this.organizationId = organizationId;
	}

	public Boolean getContacted() {
		return this.contacted;
	}

	public void setContacted(Boolean contacted) {
		this.contacted = contacted;
	}

	public Boolean getResponded() {
		return this.responded;
	}

	public void setResponded(Boolean responded) {
		this.responded = responded;
	}

	public BigDecimal getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(BigDecimal sampleId) {
		this.sampleId = sampleId;
	}

	public String getSampleStatus() {
		return this.sampleStatus;
	}

	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BigDecimal getOutboundRequestId() {
		return this.outboundRequestId;
	}

	public void setOutboundRequestId(BigDecimal outboundRequestId) {
		this.outboundRequestId = outboundRequestId;
	}

	public BigDecimal getPendingSampleId() {
		return this.pendingSampleId;
	}

	public void setPendingSampleId(BigDecimal pendingSampleId) {
		this.pendingSampleId = pendingSampleId;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
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

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

}