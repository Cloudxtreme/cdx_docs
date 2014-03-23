package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudMasterMix generated by hbm2java
 */
public class AudMasterMix implements java.io.Serializable {

	private BigDecimal auditId;
	private String version;
	private BigDecimal changeReasonId;
	private BigDecimal masterMixId;
	private String mixName;
	private String status;
	private BigDecimal volume;
	private String comments;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private String calculateBy;

	public AudMasterMix() {
	}

	public AudMasterMix(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudMasterMix(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal masterMixId, String mixName, String status,
			BigDecimal volume, String comments, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			String changedBy, Date dateChanged, String changeType,
			String calculateBy) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.masterMixId = masterMixId;
		this.mixName = mixName;
		this.status = status;
		this.volume = volume;
		this.comments = comments;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
		this.calculateBy = calculateBy;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BigDecimal getChangeReasonId() {
		return this.changeReasonId;
	}

	public void setChangeReasonId(BigDecimal changeReasonId) {
		this.changeReasonId = changeReasonId;
	}

	public BigDecimal getMasterMixId() {
		return this.masterMixId;
	}

	public void setMasterMixId(BigDecimal masterMixId) {
		this.masterMixId = masterMixId;
	}

	public String getMixName() {
		return this.mixName;
	}

	public void setMixName(String mixName) {
		this.mixName = mixName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getCalculateBy() {
		return this.calculateBy;
	}

	public void setCalculateBy(String calculateBy) {
		this.calculateBy = calculateBy;
	}

}