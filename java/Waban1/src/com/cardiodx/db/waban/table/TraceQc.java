package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * TraceQc generated by hbm2java
 */
public class TraceQc implements java.io.Serializable {

	private BigDecimal traceQcId;
	private StepTemplate stepTemplate;
	private Checklist checklist;
	private Container container;
	private Subsidiary subsidiary;
	private Instrument instrument;
	private String status;
	private String requeTo;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

	public TraceQc() {
	}

	public TraceQc(BigDecimal traceQcId) {
		this.traceQcId = traceQcId;
	}

	public TraceQc(BigDecimal traceQcId, StepTemplate stepTemplate,
			Checklist checklist, Container container, Subsidiary subsidiary,
			Instrument instrument, String status, String requeTo,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified) {
		this.traceQcId = traceQcId;
		this.stepTemplate = stepTemplate;
		this.checklist = checklist;
		this.container = container;
		this.subsidiary = subsidiary;
		this.instrument = instrument;
		this.status = status;
		this.requeTo = requeTo;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getTraceQcId() {
		return this.traceQcId;
	}

	public void setTraceQcId(BigDecimal traceQcId) {
		this.traceQcId = traceQcId;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequeTo() {
		return this.requeTo;
	}

	public void setRequeTo(String requeTo) {
		this.requeTo = requeTo;
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

}
