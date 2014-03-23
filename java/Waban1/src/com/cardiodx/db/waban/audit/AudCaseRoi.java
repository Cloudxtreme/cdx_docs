package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudCaseRoi generated by hbm2java
 */
public class AudCaseRoi implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal caseRoiId;
	private String caseId;
	private BigDecimal testAccessionId;
	private BigDecimal roiId;
	private BigDecimal roiSelectionId;
	private String status;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changeType;
	private BigDecimal subsidiaryId;
	private String changedBy;
	private Date dateChanged;

	public AudCaseRoi() {
	}

	public AudCaseRoi(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudCaseRoi(BigDecimal auditId, BigDecimal caseRoiId, String caseId,
			BigDecimal testAccessionId, BigDecimal roiId,
			BigDecimal roiSelectionId, String status, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			String changeType, BigDecimal subsidiaryId, String changedBy,
			Date dateChanged) {
		this.auditId = auditId;
		this.caseRoiId = caseRoiId;
		this.caseId = caseId;
		this.testAccessionId = testAccessionId;
		this.roiId = roiId;
		this.roiSelectionId = roiSelectionId;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.changeType = changeType;
		this.subsidiaryId = subsidiaryId;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public BigDecimal getCaseRoiId() {
		return this.caseRoiId;
	}

	public void setCaseRoiId(BigDecimal caseRoiId) {
		this.caseRoiId = caseRoiId;
	}

	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public BigDecimal getTestAccessionId() {
		return this.testAccessionId;
	}

	public void setTestAccessionId(BigDecimal testAccessionId) {
		this.testAccessionId = testAccessionId;
	}

	public BigDecimal getRoiId() {
		return this.roiId;
	}

	public void setRoiId(BigDecimal roiId) {
		this.roiId = roiId;
	}

	public BigDecimal getRoiSelectionId() {
		return this.roiSelectionId;
	}

	public void setRoiSelectionId(BigDecimal roiSelectionId) {
		this.roiSelectionId = roiSelectionId;
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

}