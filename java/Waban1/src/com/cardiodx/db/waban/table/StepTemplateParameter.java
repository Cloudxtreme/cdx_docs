package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

/**
 * StepTemplateParameter generated by hbm2java
 */
public class StepTemplateParameter implements java.io.Serializable {

	private StepTemplateParameterId id;
	private FunctionalStepParameter functionalStepParameter;
	private StepTemplate stepTemplate;
	private Subsidiary subsidiary;
	private String value;

	public StepTemplateParameter() {
	}

	public StepTemplateParameter(StepTemplateParameterId id,
			FunctionalStepParameter functionalStepParameter,
			StepTemplate stepTemplate) {
		this.id = id;
		this.functionalStepParameter = functionalStepParameter;
		this.stepTemplate = stepTemplate;
	}

	public StepTemplateParameter(StepTemplateParameterId id,
			FunctionalStepParameter functionalStepParameter,
			StepTemplate stepTemplate, Subsidiary subsidiary, String value) {
		this.id = id;
		this.functionalStepParameter = functionalStepParameter;
		this.stepTemplate = stepTemplate;
		this.subsidiary = subsidiary;
		this.value = value;
	}

	public StepTemplateParameterId getId() {
		return this.id;
	}

	public void setId(StepTemplateParameterId id) {
		this.id = id;
	}

	public FunctionalStepParameter getFunctionalStepParameter() {
		return this.functionalStepParameter;
	}

	public void setFunctionalStepParameter(
			FunctionalStepParameter functionalStepParameter) {
		this.functionalStepParameter = functionalStepParameter;
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

}