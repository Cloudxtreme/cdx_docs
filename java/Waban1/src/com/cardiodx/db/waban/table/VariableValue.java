package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * VariableValue generated by hbm2java
 */
public class VariableValue implements java.io.Serializable {

	private BigDecimal variableValueId;
	private Variable variable;
	private String value;
	private BigDecimal numberInSequence;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

	public VariableValue() {
	}

	public VariableValue(BigDecimal variableValueId, Variable variable,
			String value, BigDecimal numberInSequence) {
		this.variableValueId = variableValueId;
		this.variable = variable;
		this.value = value;
		this.numberInSequence = numberInSequence;
	}

	public VariableValue(BigDecimal variableValueId, Variable variable,
			String value, BigDecimal numberInSequence, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified) {
		this.variableValueId = variableValueId;
		this.variable = variable;
		this.value = value;
		this.numberInSequence = numberInSequence;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getVariableValueId() {
		return this.variableValueId;
	}

	public void setVariableValueId(BigDecimal variableValueId) {
		this.variableValueId = variableValueId;
	}

	public Variable getVariable() {
		return this.variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BigDecimal getNumberInSequence() {
		return this.numberInSequence;
	}

	public void setNumberInSequence(BigDecimal numberInSequence) {
		this.numberInSequence = numberInSequence;
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