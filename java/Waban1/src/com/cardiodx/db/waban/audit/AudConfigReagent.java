package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudConfigReagent generated by hbm2java
 */
public class AudConfigReagent implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal configReagentId;
	private String reagentPfx;
	private String reagentName;
	private BigDecimal targetAmt;
	private String purpose;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal changeReasonId;

	public AudConfigReagent() {
	}

	public AudConfigReagent(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudConfigReagent(BigDecimal auditId, BigDecimal configReagentId,
			String reagentPfx, String reagentName, BigDecimal targetAmt,
			String purpose, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified, String changedBy,
			Date dateChanged, String changeType, BigDecimal changeReasonId) {
		this.auditId = auditId;
		this.configReagentId = configReagentId;
		this.reagentPfx = reagentPfx;
		this.reagentName = reagentName;
		this.targetAmt = targetAmt;
		this.purpose = purpose;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
		this.changeReasonId = changeReasonId;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public BigDecimal getConfigReagentId() {
		return this.configReagentId;
	}

	public void setConfigReagentId(BigDecimal configReagentId) {
		this.configReagentId = configReagentId;
	}

	public String getReagentPfx() {
		return this.reagentPfx;
	}

	public void setReagentPfx(String reagentPfx) {
		this.reagentPfx = reagentPfx;
	}

	public String getReagentName() {
		return this.reagentName;
	}

	public void setReagentName(String reagentName) {
		this.reagentName = reagentName;
	}

	public BigDecimal getTargetAmt() {
		return this.targetAmt;
	}

	public void setTargetAmt(BigDecimal targetAmt) {
		this.targetAmt = targetAmt;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
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

	public BigDecimal getChangeReasonId() {
		return this.changeReasonId;
	}

	public void setChangeReasonId(BigDecimal changeReasonId) {
		this.changeReasonId = changeReasonId;
	}

}
