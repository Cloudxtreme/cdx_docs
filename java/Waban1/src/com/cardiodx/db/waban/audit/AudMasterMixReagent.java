package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudMasterMixReagent generated by hbm2java
 */
public class AudMasterMixReagent implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal masterMixReagentId;
	private BigDecimal changeReasonId;
	private BigDecimal masterMixItemId;
	private BigDecimal checklistId;
	private BigDecimal stepTemplateId;
	private BigDecimal reagentId;
	private BigDecimal newReagentId;
	private BigDecimal volume;
	private BigDecimal concentration;
	private String createdBy;
	private Date dateCreated;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal multiplier;

	public AudMasterMixReagent() {
	}

	public AudMasterMixReagent(BigDecimal auditId, BigDecimal masterMixItemId,
			BigDecimal checklistId, BigDecimal stepTemplateId) {
		this.auditId = auditId;
		this.masterMixItemId = masterMixItemId;
		this.checklistId = checklistId;
		this.stepTemplateId = stepTemplateId;
	}

	public AudMasterMixReagent(BigDecimal auditId,
			BigDecimal masterMixReagentId, BigDecimal changeReasonId,
			BigDecimal masterMixItemId, BigDecimal checklistId,
			BigDecimal stepTemplateId, BigDecimal reagentId,
			BigDecimal newReagentId, BigDecimal volume,
			BigDecimal concentration, String createdBy, Date dateCreated,
			String changedBy, Date dateChanged, String changeType,
			BigDecimal multiplier) {
		this.auditId = auditId;
		this.masterMixReagentId = masterMixReagentId;
		this.changeReasonId = changeReasonId;
		this.masterMixItemId = masterMixItemId;
		this.checklistId = checklistId;
		this.stepTemplateId = stepTemplateId;
		this.reagentId = reagentId;
		this.newReagentId = newReagentId;
		this.volume = volume;
		this.concentration = concentration;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
		this.multiplier = multiplier;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public BigDecimal getMasterMixReagentId() {
		return this.masterMixReagentId;
	}

	public void setMasterMixReagentId(BigDecimal masterMixReagentId) {
		this.masterMixReagentId = masterMixReagentId;
	}

	public BigDecimal getChangeReasonId() {
		return this.changeReasonId;
	}

	public void setChangeReasonId(BigDecimal changeReasonId) {
		this.changeReasonId = changeReasonId;
	}

	public BigDecimal getMasterMixItemId() {
		return this.masterMixItemId;
	}

	public void setMasterMixItemId(BigDecimal masterMixItemId) {
		this.masterMixItemId = masterMixItemId;
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

	public BigDecimal getReagentId() {
		return this.reagentId;
	}

	public void setReagentId(BigDecimal reagentId) {
		this.reagentId = reagentId;
	}

	public BigDecimal getNewReagentId() {
		return this.newReagentId;
	}

	public void setNewReagentId(BigDecimal newReagentId) {
		this.newReagentId = newReagentId;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getConcentration() {
		return this.concentration;
	}

	public void setConcentration(BigDecimal concentration) {
		this.concentration = concentration;
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

	public BigDecimal getMultiplier() {
		return this.multiplier;
	}

	public void setMultiplier(BigDecimal multiplier) {
		this.multiplier = multiplier;
	}

}
