package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudGenotypingVendProjDtls generated by hbm2java
 */
public class AudGenotypingVendProjDtls implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal genDetId;
	private BigDecimal projectId;
	private BigDecimal studyProtocolId;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudGenotypingVendProjDtls() {
	}

	public AudGenotypingVendProjDtls(BigDecimal auditId, BigDecimal genDetId,
			BigDecimal projectId, BigDecimal studyProtocolId) {
		this.auditId = auditId;
		this.genDetId = genDetId;
		this.projectId = projectId;
		this.studyProtocolId = studyProtocolId;
	}

	public AudGenotypingVendProjDtls(BigDecimal auditId,
			BigDecimal changeReasonId, BigDecimal genDetId,
			BigDecimal projectId, BigDecimal studyProtocolId, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			String changedBy, Date dateChanged, String changeType,
			BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.genDetId = genDetId;
		this.projectId = projectId;
		this.studyProtocolId = studyProtocolId;
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

	public BigDecimal getGenDetId() {
		return this.genDetId;
	}

	public void setGenDetId(BigDecimal genDetId) {
		this.genDetId = genDetId;
	}

	public BigDecimal getProjectId() {
		return this.projectId;
	}

	public void setProjectId(BigDecimal projectId) {
		this.projectId = projectId;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
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
