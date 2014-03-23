package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudOligoAssayDesign generated by hbm2java
 */
public class AudOligoAssayDesign implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal oligoAssayId;
	private BigDecimal oligoId;
	private String assayName;
	private String assayOwner;
	private String assayCondition;
	private String assayType;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;

	public AudOligoAssayDesign() {
	}

	public AudOligoAssayDesign(BigDecimal auditId, BigDecimal oligoId,
			String createdBy, Date dateCreated) {
		this.auditId = auditId;
		this.oligoId = oligoId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public AudOligoAssayDesign(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal oligoAssayId, BigDecimal oligoId, String assayName,
			String assayOwner, String assayCondition, String assayType,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, String changedBy, Date dateChanged,
			String changeType) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.oligoAssayId = oligoAssayId;
		this.oligoId = oligoId;
		this.assayName = assayName;
		this.assayOwner = assayOwner;
		this.assayCondition = assayCondition;
		this.assayType = assayType;
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

	public BigDecimal getOligoAssayId() {
		return this.oligoAssayId;
	}

	public void setOligoAssayId(BigDecimal oligoAssayId) {
		this.oligoAssayId = oligoAssayId;
	}

	public BigDecimal getOligoId() {
		return this.oligoId;
	}

	public void setOligoId(BigDecimal oligoId) {
		this.oligoId = oligoId;
	}

	public String getAssayName() {
		return this.assayName;
	}

	public void setAssayName(String assayName) {
		this.assayName = assayName;
	}

	public String getAssayOwner() {
		return this.assayOwner;
	}

	public void setAssayOwner(String assayOwner) {
		this.assayOwner = assayOwner;
	}

	public String getAssayCondition() {
		return this.assayCondition;
	}

	public void setAssayCondition(String assayCondition) {
		this.assayCondition = assayCondition;
	}

	public String getAssayType() {
		return this.assayType;
	}

	public void setAssayType(String assayType) {
		this.assayType = assayType;
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