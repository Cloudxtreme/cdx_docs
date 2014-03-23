package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * MasterMixReagent generated by hbm2java
 */
public class MasterMixReagent implements java.io.Serializable {

	private BigDecimal masterMixReagentId;
	private Reagent reagentByReagentId;
	private Reagent reagentByNewReagentId;
	private StepTemplate stepTemplate;
	private Checklist checklist;
	private MasterMixItem masterMixItem;
	private BigDecimal volume;
	private BigDecimal concentration;
	private String createdBy;
	private Date dateCreated;
	private BigDecimal multiplier;

	public MasterMixReagent() {
	}

	public MasterMixReagent(BigDecimal masterMixReagentId,
			StepTemplate stepTemplate, Checklist checklist) {
		this.masterMixReagentId = masterMixReagentId;
		this.stepTemplate = stepTemplate;
		this.checklist = checklist;
	}

	public MasterMixReagent(BigDecimal masterMixReagentId,
			Reagent reagentByReagentId, Reagent reagentByNewReagentId,
			StepTemplate stepTemplate, Checklist checklist,
			MasterMixItem masterMixItem, BigDecimal volume,
			BigDecimal concentration, String createdBy, Date dateCreated,
			BigDecimal multiplier) {
		this.masterMixReagentId = masterMixReagentId;
		this.reagentByReagentId = reagentByReagentId;
		this.reagentByNewReagentId = reagentByNewReagentId;
		this.stepTemplate = stepTemplate;
		this.checklist = checklist;
		this.masterMixItem = masterMixItem;
		this.volume = volume;
		this.concentration = concentration;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.multiplier = multiplier;
	}

	public BigDecimal getMasterMixReagentId() {
		return this.masterMixReagentId;
	}

	public void setMasterMixReagentId(BigDecimal masterMixReagentId) {
		this.masterMixReagentId = masterMixReagentId;
	}

	public Reagent getReagentByReagentId() {
		return this.reagentByReagentId;
	}

	public void setReagentByReagentId(Reagent reagentByReagentId) {
		this.reagentByReagentId = reagentByReagentId;
	}

	public Reagent getReagentByNewReagentId() {
		return this.reagentByNewReagentId;
	}

	public void setReagentByNewReagentId(Reagent reagentByNewReagentId) {
		this.reagentByNewReagentId = reagentByNewReagentId;
	}

	public StepTemplate getStepTemplate() {
		return this.stepTemplate;
	}

	public void setStepTemplate(StepTemplate stepTemplate) {
		this.stepTemplate = stepTemplate;
	}

	public Checklist getChecklist() {
		return this.checklist;
	}

	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
	}

	public MasterMixItem getMasterMixItem() {
		return this.masterMixItem;
	}

	public void setMasterMixItem(MasterMixItem masterMixItem) {
		this.masterMixItem = masterMixItem;
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

	public BigDecimal getMultiplier() {
		return this.multiplier;
	}

	public void setMultiplier(BigDecimal multiplier) {
		this.multiplier = multiplier;
	}

}