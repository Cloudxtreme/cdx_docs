package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ShipmentSample generated by hbm2java
 */
public class ShipmentSample implements java.io.Serializable {

	private BigDecimal shipmentSampleId;
	private Organization organization;
	private ShipmentReceipt shipmentReceipt;
	private SampleTable sampleTable;
	private String qcStatus;
	private String qcComment;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;

	public ShipmentSample() {
	}

	public ShipmentSample(BigDecimal shipmentSampleId) {
		this.shipmentSampleId = shipmentSampleId;
	}

	public ShipmentSample(BigDecimal shipmentSampleId,
			Organization organization, ShipmentReceipt shipmentReceipt,
			SampleTable sampleTable, String qcStatus, String qcComment,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, BigDecimal subsidiaryId) {
		this.shipmentSampleId = shipmentSampleId;
		this.organization = organization;
		this.shipmentReceipt = shipmentReceipt;
		this.sampleTable = sampleTable;
		this.qcStatus = qcStatus;
		this.qcComment = qcComment;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getShipmentSampleId() {
		return this.shipmentSampleId;
	}

	public void setShipmentSampleId(BigDecimal shipmentSampleId) {
		this.shipmentSampleId = shipmentSampleId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public ShipmentReceipt getShipmentReceipt() {
		return this.shipmentReceipt;
	}

	public void setShipmentReceipt(ShipmentReceipt shipmentReceipt) {
		this.shipmentReceipt = shipmentReceipt;
	}

	public SampleTable getSampleTable() {
		return this.sampleTable;
	}

	public void setSampleTable(SampleTable sampleTable) {
		this.sampleTable = sampleTable;
	}

	public String getQcStatus() {
		return this.qcStatus;
	}

	public void setQcStatus(String qcStatus) {
		this.qcStatus = qcStatus;
	}

	public String getQcComment() {
		return this.qcComment;
	}

	public void setQcComment(String qcComment) {
		this.qcComment = qcComment;
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
