package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ShipmentAirbill generated by hbm2java
 */
public class ShipmentAirbill implements java.io.Serializable {

	private BigDecimal shipmentAirbillId;
	private ShipmentReceipt shipmentReceipt;
	private Organization organization;
	private String airbillNumber;
	private BigDecimal expectedBoxes;
	private BigDecimal expectedSpecimens;
	private Date receivedDate;
	private Date courierDate;
	private Date expectedDate;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;
	private Set<ShipmentPackage> shipmentPackages = new HashSet<ShipmentPackage>(
			0);

	public ShipmentAirbill() {
	}

	public ShipmentAirbill(BigDecimal shipmentAirbillId,
			ShipmentReceipt shipmentReceipt, String airbillNumber) {
		this.shipmentAirbillId = shipmentAirbillId;
		this.shipmentReceipt = shipmentReceipt;
		this.airbillNumber = airbillNumber;
	}

	public ShipmentAirbill(BigDecimal shipmentAirbillId,
			ShipmentReceipt shipmentReceipt, Organization organization,
			String airbillNumber, BigDecimal expectedBoxes,
			BigDecimal expectedSpecimens, Date receivedDate, Date courierDate,
			Date expectedDate, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified, BigDecimal subsidiaryId,
			Set<ShipmentPackage> shipmentPackages) {
		this.shipmentAirbillId = shipmentAirbillId;
		this.shipmentReceipt = shipmentReceipt;
		this.organization = organization;
		this.airbillNumber = airbillNumber;
		this.expectedBoxes = expectedBoxes;
		this.expectedSpecimens = expectedSpecimens;
		this.receivedDate = receivedDate;
		this.courierDate = courierDate;
		this.expectedDate = expectedDate;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
		this.shipmentPackages = shipmentPackages;
	}

	public BigDecimal getShipmentAirbillId() {
		return this.shipmentAirbillId;
	}

	public void setShipmentAirbillId(BigDecimal shipmentAirbillId) {
		this.shipmentAirbillId = shipmentAirbillId;
	}

	public ShipmentReceipt getShipmentReceipt() {
		return this.shipmentReceipt;
	}

	public void setShipmentReceipt(ShipmentReceipt shipmentReceipt) {
		this.shipmentReceipt = shipmentReceipt;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getAirbillNumber() {
		return this.airbillNumber;
	}

	public void setAirbillNumber(String airbillNumber) {
		this.airbillNumber = airbillNumber;
	}

	public BigDecimal getExpectedBoxes() {
		return this.expectedBoxes;
	}

	public void setExpectedBoxes(BigDecimal expectedBoxes) {
		this.expectedBoxes = expectedBoxes;
	}

	public BigDecimal getExpectedSpecimens() {
		return this.expectedSpecimens;
	}

	public void setExpectedSpecimens(BigDecimal expectedSpecimens) {
		this.expectedSpecimens = expectedSpecimens;
	}

	public Date getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Date getCourierDate() {
		return this.courierDate;
	}

	public void setCourierDate(Date courierDate) {
		this.courierDate = courierDate;
	}

	public Date getExpectedDate() {
		return this.expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
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

	public Set<ShipmentPackage> getShipmentPackages() {
		return this.shipmentPackages;
	}

	public void setShipmentPackages(Set<ShipmentPackage> shipmentPackages) {
		this.shipmentPackages = shipmentPackages;
	}

}
