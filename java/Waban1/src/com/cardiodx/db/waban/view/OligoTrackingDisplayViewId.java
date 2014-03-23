package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * OligoTrackingDisplayViewId generated by hbm2java
 */
public class OligoTrackingDisplayViewId implements java.io.Serializable {

	private String company;
	private String reagentBarcode;
	private String oligoName;
	private String location;
	private String lotNumber;
	private BigDecimal volume;
	private Date expirationDate;
	private BigDecimal reagentId;
	private BigDecimal oligoId;
	private String oligoSequence;
	private String modification5;
	private String modification3;
	private String internalModification;
	private String oligoType;
	private String temperature;
	private BigDecimal concentration;
	private String unit;
	private String purpose;
	private String mixture;
	private String dateReceived;
	private String status;
	private String containerId;
	private BigDecimal containerRow;
	private BigDecimal containerColumn;
	private String assayName;
	private String assayOwner;
	private String assayCondition;
	private String assayType;
	private String comments;
	private String roi;
	private BigDecimal roiId;

	public OligoTrackingDisplayViewId() {
	}

	public OligoTrackingDisplayViewId(String oligoName, BigDecimal oligoId) {
		this.oligoName = oligoName;
		this.oligoId = oligoId;
	}

	public OligoTrackingDisplayViewId(String company, String reagentBarcode,
			String oligoName, String location, String lotNumber,
			BigDecimal volume, Date expirationDate, BigDecimal reagentId,
			BigDecimal oligoId, String oligoSequence, String modification5,
			String modification3, String internalModification,
			String oligoType, String temperature, BigDecimal concentration,
			String unit, String purpose, String mixture, String dateReceived,
			String status, String containerId, BigDecimal containerRow,
			BigDecimal containerColumn, String assayName, String assayOwner,
			String assayCondition, String assayType, String comments,
			String roi, BigDecimal roiId) {
		this.company = company;
		this.reagentBarcode = reagentBarcode;
		this.oligoName = oligoName;
		this.location = location;
		this.lotNumber = lotNumber;
		this.volume = volume;
		this.expirationDate = expirationDate;
		this.reagentId = reagentId;
		this.oligoId = oligoId;
		this.oligoSequence = oligoSequence;
		this.modification5 = modification5;
		this.modification3 = modification3;
		this.internalModification = internalModification;
		this.oligoType = oligoType;
		this.temperature = temperature;
		this.concentration = concentration;
		this.unit = unit;
		this.purpose = purpose;
		this.mixture = mixture;
		this.dateReceived = dateReceived;
		this.status = status;
		this.containerId = containerId;
		this.containerRow = containerRow;
		this.containerColumn = containerColumn;
		this.assayName = assayName;
		this.assayOwner = assayOwner;
		this.assayCondition = assayCondition;
		this.assayType = assayType;
		this.comments = comments;
		this.roi = roi;
		this.roiId = roiId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getReagentBarcode() {
		return this.reagentBarcode;
	}

	public void setReagentBarcode(String reagentBarcode) {
		this.reagentBarcode = reagentBarcode;
	}

	public String getOligoName() {
		return this.oligoName;
	}

	public void setOligoName(String oligoName) {
		this.oligoName = oligoName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLotNumber() {
		return this.lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public BigDecimal getReagentId() {
		return this.reagentId;
	}

	public void setReagentId(BigDecimal reagentId) {
		this.reagentId = reagentId;
	}

	public BigDecimal getOligoId() {
		return this.oligoId;
	}

	public void setOligoId(BigDecimal oligoId) {
		this.oligoId = oligoId;
	}

	public String getOligoSequence() {
		return this.oligoSequence;
	}

	public void setOligoSequence(String oligoSequence) {
		this.oligoSequence = oligoSequence;
	}

	public String getModification5() {
		return this.modification5;
	}

	public void setModification5(String modification5) {
		this.modification5 = modification5;
	}

	public String getModification3() {
		return this.modification3;
	}

	public void setModification3(String modification3) {
		this.modification3 = modification3;
	}

	public String getInternalModification() {
		return this.internalModification;
	}

	public void setInternalModification(String internalModification) {
		this.internalModification = internalModification;
	}

	public String getOligoType() {
		return this.oligoType;
	}

	public void setOligoType(String oligoType) {
		this.oligoType = oligoType;
	}

	public String getTemperature() {
		return this.temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getConcentration() {
		return this.concentration;
	}

	public void setConcentration(BigDecimal concentration) {
		this.concentration = concentration;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getMixture() {
		return this.mixture;
	}

	public void setMixture(String mixture) {
		this.mixture = mixture;
	}

	public String getDateReceived() {
		return this.dateReceived;
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getAssayName() {
		return this.assayName;
	}

	public void setAssayName(String assayName) {
		this.assayName = assayName;
	}

	public String getAssayOwner() {
		return this.assayOwner;
	}

	public void setAssayOwner(String assayOwner) {
		this.assayOwner = assayOwner;
	}

	public String getAssayCondition() {
		return this.assayCondition;
	}

	public void setAssayCondition(String assayCondition) {
		this.assayCondition = assayCondition;
	}

	public String getAssayType() {
		return this.assayType;
	}

	public void setAssayType(String assayType) {
		this.assayType = assayType;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRoi() {
		return this.roi;
	}

	public void setRoi(String roi) {
		this.roi = roi;
	}

	public BigDecimal getRoiId() {
		return this.roiId;
	}

	public void setRoiId(BigDecimal roiId) {
		this.roiId = roiId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OligoTrackingDisplayViewId))
			return false;
		OligoTrackingDisplayViewId castOther = (OligoTrackingDisplayViewId) other;

		return ((this.getCompany() == castOther.getCompany()) || (this
				.getCompany() != null && castOther.getCompany() != null && this
				.getCompany().equals(castOther.getCompany())))
				&& ((this.getReagentBarcode() == castOther.getReagentBarcode()) || (this
						.getReagentBarcode() != null
						&& castOther.getReagentBarcode() != null && this
						.getReagentBarcode().equals(
								castOther.getReagentBarcode())))
				&& ((this.getOligoName() == castOther.getOligoName()) || (this
						.getOligoName() != null
						&& castOther.getOligoName() != null && this
						.getOligoName().equals(castOther.getOligoName())))
				&& ((this.getLocation() == castOther.getLocation()) || (this
						.getLocation() != null
						&& castOther.getLocation() != null && this
						.getLocation().equals(castOther.getLocation())))
				&& ((this.getLotNumber() == castOther.getLotNumber()) || (this
						.getLotNumber() != null
						&& castOther.getLotNumber() != null && this
						.getLotNumber().equals(castOther.getLotNumber())))
				&& ((this.getVolume() == castOther.getVolume()) || (this
						.getVolume() != null && castOther.getVolume() != null && this
						.getVolume().equals(castOther.getVolume())))
				&& ((this.getExpirationDate() == castOther.getExpirationDate()) || (this
						.getExpirationDate() != null
						&& castOther.getExpirationDate() != null && this
						.getExpirationDate().equals(
								castOther.getExpirationDate())))
				&& ((this.getReagentId() == castOther.getReagentId()) || (this
						.getReagentId() != null
						&& castOther.getReagentId() != null && this
						.getReagentId().equals(castOther.getReagentId())))
				&& ((this.getOligoId() == castOther.getOligoId()) || (this
						.getOligoId() != null && castOther.getOligoId() != null && this
						.getOligoId().equals(castOther.getOligoId())))
				&& ((this.getOligoSequence() == castOther.getOligoSequence()) || (this
						.getOligoSequence() != null
						&& castOther.getOligoSequence() != null && this
						.getOligoSequence()
						.equals(castOther.getOligoSequence())))
				&& ((this.getModification5() == castOther.getModification5()) || (this
						.getModification5() != null
						&& castOther.getModification5() != null && this
						.getModification5()
						.equals(castOther.getModification5())))
				&& ((this.getModification3() == castOther.getModification3()) || (this
						.getModification3() != null
						&& castOther.getModification3() != null && this
						.getModification3()
						.equals(castOther.getModification3())))
				&& ((this.getInternalModification() == castOther
						.getInternalModification()) || (this
						.getInternalModification() != null
						&& castOther.getInternalModification() != null && this
						.getInternalModification().equals(
								castOther.getInternalModification())))
				&& ((this.getOligoType() == castOther.getOligoType()) || (this
						.getOligoType() != null
						&& castOther.getOligoType() != null && this
						.getOligoType().equals(castOther.getOligoType())))
				&& ((this.getTemperature() == castOther.getTemperature()) || (this
						.getTemperature() != null
						&& castOther.getTemperature() != null && this
						.getTemperature().equals(castOther.getTemperature())))
				&& ((this.getConcentration() == castOther.getConcentration()) || (this
						.getConcentration() != null
						&& castOther.getConcentration() != null && this
						.getConcentration()
						.equals(castOther.getConcentration())))
				&& ((this.getUnit() == castOther.getUnit()) || (this.getUnit() != null
						&& castOther.getUnit() != null && this.getUnit()
						.equals(castOther.getUnit())))
				&& ((this.getPurpose() == castOther.getPurpose()) || (this
						.getPurpose() != null && castOther.getPurpose() != null && this
						.getPurpose().equals(castOther.getPurpose())))
				&& ((this.getMixture() == castOther.getMixture()) || (this
						.getMixture() != null && castOther.getMixture() != null && this
						.getMixture().equals(castOther.getMixture())))
				&& ((this.getDateReceived() == castOther.getDateReceived()) || (this
						.getDateReceived() != null
						&& castOther.getDateReceived() != null && this
						.getDateReceived().equals(castOther.getDateReceived())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())))
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
								castOther.getContainerColumn())))
				&& ((this.getAssayName() == castOther.getAssayName()) || (this
						.getAssayName() != null
						&& castOther.getAssayName() != null && this
						.getAssayName().equals(castOther.getAssayName())))
				&& ((this.getAssayOwner() == castOther.getAssayOwner()) || (this
						.getAssayOwner() != null
						&& castOther.getAssayOwner() != null && this
						.getAssayOwner().equals(castOther.getAssayOwner())))
				&& ((this.getAssayCondition() == castOther.getAssayCondition()) || (this
						.getAssayCondition() != null
						&& castOther.getAssayCondition() != null && this
						.getAssayCondition().equals(
								castOther.getAssayCondition())))
				&& ((this.getAssayType() == castOther.getAssayType()) || (this
						.getAssayType() != null
						&& castOther.getAssayType() != null && this
						.getAssayType().equals(castOther.getAssayType())))
				&& ((this.getComments() == castOther.getComments()) || (this
						.getComments() != null
						&& castOther.getComments() != null && this
						.getComments().equals(castOther.getComments())))
				&& ((this.getRoi() == castOther.getRoi()) || (this.getRoi() != null
						&& castOther.getRoi() != null && this.getRoi().equals(
						castOther.getRoi())))
				&& ((this.getRoiId() == castOther.getRoiId()) || (this
						.getRoiId() != null && castOther.getRoiId() != null && this
						.getRoiId().equals(castOther.getRoiId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCompany() == null ? 0 : this.getCompany().hashCode());
		result = 37
				* result
				+ (getReagentBarcode() == null ? 0 : this.getReagentBarcode()
						.hashCode());
		result = 37 * result
				+ (getOligoName() == null ? 0 : this.getOligoName().hashCode());
		result = 37 * result
				+ (getLocation() == null ? 0 : this.getLocation().hashCode());
		result = 37 * result
				+ (getLotNumber() == null ? 0 : this.getLotNumber().hashCode());
		result = 37 * result
				+ (getVolume() == null ? 0 : this.getVolume().hashCode());
		result = 37
				* result
				+ (getExpirationDate() == null ? 0 : this.getExpirationDate()
						.hashCode());
		result = 37 * result
				+ (getReagentId() == null ? 0 : this.getReagentId().hashCode());
		result = 37 * result
				+ (getOligoId() == null ? 0 : this.getOligoId().hashCode());
		result = 37
				* result
				+ (getOligoSequence() == null ? 0 : this.getOligoSequence()
						.hashCode());
		result = 37
				* result
				+ (getModification5() == null ? 0 : this.getModification5()
						.hashCode());
		result = 37
				* result
				+ (getModification3() == null ? 0 : this.getModification3()
						.hashCode());
		result = 37
				* result
				+ (getInternalModification() == null ? 0 : this
						.getInternalModification().hashCode());
		result = 37 * result
				+ (getOligoType() == null ? 0 : this.getOligoType().hashCode());
		result = 37
				* result
				+ (getTemperature() == null ? 0 : this.getTemperature()
						.hashCode());
		result = 37
				* result
				+ (getConcentration() == null ? 0 : this.getConcentration()
						.hashCode());
		result = 37 * result
				+ (getUnit() == null ? 0 : this.getUnit().hashCode());
		result = 37 * result
				+ (getPurpose() == null ? 0 : this.getPurpose().hashCode());
		result = 37 * result
				+ (getMixture() == null ? 0 : this.getMixture().hashCode());
		result = 37
				* result
				+ (getDateReceived() == null ? 0 : this.getDateReceived()
						.hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
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
		result = 37 * result
				+ (getAssayName() == null ? 0 : this.getAssayName().hashCode());
		result = 37
				* result
				+ (getAssayOwner() == null ? 0 : this.getAssayOwner()
						.hashCode());
		result = 37
				* result
				+ (getAssayCondition() == null ? 0 : this.getAssayCondition()
						.hashCode());
		result = 37 * result
				+ (getAssayType() == null ? 0 : this.getAssayType().hashCode());
		result = 37 * result
				+ (getComments() == null ? 0 : this.getComments().hashCode());
		result = 37 * result
				+ (getRoi() == null ? 0 : this.getRoi().hashCode());
		result = 37 * result
				+ (getRoiId() == null ? 0 : this.getRoiId().hashCode());
		return result;
	}

}
