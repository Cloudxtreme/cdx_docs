package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ChecklistReagent generated by hbm2java
 */
public class ChecklistReagent implements java.io.Serializable {

	private BigDecimal checklistReagentId;
	private Reagent reagent;
	private StepTemplate stepTemplate;
	private Checklist checklist;
	private Subsidiary subsidiary;
	private SampleTable sampleTable;
	private BigDecimal checklistCol;
	private BigDecimal volume;
	private BigDecimal batchReagentId;
	private String createdBy;
	private Date dateCreated;

	public ChecklistReagent() {
	}

	public ChecklistReagent(BigDecimal checklistReagentId, Reagent reagent,
			Checklist checklist) {
		this.checklistReagentId = checklistReagentId;
		this.reagent = reagent;
		this.checklist = checklist;
	}

	public ChecklistReagent(BigDecimal checklistReagentId, Reagent reagent,
			StepTemplate stepTemplate, Checklist checklist,
			Subsidiary subsidiary, SampleTable sampleTable,
			BigDecimal checklistCol, BigDecimal volume,
			BigDecimal batchReagentId, String createdBy, Date dateCreated) {
		this.checklistReagentId = checklistReagentId;
		this.reagent = reagent;
		this.stepTemplate = stepTemplate;
		this.checklist = checklist;
		this.subsidiary = subsidiary;
		this.sampleTable = sampleTable;
		this.checklistCol = checklistCol;
		this.volume = volume;
		this.batchReagentId = batchReagentId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public BigDecimal getChecklistReagentId() {
		return this.checklistReagentId;
	}

	public void setChecklistReagentId(BigDecimal checklistReagentId) {
		this.checklistReagentId = checklistReagentId;
	}

	public Reagent getReagent() {
		return this.reagent;
	}

	public void setReagent(Reagent reagent) {
		this.reagent = reagent;
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

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public SampleTable getSampleTable() {
		return this.sampleTable;
	}

	public void setSampleTable(SampleTable sampleTable) {
		this.sampleTable = sampleTable;
	}

	public BigDecimal getChecklistCol() {
		return this.checklistCol;
	}

	public void setChecklistCol(BigDecimal checklistCol) {
		this.checklistCol = checklistCol;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getBatchReagentId() {
		return this.batchReagentId;
	}

	public void setBatchReagentId(BigDecimal batchReagentId) {
		this.batchReagentId = batchReagentId;
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

}