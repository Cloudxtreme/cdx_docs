package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ReagentDisplayViewId generated by hbm2java
 */
public class ReagentDisplayViewId implements java.io.Serializable {

	private String reagentBarcode;
	private String reagentName;
	private String lotNumber;
	private String expirationDate;
	private String status;
	private BigDecimal volume;
	private Character lastCol;
	private String company;
	private Date dateModified;
	private String modifiedBy;
	private Date dateCreated;
	private String createdBy;
	private BigDecimal concentration;
	private BigDecimal organizationId;
	private BigDecimal parentReagentId;
	private BigDecimal reagentId;
	private String parentBarcode;
	private String units;
	private Date dateReceived;
	private String location;
	private String containerId;
	private BigDecimal containerRow;
	private BigDecimal containerColumn;

	public ReagentDisplayViewId() {
	}

	public ReagentDisplayViewId(String company, BigDecimal reagentId) {
		this.company = company;
		this.reagentId = reagentId;
	}

	public ReagentDisplayViewId(String reagentBarcode, String reagentName,
			String lotNumber, String expirationDate, String status,
			BigDecimal volume, Character lastCol, String company,
			Date dateModified, String modifiedBy, Date dateCreated,
			String createdBy, BigDecimal concentration,
			BigDecimal organizationId, BigDecimal parentReagentId,
			BigDecimal reagentId, String parentBarcode, String units,
			Date dateReceived, String location, String containerId,
			BigDecimal containerRow, BigDecimal containerColumn) {
		this.reagentBarcode = reagentBarcode;
		this.reagentName = reagentName;
		this.lotNumber = lotNumber;
		this.expirationDate = expirationDate;
		this.status = status;
		this.volume = volume;
		this.lastCol = lastCol;
		this.company = company;
		this.dateModified = dateModified;
		this.modifiedBy = modifiedBy;
		this.dateCreated = dateCreated;
		this.createdBy = createdBy;
		this.concentration = concentration;
		this.organizationId = organizationId;
		this.parentReagentId = parentReagentId;
		this.reagentId = reagentId;
		this.parentBarcode = parentBarcode;
		this.units = units;
		this.dateReceived = dateReceived;
		this.location = location;
		this.containerId = containerId;
		this.containerRow = containerRow;
		this.containerColumn = containerColumn;
	}

	public String getReagentBarcode() {
		return this.reagentBarcode;
	}

	public void setReagentBarcode(String reagentBarcode) {
		this.reagentBarcode = reagentBarcode;
	}

	public String getReagentName() {
		return this.reagentName;
	}

	public void setReagentName(String reagentName) {
		this.reagentName = reagentName;
	}

	public String getLotNumber() {
		return this.lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public String getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public Character getLastCol() {
		return this.lastCol;
	}

	public void setLastCol(Character lastCol) {
		this.lastCol = lastCol;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getConcentration() {
		return this.concentration;
	}

	public void setConcentration(BigDecimal concentration) {
		this.concentration = concentration;
	}

	public BigDecimal getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(BigDecimal organizationId) {
		this.organizationId = organizationId;
	}

	public BigDecimal getParentReagentId() {
		return this.parentReagentId;
	}

	public void setParentReagentId(BigDecimal parentReagentId) {
		this.parentReagentId = parentReagentId;
	}

	public BigDecimal getReagentId() {
		return this.reagentId;
	}

	public void setReagentId(BigDecimal reagentId) {
		this.reagentId = reagentId;
	}

	public String getParentBarcode() {
		return this.parentBarcode;
	}

	public void setParentBarcode(String parentBarcode) {
		this.parentBarcode = parentBarcode;
	}

	public String getUnits() {
		return this.units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Date getDateReceived() {
		return this.dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public BigDecimal getContainerRow() {
		return this.containerRow;
	}

	public void setContainerRow(BigDecimal containerRow) {
		this.containerRow = containerRow;
	}

	public BigDecimal getContainerColumn() {
		return this.containerColumn;
	}

	public void setContainerColumn(BigDecimal containerColumn) {
		this.containerColumn = containerColumn;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReagentDisplayViewId))
			return false;
		ReagentDisplayViewId castOther = (ReagentDisplayViewId) other;

		return ((this.getReagentBarcode() == castOther.getReagentBarcode()) || (this
				.getReagentBarcode() != null
				&& castOther.getReagentBarcode() != null && this
				.getReagentBarcode().equals(castOther.getReagentBarcode())))
				&& ((this.getReagentName() == castOther.getReagentName()) || (this
						.getReagentName() != null
						&& castOther.getReagentName() != null && this
						.getReagentName().equals(castOther.getReagentName())))
				&& ((this.getLotNumber() == castOther.getLotNumber()) || (this
						.getLotNumber() != null
						&& castOther.getLotNumber() != null && this
						.getLotNumber().equals(castOther.getLotNumber())))
				&& ((this.getExpirationDate() == castOther.getExpirationDate()) || (this
						.getExpirationDate() != null
						&& castOther.getExpirationDate() != null && this
						.getExpirationDate().equals(
								castOther.getExpirationDate())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())))
				&& ((this.getVolume() == castOther.getVolume()) || (this
						.getVolume() != null && castOther.getVolume() != null && this
						.getVolume().equals(castOther.getVolume())))
				&& ((this.getLastCol() == castOther.getLastCol()) || (this
						.getLastCol() != null && castOther.getLastCol() != null && this
						.getLastCol().equals(castOther.getLastCol())))
				&& ((this.getCompany() == castOther.getCompany()) || (this
						.getCompany() != null && castOther.getCompany() != null && this
						.getCompany().equals(castOther.getCompany())))
				&& ((this.getDateModified() == castOther.getDateModified()) || (this
						.getDateModified() != null
						&& castOther.getDateModified() != null && this
						.getDateModified().equals(castOther.getDateModified())))
				&& ((this.getModifiedBy() == castOther.getModifiedBy()) || (this
						.getModifiedBy() != null
						&& castOther.getModifiedBy() != null && this
						.getModifiedBy().equals(castOther.getModifiedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getConcentration() == castOther.getConcentration()) || (this
						.getConcentration() != null
						&& castOther.getConcentration() != null && this
						.getConcentration()
						.equals(castOther.getConcentration())))
				&& ((this.getOrganizationId() == castOther.getOrganizationId()) || (this
						.getOrganizationId() != null
						&& castOther.getOrganizationId() != null && this
						.getOrganizationId().equals(
								castOther.getOrganizationId())))
				&& ((this.getParentReagentId() == castOther
						.getParentReagentId()) || (this.getParentReagentId() != null
						&& castOther.getParentReagentId() != null && this
						.getParentReagentId().equals(
								castOther.getParentReagentId())))
				&& ((this.getReagentId() == castOther.getReagentId()) || (this
						.getReagentId() != null
						&& castOther.getReagentId() != null && this
						.getReagentId().equals(castOther.getReagentId())))
				&& ((this.getParentBarcode() == castOther.getParentBarcode()) || (this
						.getParentBarcode() != null
						&& castOther.getParentBarcode() != null && this
						.getParentBarcode()
						.equals(castOther.getParentBarcode())))
				&& ((this.getUnits() == castOther.getUnits()) || (this
						.getUnits() != null && castOther.getUnits() != null && this
						.getUnits().equals(castOther.getUnits())))
				&& ((this.getDateReceived() == castOther.getDateReceived()) || (this
						.getDateReceived() != null
						&& castOther.getDateReceived() != null && this
						.getDateReceived().equals(castOther.getDateReceived())))
				&& ((this.getLocation() == castOther.getLocation()) || (this
						.getLocation() != null
						&& castOther.getLocation() != null && this
						.getLocation().equals(castOther.getLocation())))
				&& ((this.getContainerId() == castOther.getContainerId()) || (this
						.getContainerId() != null
						&& castOther.getContainerId() != null && this
						.getContainerId().equals(castOther.getContainerId())))
				&& ((this.getContainerRow() == castOther.getContainerRow()) || (this
						.getContainerRow() != null
						&& castOther.getContainerRow() != null && this
						.getContainerRow().equals(castOther.getContainerRow())))
				&& ((this.getContainerColumn() == castOther
						.getContainerColumn()) || (this.getContainerColumn() != null
						&& castOther.getContainerColumn() != null && this
						.getContainerColumn().equals(
								castOther.getContainerColumn())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getReagentBarcode() == null ? 0 : this.getReagentBarcode()
						.hashCode());
		result = 37
				* result
				+ (getReagentName() == null ? 0 : this.getReagentName()
						.hashCode());
		result = 37 * result
				+ (getLotNumber() == null ? 0 : this.getLotNumber().hashCode());
		result = 37
				* result
				+ (getExpirationDate() == null ? 0 : this.getExpirationDate()
						.hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37 * result
				+ (getVolume() == null ? 0 : this.getVolume().hashCode());
		result = 37 * result
				+ (getLastCol() == null ? 0 : this.getLastCol().hashCode());
		result = 37 * result
				+ (getCompany() == null ? 0 : this.getCompany().hashCode());
		result = 37
				* result
				+ (getDateModified() == null ? 0 : this.getDateModified()
						.hashCode());
		result = 37
				* result
				+ (getModifiedBy() == null ? 0 : this.getModifiedBy()
						.hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getConcentration() == null ? 0 : this.getConcentration()
						.hashCode());
		result = 37
				* result
				+ (getOrganizationId() == null ? 0 : this.getOrganizationId()
						.hashCode());
		result = 37
				* result
				+ (getParentReagentId() == null ? 0 : this.getParentReagentId()
						.hashCode());
		result = 37 * result
				+ (getReagentId() == null ? 0 : this.getReagentId().hashCode());
		result = 37
				* result
				+ (getParentBarcode() == null ? 0 : this.getParentBarcode()
						.hashCode());
		result = 37 * result
				+ (getUnits() == null ? 0 : this.getUnits().hashCode());
		result = 37
				* result
				+ (getDateReceived() == null ? 0 : this.getDateReceived()
						.hashCode());
		result = 37 * result
				+ (getLocation() == null ? 0 : this.getLocation().hashCode());
		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		result = 37
				* result
				+ (getContainerRow() == null ? 0 : this.getContainerRow()
						.hashCode());
		result = 37
				* result
				+ (getContainerColumn() == null ? 0 : this.getContainerColumn()
						.hashCode());
		return result;
	}

}
