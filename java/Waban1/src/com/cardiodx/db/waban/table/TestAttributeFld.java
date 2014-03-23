package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * TestAttributeFld generated by hbm2java
 */
public class TestAttributeFld implements java.io.Serializable {

	private BigDecimal testAttributeFldId;
	private RoiSelection roiSelection;
	private Organization organization;
	private Contact contact;
	private Subsidiary subsidiary;
	private TestConditionAttribute testConditionAttribute;
	private String attributeValue;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

	public TestAttributeFld() {
	}

	public TestAttributeFld(BigDecimal testAttributeFldId) {
		this.testAttributeFldId = testAttributeFldId;
	}

	public TestAttributeFld(BigDecimal testAttributeFldId,
			RoiSelection roiSelection, Organization organization,
			Contact contact, Subsidiary subsidiary,
			TestConditionAttribute testConditionAttribute,
			String attributeValue, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified) {
		this.testAttributeFldId = testAttributeFldId;
		this.roiSelection = roiSelection;
		this.organization = organization;
		this.contact = contact;
		this.subsidiary = subsidiary;
		this.testConditionAttribute = testConditionAttribute;
		this.attributeValue = attributeValue;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getTestAttributeFldId() {
		return this.testAttributeFldId;
	}

	public void setTestAttributeFldId(BigDecimal testAttributeFldId) {
		this.testAttributeFldId = testAttributeFldId;
	}

	public RoiSelection getRoiSelection() {
		return this.roiSelection;
	}

	public void setRoiSelection(RoiSelection roiSelection) {
		this.roiSelection = roiSelection;
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

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public TestConditionAttribute getTestConditionAttribute() {
		return this.testConditionAttribute;
	}

	public void setTestConditionAttribute(
			TestConditionAttribute testConditionAttribute) {
		this.testConditionAttribute = testConditionAttribute;
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

}
