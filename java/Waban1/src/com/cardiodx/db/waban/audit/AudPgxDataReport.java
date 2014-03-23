package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudPgxDataReport generated by hbm2java
 */
public class AudPgxDataReport implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal pgxDataId;
	private BigDecimal studyProtocolId;
	private BigDecimal checklistId;
	private String reportName;
	private String reportUrl;
	private String reportDescription;
	private BigDecimal modified;
	private String reportType;
	private String reportStatus;
	private BigDecimal setupTemplateId;
	private String status;
	private String createdBy;
	private Date dateCreated;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudPgxDataReport() {
	}

	public AudPgxDataReport(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudPgxDataReport(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal pgxDataId, BigDecimal studyProtocolId,
			BigDecimal checklistId, String reportName, String reportUrl,
			String reportDescription, BigDecimal modified, String reportType,
			String reportStatus, BigDecimal setupTemplateId, String status,
			String createdBy, Date dateCreated, String changedBy,
			Date dateChanged, String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.pgxDataId = pgxDataId;
		this.studyProtocolId = studyProtocolId;
		this.checklistId = checklistId;
		this.reportName = reportName;
		this.reportUrl = reportUrl;
		this.reportDescription = reportDescription;
		this.modified = modified;
		this.reportType = reportType;
		this.reportStatus = reportStatus;
		this.setupTemplateId = setupTemplateId;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
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

	public BigDecimal getPgxDataId() {
		return this.pgxDataId;
	}

	public void setPgxDataId(BigDecimal pgxDataId) {
		this.pgxDataId = pgxDataId;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportUrl() {
		return this.reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	public String getReportDescription() {
		return this.reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public BigDecimal getModified() {
		return this.modified;
	}

	public void setModified(BigDecimal modified) {
		this.modified = modified;
	}

	public String getReportType() {
		return this.reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportStatus() {
		return this.reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public BigDecimal getSetupTemplateId() {
		return this.setupTemplateId;
	}

	public void setSetupTemplateId(BigDecimal setupTemplateId) {
		this.setupTemplateId = setupTemplateId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

}
