package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AssignInstrument generated by hbm2java
 */
public class AssignInstrument implements java.io.Serializable {

	private BigDecimal assignInstrumentId;
	private StepTemplate stepTemplate;
	private Checklist checklist;
	private Container container;
	private Subsidiary subsidiary;
	private Instrument instrument;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal checklistRow;
	private Set<AssignInstrumentValue> assignInstrumentValues = new HashSet<AssignInstrumentValue>(
			0);

	public AssignInstrument() {
	}

	public AssignInstrument(BigDecimal assignInstrumentId,
			StepTemplate stepTemplate, Checklist checklist,
			Container container, Instrument instrument, String createdBy,
			Date dateCreated) {
		this.assignInstrumentId = assignInstrumentId;
		this.stepTemplate = stepTemplate;
		this.checklist = checklist;
		this.container = container;
		this.instrument = instrument;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public AssignInstrument(BigDecimal assignInstrumentId,
			StepTemplate stepTemplate, Checklist checklist,
			Container container, Subsidiary subsidiary, Instrument instrument,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, BigDecimal checklistRow,
			Set<AssignInstrumentValue> assignInstrumentValues) {
		this.assignInstrumentId = assignInstrumentId;
		this.stepTemplate = stepTemplate;
		this.checklist = checklist;
		this.container = container;
		this.subsidiary = subsidiary;
		this.instrument = instrument;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.checklistRow = checklistRow;
		this.assignInstrumentValues = assignInstrumentValues;
	}

	public BigDecimal getAssignInstrumentId() {
		return this.assignInstrumentId;
	}

	public void setAssignInstrumentId(BigDecimal assignInstrumentId) {
		this.assignInstrumentId = assignInstrumentId;
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

	public Container getContainer() {
		return this.container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
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

	public BigDecimal getChecklistRow() {
		return this.checklistRow;
	}

	public void setChecklistRow(BigDecimal checklistRow) {
		this.checklistRow = checklistRow;
	}

	public Set<AssignInstrumentValue> getAssignInstrumentValues() {
		return this.assignInstrumentValues;
	}

	public void setAssignInstrumentValues(
			Set<AssignInstrumentValue> assignInstrumentValues) {
		this.assignInstrumentValues = assignInstrumentValues;
	}

}
