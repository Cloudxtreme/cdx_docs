package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * WorkflowStep generated by hbm2java
 */
public class WorkflowStep implements java.io.Serializable {

	private BigDecimal workflowStepId;
	private String stepType;
	private String description;
	private String createdBy;
	private Date dateCreated;
	private Set<StepTemplateWorkflow> stepTemplateWorkflows = new HashSet<StepTemplateWorkflow>(
			0);

	public WorkflowStep() {
	}

	public WorkflowStep(BigDecimal workflowStepId) {
		this.workflowStepId = workflowStepId;
	}

	public WorkflowStep(BigDecimal workflowStepId, String stepType,
			String description, String createdBy, Date dateCreated,
			Set<StepTemplateWorkflow> stepTemplateWorkflows) {
		this.workflowStepId = workflowStepId;
		this.stepType = stepType;
		this.description = description;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.stepTemplateWorkflows = stepTemplateWorkflows;
	}

	public BigDecimal getWorkflowStepId() {
		return this.workflowStepId;
	}

	public void setWorkflowStepId(BigDecimal workflowStepId) {
		this.workflowStepId = workflowStepId;
	}

	public String getStepType() {
		return this.stepType;
	}

	public void setStepType(String stepType) {
		this.stepType = stepType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Set<StepTemplateWorkflow> getStepTemplateWorkflows() {
		return this.stepTemplateWorkflows;
	}

	public void setStepTemplateWorkflows(
			Set<StepTemplateWorkflow> stepTemplateWorkflows) {
		this.stepTemplateWorkflows = stepTemplateWorkflows;
	}

}
