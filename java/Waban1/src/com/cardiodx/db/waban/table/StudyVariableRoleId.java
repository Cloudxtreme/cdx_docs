package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * StudyVariableRoleId generated by hbm2java
 */
public class StudyVariableRoleId implements java.io.Serializable {

	private BigDecimal anonymizationStudySetupId;
	private BigDecimal variableId;
	private String variableRole;
	private BigDecimal protocolDefinedVariableId;
	private BigDecimal subsidiaryId;

	public StudyVariableRoleId() {
	}

	public StudyVariableRoleId(BigDecimal anonymizationStudySetupId,
			BigDecimal variableId, String variableRole,
			BigDecimal protocolDefinedVariableId, BigDecimal subsidiaryId) {
		this.anonymizationStudySetupId = anonymizationStudySetupId;
		this.variableId = variableId;
		this.variableRole = variableRole;
		this.protocolDefinedVariableId = protocolDefinedVariableId;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getAnonymizationStudySetupId() {
		return this.anonymizationStudySetupId;
	}

	public void setAnonymizationStudySetupId(
			BigDecimal anonymizationStudySetupId) {
		this.anonymizationStudySetupId = anonymizationStudySetupId;
	}

	public BigDecimal getVariableId() {
		return this.variableId;
	}

	public void setVariableId(BigDecimal variableId) {
		this.variableId = variableId;
	}

	public String getVariableRole() {
		return this.variableRole;
	}

	public void setVariableRole(String variableRole) {
		this.variableRole = variableRole;
	}

	public BigDecimal getProtocolDefinedVariableId() {
		return this.protocolDefinedVariableId;
	}

	public void setProtocolDefinedVariableId(
			BigDecimal protocolDefinedVariableId) {
		this.protocolDefinedVariableId = protocolDefinedVariableId;
	}

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudyVariableRoleId))
			return false;
		StudyVariableRoleId castOther = (StudyVariableRoleId) other;

		return ((this.getAnonymizationStudySetupId() == castOther
				.getAnonymizationStudySetupId()) || (this
				.getAnonymizationStudySetupId() != null
				&& castOther.getAnonymizationStudySetupId() != null && this
				.getAnonymizationStudySetupId().equals(
						castOther.getAnonymizationStudySetupId())))
				&& ((this.getVariableId() == castOther.getVariableId()) || (this
						.getVariableId() != null
						&& castOther.getVariableId() != null && this
						.getVariableId().equals(castOther.getVariableId())))
				&& ((this.getVariableRole() == castOther.getVariableRole()) || (this
						.getVariableRole() != null
						&& castOther.getVariableRole() != null && this
						.getVariableRole().equals(castOther.getVariableRole())))
				&& ((this.getProtocolDefinedVariableId() == castOther
						.getProtocolDefinedVariableId()) || (this
						.getProtocolDefinedVariableId() != null
						&& castOther.getProtocolDefinedVariableId() != null && this
						.getProtocolDefinedVariableId().equals(
								castOther.getProtocolDefinedVariableId())))
				&& ((this.getSubsidiaryId() == castOther.getSubsidiaryId()) || (this
						.getSubsidiaryId() != null
						&& castOther.getSubsidiaryId() != null && this
						.getSubsidiaryId().equals(castOther.getSubsidiaryId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAnonymizationStudySetupId() == null ? 0 : this
						.getAnonymizationStudySetupId().hashCode());
		result = 37
				* result
				+ (getVariableId() == null ? 0 : this.getVariableId()
						.hashCode());
		result = 37
				* result
				+ (getVariableRole() == null ? 0 : this.getVariableRole()
						.hashCode());
		result = 37
				* result
				+ (getProtocolDefinedVariableId() == null ? 0 : this
						.getProtocolDefinedVariableId().hashCode());
		result = 37
				* result
				+ (getSubsidiaryId() == null ? 0 : this.getSubsidiaryId()
						.hashCode());
		return result;
	}

}