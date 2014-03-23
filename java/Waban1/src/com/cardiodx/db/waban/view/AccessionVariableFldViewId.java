package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AccessionVariableFldViewId generated by hbm2java
 */
public class AccessionVariableFldViewId implements java.io.Serializable {

	private BigDecimal accessionVariableFldId;
	private BigDecimal accessionId;
	private BigDecimal protocolDefinedVariableId;
	private BigDecimal organizationId;
	private BigDecimal contactId;
	private BigDecimal patientId;
	private String value;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;

	public AccessionVariableFldViewId() {
	}

	public AccessionVariableFldViewId(BigDecimal accessionVariableFldId,
			BigDecimal accessionId, BigDecimal protocolDefinedVariableId) {
		this.accessionVariableFldId = accessionVariableFldId;
		this.accessionId = accessionId;
		this.protocolDefinedVariableId = protocolDefinedVariableId;
	}

	public AccessionVariableFldViewId(BigDecimal accessionVariableFldId,
			BigDecimal accessionId, BigDecimal protocolDefinedVariableId,
			BigDecimal organizationId, BigDecimal contactId,
			BigDecimal patientId, String value, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			BigDecimal subsidiaryId) {
		this.accessionVariableFldId = accessionVariableFldId;
		this.accessionId = accessionId;
		this.protocolDefinedVariableId = protocolDefinedVariableId;
		this.organizationId = organizationId;
		this.contactId = contactId;
		this.patientId = patientId;
		this.value = value;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getAccessionVariableFldId() {
		return this.accessionVariableFldId;
	}

	public void setAccessionVariableFldId(BigDecimal accessionVariableFldId) {
		this.accessionVariableFldId = accessionVariableFldId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public BigDecimal getProtocolDefinedVariableId() {
		return this.protocolDefinedVariableId;
	}

	public void setProtocolDefinedVariableId(
			BigDecimal protocolDefinedVariableId) {
		this.protocolDefinedVariableId = protocolDefinedVariableId;
	}

	public BigDecimal getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(BigDecimal organizationId) {
		this.organizationId = organizationId;
	}

	public BigDecimal getContactId() {
		return this.contactId;
	}

	public void setContactId(BigDecimal contactId) {
		this.contactId = contactId;
	}

	public BigDecimal getPatientId() {
		return this.patientId;
	}

	public void setPatientId(BigDecimal patientId) {
		this.patientId = patientId;
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
		if (!(other instanceof AccessionVariableFldViewId))
			return false;
		AccessionVariableFldViewId castOther = (AccessionVariableFldViewId) other;

		return ((this.getAccessionVariableFldId() == castOther
				.getAccessionVariableFldId()) || (this
				.getAccessionVariableFldId() != null
				&& castOther.getAccessionVariableFldId() != null && this
				.getAccessionVariableFldId().equals(
						castOther.getAccessionVariableFldId())))
				&& ((this.getAccessionId() == castOther.getAccessionId()) || (this
						.getAccessionId() != null
						&& castOther.getAccessionId() != null && this
						.getAccessionId().equals(castOther.getAccessionId())))
				&& ((this.getProtocolDefinedVariableId() == castOther
						.getProtocolDefinedVariableId()) || (this
						.getProtocolDefinedVariableId() != null
						&& castOther.getProtocolDefinedVariableId() != null && this
						.getProtocolDefinedVariableId().equals(
								castOther.getProtocolDefinedVariableId())))
				&& ((this.getOrganizationId() == castOther.getOrganizationId()) || (this
						.getOrganizationId() != null
						&& castOther.getOrganizationId() != null && this
						.getOrganizationId().equals(
								castOther.getOrganizationId())))
				&& ((this.getContactId() == castOther.getContactId()) || (this
						.getContactId() != null
						&& castOther.getContactId() != null && this
						.getContactId().equals(castOther.getContactId())))
				&& ((this.getPatientId() == castOther.getPatientId()) || (this
						.getPatientId() != null
						&& castOther.getPatientId() != null && this
						.getPatientId().equals(castOther.getPatientId())))
				&& ((this.getValue() == castOther.getValue()) || (this
						.getValue() != null && castOther.getValue() != null && this
						.getValue().equals(castOther.getValue())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getModifiedBy() == castOther.getModifiedBy()) || (this
						.getModifiedBy() != null
						&& castOther.getModifiedBy() != null && this
						.getModifiedBy().equals(castOther.getModifiedBy())))
				&& ((this.getDateModified() == castOther.getDateModified()) || (this
						.getDateModified() != null
						&& castOther.getDateModified() != null && this
						.getDateModified().equals(castOther.getDateModified())))
				&& ((this.getSubsidiaryId() == castOther.getSubsidiaryId()) || (this
						.getSubsidiaryId() != null
						&& castOther.getSubsidiaryId() != null && this
						.getSubsidiaryId().equals(castOther.getSubsidiaryId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAccessionVariableFldId() == null ? 0 : this
						.getAccessionVariableFldId().hashCode());
		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		result = 37
				* result
				+ (getProtocolDefinedVariableId() == null ? 0 : this
						.getProtocolDefinedVariableId().hashCode());
		result = 37
				* result
				+ (getOrganizationId() == null ? 0 : this.getOrganizationId()
						.hashCode());
		result = 37 * result
				+ (getContactId() == null ? 0 : this.getContactId().hashCode());
		result = 37 * result
				+ (getPatientId() == null ? 0 : this.getPatientId().hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37
				* result
				+ (getModifiedBy() == null ? 0 : this.getModifiedBy()
						.hashCode());
		result = 37
				* result
				+ (getDateModified() == null ? 0 : this.getDateModified()
						.hashCode());
		result = 37
				* result
				+ (getSubsidiaryId() == null ? 0 : this.getSubsidiaryId()
						.hashCode());
		return result;
	}

}
