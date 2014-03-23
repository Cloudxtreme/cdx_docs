package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudPcrCleanupContainer generated by hbm2java
 */
public class AudPcrCleanupContainer implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal pcrContainerId;
	private BigDecimal pcrCleanupId;
	private String pcrclContainerId;
	private String filterContainerId;
	private String elutionContainerId;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudPcrCleanupContainer() {
	}

	public AudPcrCleanupContainer(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudPcrCleanupContainer(BigDecimal auditId,
			BigDecimal changeReasonId, BigDecimal pcrContainerId,
			BigDecimal pcrCleanupId, String pcrclContainerId,
			String filterContainerId, String elutionContainerId,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, String changedBy, Date dateChanged,
			String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.pcrContainerId = pcrContainerId;
		this.pcrCleanupId = pcrCleanupId;
		this.pcrclContainerId = pcrclContainerId;
		this.filterContainerId = filterContainerId;
		this.elutionContainerId = elutionContainerId;
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

	public BigDecimal getPcrContainerId() {
		return this.pcrContainerId;
	}

	public void setPcrContainerId(BigDecimal pcrContainerId) {
		this.pcrContainerId = pcrContainerId;
	}

	public BigDecimal getPcrCleanupId() {
		return this.pcrCleanupId;
	}

	public void setPcrCleanupId(BigDecimal pcrCleanupId) {
		this.pcrCleanupId = pcrCleanupId;
	}

	public String getPcrclContainerId() {
		return this.pcrclContainerId;
	}

	public void setPcrclContainerId(String pcrclContainerId) {
		this.pcrclContainerId = pcrclContainerId;
	}

	public String getFilterContainerId() {
		return this.filterContainerId;
	}

	public void setFilterContainerId(String filterContainerId) {
		this.filterContainerId = filterContainerId;
	}

	public String getElutionContainerId() {
		return this.elutionContainerId;
	}

	public void setElutionContainerId(String elutionContainerId) {
		this.elutionContainerId = elutionContainerId;
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
