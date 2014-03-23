package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * StepTemplateValue generated by hbm2java
 */
public class StepTemplateValue implements java.io.Serializable {

	private StepTemplateValueId id;
	private StepTemplate stepTemplate;
	private Subsidiary subsidiary;
	private String value;
	private String createdBy;
	private Date dateCreated;

	public StepTemplateValue() {
	}

	public StepTemplateValue(StepTemplateValueId id, StepTemplate stepTemplate,
			String value) {
		this.id = id;
		this.stepTemplate = stepTemplate;
		this.value = value;
	}

	public StepTemplateValue(StepTemplateValueId id, StepTemplate stepTemplate,
			Subsidiary subsidiary, String value, String createdBy,
			Date dateCreated) {
		this.id = id;
		this.stepTemplate = stepTemplate;
		this.subsidiary = subsidiary;
		this.value = value;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public StepTemplateValueId getId() {
		return this.id;
	}

	public void setId(StepTemplateValueId id) {
		this.id = id;
	}

	public StepTemplate getStepTemplate() {
		return this.stepTemplate;
	}

	public void setStepTemplate(StepTemplate stepTemplate) {
		this.stepTemplate = stepTemplate;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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
