package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudTestAttributeFld generated by hbm2java
 */
public class AudTestAttributeFld implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal testAttributeFldId;
	private BigDecimal testAttributeId;
	private BigDecimal roiSelectionId;
	private BigDecimal organizationId;
	private BigDecimal contactId;
	private String attributeValue;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;
	private String changedBy;
	private Date dateChanged;
	private String changeType;

	public AudTestAttributeFld() {
	}

	public AudTestAttributeFld(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudTestAttributeFld(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal testAttributeFldId, BigDecimal testAttributeId,
			BigDecimal roiSelectionId, BigDecimal organizationId,
			BigDecimal contactId, String attributeValue, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			BigDecimal subsidiaryId, String changedBy, Date dateChanged,
			String changeType) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.testAttributeFldId = testAttributeFldId;
		this.testAttributeId = testAttributeId;
		this.roiSelectionId = roiSelectionId;
		this.organizationId = organizationId;
		this.contactId = contactId;
		this.attributeValue = attributeValue;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public BigDecimal getChangeReasonId() {
		return this.changeReasonId;
	}

	public void setChangeReasonId(BigDecimal changeReasonId) {
		this.changeReasonId = changeReasonId;
	}

	public BigDecimal getTestAttributeFldId() {
		return this.testAttributeFldId;
	}

	public void setTestAttributeFldId(BigDecimal testAttributeFldId) {
		this.testAttributeFldId = testAttributeFldId;
	}

	public BigDecimal getTestAttributeId() {
		return this.testAttributeId;
	}

	public void setTestAttributeId(BigDecimal testAttributeId) {
		this.testAttributeId = testAttributeId;
	}

	public BigDecimal getRoiSelectionId() {
		return this.roiSelectionId;
	}

	public void setRoiSelectionId(BigDecimal roiSelectionId) {
		this.roiSelectionId = roiSelectionId;
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

	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
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

	public String getChangeType() {
		return this.changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

}
