package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudOrganizationVariableFld generated by hbm2java
 */
public class AudOrganizationVariableFld implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal orgAttributeFldId;
	private BigDecimal orgAttributeId;
	private BigDecimal contactId;
	private BigDecimal organizationId;
	private String value;
	private BigDecimal changeReasonId;
	private String changeType;
	private String createdBy;
	private Date dateCreated;
	private String changedBy;
	private Date dateChanged;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;

	public AudOrganizationVariableFld() {
	}

	public AudOrganizationVariableFld(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudOrganizationVariableFld(BigDecimal auditId,
			BigDecimal orgAttributeFldId, BigDecimal orgAttributeId,
			BigDecimal contactId, BigDecimal organizationId, String value,
			BigDecimal changeReasonId, String changeType, String createdBy,
			Date dateCreated, String changedBy, Date dateChanged,
			String modifiedBy, Date dateModified, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.orgAttributeFldId = orgAttributeFldId;
		this.orgAttributeId = orgAttributeId;
		this.contactId = contactId;
		this.organizationId = organizationId;
		this.value = value;
		this.changeReasonId = changeReasonId;
		this.changeType = changeType;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public BigDecimal getOrgAttributeFldId() {
		return this.orgAttributeFldId;
	}

	public void setOrgAttributeFldId(BigDecimal orgAttributeFldId) {
		this.orgAttributeFldId = orgAttributeFldId;
	}

	public BigDecimal getOrgAttributeId() {
		return this.orgAttributeId;
	}

	public void setOrgAttributeId(BigDecimal orgAttributeId) {
		this.orgAttributeId = orgAttributeId;
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

}
