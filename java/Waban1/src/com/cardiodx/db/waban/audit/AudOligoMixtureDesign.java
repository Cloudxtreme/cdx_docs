package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudOligoMixtureDesign generated by hbm2java
 */
public class AudOligoMixtureDesign implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal mixtureId;
	private BigDecimal oligoMixtureId;
	private BigDecimal oligoId;
	private BigDecimal volume;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;

	public AudOligoMixtureDesign() {
	}

	public AudOligoMixtureDesign(BigDecimal auditId, BigDecimal mixtureId,
			BigDecimal oligoId, String createdBy, Date dateCreated) {
		this.auditId = auditId;
		this.mixtureId = mixtureId;
		this.oligoId = oligoId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public AudOligoMixtureDesign(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal mixtureId, BigDecimal oligoMixtureId,
			BigDecimal oligoId, BigDecimal volume, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			String changedBy, Date dateChanged, String changeType) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.mixtureId = mixtureId;
		this.oligoMixtureId = oligoMixtureId;
		this.oligoId = oligoId;
		this.volume = volume;
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

	public BigDecimal getMixtureId() {
		return this.mixtureId;
	}

	public void setMixtureId(BigDecimal mixtureId) {
		this.mixtureId = mixtureId;
	}

	public BigDecimal getOligoMixtureId() {
		return this.oligoMixtureId;
	}

	public void setOligoMixtureId(BigDecimal oligoMixtureId) {
		this.oligoMixtureId = oligoMixtureId;
	}

	public BigDecimal getOligoId() {
		return this.oligoId;
	}

	public void setOligoId(BigDecimal oligoId) {
		this.oligoId = oligoId;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
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