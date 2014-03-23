package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * PendingSampleAttributeTable generated by hbm2java
 */
public class PendingSampleAttributeTable implements java.io.Serializable {

	private BigDecimal pendingSampleAttributeId;
	private Subsidiary subsidiary;
	private PendingSampleTable pendingSampleTable;
	private String attributeName;
	private String attributeValue;
	private String createdBy;
	private Date dateCreated;

	public PendingSampleAttributeTable() {
	}

	public PendingSampleAttributeTable(BigDecimal pendingSampleAttributeId,
			String attributeName, String createdBy, Date dateCreated) {
		this.pendingSampleAttributeId = pendingSampleAttributeId;
		this.attributeName = attributeName;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public PendingSampleAttributeTable(BigDecimal pendingSampleAttributeId,
			Subsidiary subsidiary, PendingSampleTable pendingSampleTable,
			String attributeName, String attributeValue, String createdBy,
			Date dateCreated) {
		this.pendingSampleAttributeId = pendingSampleAttributeId;
		this.subsidiary = subsidiary;
		this.pendingSampleTable = pendingSampleTable;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public BigDecimal getPendingSampleAttributeId() {
		return this.pendingSampleAttributeId;
	}

	public void setPendingSampleAttributeId(BigDecimal pendingSampleAttributeId) {
		this.pendingSampleAttributeId = pendingSampleAttributeId;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public PendingSampleTable getPendingSampleTable() {
		return this.pendingSampleTable;
	}

	public void setPendingSampleTable(PendingSampleTable pendingSampleTable) {
		this.pendingSampleTable = pendingSampleTable;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
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

}
