package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudTestVariableFld generated by hbm2java
 */
public class AudTestVariableFld implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal testVariableFldId;
	private BigDecimal testSetupId;
	private BigDecimal organizationId;
	private BigDecimal contactId;
	private BigDecimal protocolDefinedVariableId;
	private String value;
	private BigDecimal changeReasonId;
	private String changeType;
	private String createdBy;
	private Date dateCreated;
	private String changedBy;
	private Date dateChanged;
	private BigDecimal subsidiaryId;
	private String modifiedBy;
	private Date dateModified;

	public AudTestVariableFld() {
	}

	public AudTestVariableFld(BigDecimal auditId, BigDecimal testVariableFldId,
			BigDecimal testSetupId, String createdBy, Date dateCreated) {
		this.auditId = auditId;
		this.testVariableFldId = testVariableFldId;
		this.testSetupId = testSetupId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public AudTestVariableFld(BigDecimal auditId, BigDecimal testVariableFldId,
			BigDecimal testSetupId, BigDecimal organizationId,
			BigDecimal contactId, BigDecimal protocolDefinedVariableId,
			String value, BigDecimal changeReasonId, String changeType,
			String createdBy, Date dateCreated, String changedBy,
			Date dateChanged, BigDecimal subsidiaryId, String modifiedBy,
			Date dateModified) {
		this.auditId = auditId;
		this.testVariableFldId = testVariableFldId;
		this.testSetupId = testSetupId;
		this.organizationId = organizationId;
		this.contactId = contactId;
		this.protocolDefinedVariableId = protocolDefinedVariableId;
		this.value = value;
		this.changeReasonId = changeReasonId;
		this.changeType = changeType;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.subsidiaryId = subsidiaryId;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public BigDecimal getTestVariableFldId() {
		return this.testVariableFldId;
	}

	public void setTestVariableFldId(BigDecimal testVariableFldId) {
		this.testVariableFldId = testVariableFldId;
	}

	public BigDecimal getTestSetupId() {
		return this.testSetupId;
	}

	public void setTestSetupId(BigDecimal testSetupId) {
		this.testSetupId = testSetupId;
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

	public BigDecimal getProtocolDefinedVariableId() {
		return this.protocolDefinedVariableId;
	}

	public void setProtocolDefinedVariableId(
			BigDecimal protocolDefinedVariableId) {
		this.protocolDefinedVariableId = protocolDefinedVariableId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BigDecimal getChangeReasonId() {
		return this.changeReasonId;
	}

	public void setChangeReasonId(BigDecimal changeReasonId) {
		this.changeReasonId = changeReasonId;
	}

	public String getChangeType() {
		return this.changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
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

	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
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