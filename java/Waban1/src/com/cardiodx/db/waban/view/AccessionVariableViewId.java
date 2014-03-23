package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * AccessionVariableViewId generated by hbm2java
 */
public class AccessionVariableViewId implements java.io.Serializable {

	private BigDecimal accessionId;
	private BigDecimal studyProtocolId;
	private BigDecimal accessionVariableFldId;
	private BigDecimal protocolDefinedVariableId;
	private BigDecimal variableId;
	private String value;
	private String variableLabel;
	private BigDecimal numberInSequence;
	private String variableName;
	private String minValue;
	private String maxValue;
	private BigDecimal contactId;
	private BigDecimal organizationId;
	private BigDecimal patientId;
	private String displayId;

	public AccessionVariableViewId() {
	}

	public AccessionVariableViewId(BigDecimal accessionId,
			BigDecimal studyProtocolId, BigDecimal accessionVariableFldId,
			BigDecimal protocolDefinedVariableId, BigDecimal variableId,
			BigDecimal numberInSequence, String variableName) {
		this.accessionId = accessionId;
		this.studyProtocolId = studyProtocolId;
		this.accessionVariableFldId = accessionVariableFldId;
		this.protocolDefinedVariableId = protocolDefinedVariableId;
		this.variableId = variableId;
		this.numberInSequence = numberInSequence;
		this.variableName = variableName;
	}

	public AccessionVariableViewId(BigDecimal accessionId,
			BigDecimal studyProtocolId, BigDecimal accessionVariableFldId,
			BigDecimal protocolDefinedVariableId, BigDecimal variableId,
			String value, String variableLabel, BigDecimal numberInSequence,
			String variableName, String minValue, String maxValue,
			BigDecimal contactId, BigDecimal organizationId,
			BigDecimal patientId, String displayId) {
		this.accessionId = accessionId;
		this.studyProtocolId = studyProtocolId;
		this.accessionVariableFldId = accessionVariableFldId;
		this.protocolDefinedVariableId = protocolDefinedVariableId;
		this.variableId = variableId;
		this.value = value;
		this.variableLabel = variableLabel;
		this.numberInSequence = numberInSequence;
		this.variableName = variableName;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.contactId = contactId;
		this.organizationId = organizationId;
		this.patientId = patientId;
		this.displayId = displayId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public BigDecimal getAccessionVariableFldId() {
		return this.accessionVariableFldId;
	}

	public void setAccessionVariableFldId(BigDecimal accessionVariableFldId) {
		this.accessionVariableFldId = accessionVariableFldId;
	}

	public BigDecimal getProtocolDefinedVariableId() {
		return this.protocolDefinedVariableId;
	}

	public void setProtocolDefinedVariableId(
			BigDecimal protocolDefinedVariableId) {
		this.protocolDefinedVariableId = protocolDefinedVariableId;
	}

	public BigDecimal getVariableId() {
		return this.variableId;
	}

	public void setVariableId(BigDecimal variableId) {
		this.variableId = variableId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getVariableLabel() {
		return this.variableLabel;
	}

	public void setVariableLabel(String variableLabel) {
		this.variableLabel = variableLabel;
	}

	public BigDecimal getNumberInSequence() {
		return this.numberInSequence;
	}

	public void setNumberInSequence(BigDecimal numberInSequence) {
		this.numberInSequence = numberInSequence;
	}

	public String getVariableName() {
		return this.variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getMinValue() {
		return this.minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public BigDecimal getContactId() {
		return this.contactId;
	}

	public void setContactId(BigDecimal contactId) {
		this.contactId = contactId;
	}

	public BigDecimal getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(BigDecimal organizationId) {
		this.organizationId = organizationId;
	}

	public BigDecimal getPatientId() {
		return this.patientId;
	}

	public void setPatientId(BigDecimal patientId) {
		this.patientId = patientId;
	}

	public String getDisplayId() {
		return this.displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AccessionVariableViewId))
			return false;
		AccessionVariableViewId castOther = (AccessionVariableViewId) other;

		return ((this.getAccessionId() == castOther.getAccessionId()) || (this
				.getAccessionId() != null && castOther.getAccessionId() != null && this
				.getAccessionId().equals(castOther.getAccessionId())))
				&& ((this.getStudyProtocolId() == castOther
						.getStudyProtocolId()) || (this.getStudyProtocolId() != null
						&& castOther.getStudyProtocolId() != null && this
						.getStudyProtocolId().equals(
								castOther.getStudyProtocolId())))
				&& ((this.getAccessionVariableFldId() == castOther
						.getAccessionVariableFldId()) || (this
						.getAccessionVariableFldId() != null
						&& castOther.getAccessionVariableFldId() != null && this
						.getAccessionVariableFldId().equals(
								castOther.getAccessionVariableFldId())))
				&& ((this.getProtocolDefinedVariableId() == castOther
						.getProtocolDefinedVariableId()) || (this
						.getProtocolDefinedVariableId() != null
						&& castOther.getProtocolDefinedVariableId() != null && this
						.getProtocolDefinedVariableId().equals(
								castOther.getProtocolDefinedVariableId())))
				&& ((this.getVariableId() == castOther.getVariableId()) || (this
						.getVariableId() != null
						&& castOther.getVariableId() != null && this
						.getVariableId().equals(castOther.getVariableId())))
				&& ((this.getValue() == castOther.getValue()) || (this
						.getValue() != null && castOther.getValue() != null && this
						.getValue().equals(castOther.getValue())))
				&& ((this.getVariableLabel() == castOther.getVariableLabel()) || (this
						.getVariableLabel() != null
						&& castOther.getVariableLabel() != null && this
						.getVariableLabel()
						.equals(castOther.getVariableLabel())))
				&& ((this.getNumberInSequence() == castOther
						.getNumberInSequence()) || (this.getNumberInSequence() != null
						&& castOther.getNumberInSequence() != null && this
						.getNumberInSequence().equals(
								castOther.getNumberInSequence())))
				&& ((this.getVariableName() == castOther.getVariableName()) || (this
						.getVariableName() != null
						&& castOther.getVariableName() != null && this
						.getVariableName().equals(castOther.getVariableName())))
				&& ((this.getMinValue() == castOther.getMinValue()) || (this
						.getMinValue() != null
						&& castOther.getMinValue() != null && this
						.getMinValue().equals(castOther.getMinValue())))
				&& ((this.getMaxValue() == castOther.getMaxValue()) || (this
						.getMaxValue() != null
						&& castOther.getMaxValue() != null && this
						.getMaxValue().equals(castOther.getMaxValue())))
				&& ((this.getContactId() == castOther.getContactId()) || (this
						.getContactId() != null
						&& castOther.getContactId() != null && this
						.getContactId().equals(castOther.getContactId())))
				&& ((this.getOrganizationId() == castOther.getOrganizationId()) || (this
						.getOrganizationId() != null
						&& castOther.getOrganizationId() != null && this
						.getOrganizationId().equals(
								castOther.getOrganizationId())))
				&& ((this.getPatientId() == castOther.getPatientId()) || (this
						.getPatientId() != null
						&& castOther.getPatientId() != null && this
						.getPatientId().equals(castOther.getPatientId())))
				&& ((this.getDisplayId() == castOther.getDisplayId()) || (this
						.getDisplayId() != null
						&& castOther.getDisplayId() != null && this
						.getDisplayId().equals(castOther.getDisplayId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		result = 37
				* result
				+ (getStudyProtocolId() == null ? 0 : this.getStudyProtocolId()
						.hashCode());
		result = 37
				* result
				+ (getAccessionVariableFldId() == null ? 0 : this
						.getAccessionVariableFldId().hashCode());
		result = 37
				* result
				+ (getProtocolDefinedVariableId() == null ? 0 : this
						.getProtocolDefinedVariableId().hashCode());
		result = 37
				* result
				+ (getVariableId() == null ? 0 : this.getVariableId()
						.hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		result = 37
				* result
				+ (getVariableLabel() == null ? 0 : this.getVariableLabel()
						.hashCode());
		result = 37
				* result
				+ (getNumberInSequence() == null ? 0 : this
						.getNumberInSequence().hashCode());
		result = 37
				* result
				+ (getVariableName() == null ? 0 : this.getVariableName()
						.hashCode());
		result = 37 * result
				+ (getMinValue() == null ? 0 : this.getMinValue().hashCode());
		result = 37 * result
				+ (getMaxValue() == null ? 0 : this.getMaxValue().hashCode());
		result = 37 * result
				+ (getContactId() == null ? 0 : this.getContactId().hashCode());
		result = 37
				* result
				+ (getOrganizationId() == null ? 0 : this.getOrganizationId()
						.hashCode());
		result = 37 * result
				+ (getPatientId() == null ? 0 : this.getPatientId().hashCode());
		result = 37 * result
				+ (getDisplayId() == null ? 0 : this.getDisplayId().hashCode());
		return result;
	}

}
