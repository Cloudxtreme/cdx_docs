package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudCpRun generated by hbm2java
 */
public class AudCpRun implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal cpRunId;
	private String containerId;
	private BigDecimal sampleId;
	private String status;
	private Date dateImported;
	private String importedBy;
	private BigDecimal instrumentId;
	private BigDecimal checklistId;
	private BigDecimal stepTemplateId;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudCpRun() {
	}

	public AudCpRun(BigDecimal auditId, String containerId,
			BigDecimal sampleId, Date dateImported, String importedBy,
			BigDecimal instrumentId, BigDecimal checklistId,
			BigDecimal stepTemplateId) {
		this.auditId = auditId;
		this.containerId = containerId;
		this.sampleId = sampleId;
		this.dateImported = dateImported;
		this.importedBy = importedBy;
		this.instrumentId = instrumentId;
		this.checklistId = checklistId;
		this.stepTemplateId = stepTemplateId;
	}

	public AudCpRun(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal cpRunId, String containerId, BigDecimal sampleId,
			String status, Date dateImported, String importedBy,
			BigDecimal instrumentId, BigDecimal checklistId,
			BigDecimal stepTemplateId, String changedBy, Date dateChanged,
			String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.cpRunId = cpRunId;
		this.containerId = containerId;
		this.sampleId = sampleId;
		this.status = status;
		this.dateImported = dateImported;
		this.importedBy = importedBy;
		this.instrumentId = instrumentId;
		this.checklistId = checklistId;
		this.stepTemplateId = stepTemplateId;
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

	public BigDecimal getCpRunId() {
		return this.cpRunId;
	}

	public void setCpRunId(BigDecimal cpRunId) {
		this.cpRunId = cpRunId;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public BigDecimal getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(BigDecimal sampleId) {
		this.sampleId = sampleId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateImported() {
		return this.dateImported;
	}

	public void setDateImported(Date dateImported) {
		this.dateImported = dateImported;
	}

	public String getImportedBy() {
		return this.importedBy;
	}

	public void setImportedBy(String importedBy) {
		this.importedBy = importedBy;
	}

	public BigDecimal getInstrumentId() {
		return this.instrumentId;
	}

	public void setInstrumentId(BigDecimal instrumentId) {
		this.instrumentId = instrumentId;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public BigDecimal getStepTemplateId() {
		return this.stepTemplateId;
	}

	public void setStepTemplateId(BigDecimal stepTemplateId) {
		this.stepTemplateId = stepTemplateId;
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