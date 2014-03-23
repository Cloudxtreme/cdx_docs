package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * TestVariableFld generated by hbm2java
 */
public class TestVariableFld implements java.io.Serializable {

	private BigDecimal testVariableFldId;
	private Organization organization;
	private TestSetup testSetup;
	private Contact contact;
	private ProtocolDefinedVariable protocolDefinedVariable;
	private Subsidiary subsidiary;
	private String value;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

	public TestVariableFld() {
	}

	public TestVariableFld(BigDecimal testVariableFldId, TestSetup testSetup,
			ProtocolDefinedVariable protocolDefinedVariable, String createdBy,
			Date dateCreated) {
		this.testVariableFldId = testVariableFldId;
		this.testSetup = testSetup;
		this.protocolDefinedVariable = protocolDefinedVariable;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public TestVariableFld(BigDecimal testVariableFldId,
			Organization organization, TestSetup testSetup, Contact contact,
			ProtocolDefinedVariable protocolDefinedVariable,
			Subsidiary subsidiary, String value, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified) {
		this.testVariableFldId = testVariableFldId;
		this.organization = organization;
		this.testSetup = testSetup;
		this.contact = contact;
		this.protocolDefinedVariable = protocolDefinedVariable;
		this.subsidiary = subsidiary;
		this.value = value;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getTestVariableFldId() {
		return this.testVariableFldId;
	}

	public void setTestVariableFldId(BigDecimal testVariableFldId) {
		this.testVariableFldId = testVariableFldId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public TestSetup getTestSetup() {
		return this.testSetup;
	}

	public void setTestSetup(TestSetup testSetup) {
		this.testSetup = testSetup;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ProtocolDefinedVariable getProtocolDefinedVariable() {
		return this.protocolDefinedVariable;
	}

	public void setProtocolDefinedVariable(
			ProtocolDefinedVariable protocolDefinedVariable) {
		this.protocolDefinedVariable = protocolDefinedVariable;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
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

}