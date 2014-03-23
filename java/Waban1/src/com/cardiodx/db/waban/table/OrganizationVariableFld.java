package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * OrganizationVariableFld generated by hbm2java
 */
public class OrganizationVariableFld implements java.io.Serializable {

	private BigDecimal orgAttributeFldId;
	private Organization organization;
	private Contact contact;
	private BigDecimal orgAttributeId;
	private String value;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;

	public OrganizationVariableFld() {
	}

	public OrganizationVariableFld(BigDecimal orgAttributeFldId) {
		this.orgAttributeFldId = orgAttributeFldId;
	}

	public OrganizationVariableFld(BigDecimal orgAttributeFldId,
			Organization organization, Contact contact,
			BigDecimal orgAttributeId, String value, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			BigDecimal subsidiaryId) {
		this.orgAttributeFldId = orgAttributeFldId;
		this.organization = organization;
		this.contact = contact;
		this.orgAttributeId = orgAttributeId;
		this.value = value;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getOrgAttributeFldId() {
		return this.orgAttributeFldId;
	}

	public void setOrgAttributeFldId(BigDecimal orgAttributeFldId) {
		this.orgAttributeFldId = orgAttributeFldId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public BigDecimal getOrgAttributeId() {
		return this.orgAttributeId;
	}

	public void setOrgAttributeId(BigDecimal orgAttributeId) {
		this.orgAttributeId = orgAttributeId;
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

}