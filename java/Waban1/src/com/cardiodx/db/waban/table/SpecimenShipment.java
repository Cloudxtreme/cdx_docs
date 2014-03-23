package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SpecimenShipment generated by hbm2java
 */
public class SpecimenShipment implements java.io.Serializable {

	private BigDecimal shipmentId;
	private SpecimenRequest specimenRequest;
	private Organization organization;
	private String shipmentNo;
	private Date shipmentDate;
	private String shipmentTemperature;
	private String shipmentStatus;
	private String shipStatus;
	private String comments;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;
	private Set<SpecimenShipmentAirbill> specimenShipmentAirbills = new HashSet<SpecimenShipmentAirbill>(
			0);

	public SpecimenShipment() {
	}

	public SpecimenShipment(BigDecimal shipmentId, String shipmentNo) {
		this.shipmentId = shipmentId;
		this.shipmentNo = shipmentNo;
	}

	public SpecimenShipment(BigDecimal shipmentId,
			SpecimenRequest specimenRequest, Organization organization,
			String shipmentNo, Date shipmentDate, String shipmentTemperature,
			String shipmentStatus, String shipStatus, String comments,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, BigDecimal subsidiaryId,
			Set<SpecimenShipmentAirbill> specimenShipmentAirbills) {
		this.shipmentId = shipmentId;
		this.specimenRequest = specimenRequest;
		this.organization = organization;
		this.shipmentNo = shipmentNo;
		this.shipmentDate = shipmentDate;
		this.shipmentTemperature = shipmentTemperature;
		this.shipmentStatus = shipmentStatus;
		this.shipStatus = shipStatus;
		this.comments = comments;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
		this.specimenShipmentAirbills = specimenShipmentAirbills;
	}

	public BigDecimal getShipmentId() {
		return this.shipmentId;
	}

	public void setShipmentId(BigDecimal shipmentId) {
		this.shipmentId = shipmentId;
	}

	public SpecimenRequest getSpecimenRequest() {
		return this.specimenRequest;
	}

	public void setSpecimenRequest(SpecimenRequest specimenRequest) {
		this.specimenRequest = specimenRequest;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getShipmentNo() {
		return this.shipmentNo;
	}

	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}

	public Date getShipmentDate() {
		return this.shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getShipmentTemperature() {
		return this.shipmentTemperature;
	}

	public void setShipmentTemperature(String shipmentTemperature) {
		this.shipmentTemperature = shipmentTemperature;
	}

	public String getShipmentStatus() {
		return this.shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getShipStatus() {
		return this.shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Set<SpecimenShipmentAirbill> getSpecimenShipmentAirbills() {
		return this.specimenShipmentAirbills;
	}

	public void setSpecimenShipmentAirbills(
			Set<SpecimenShipmentAirbill> specimenShipmentAirbills) {
		this.specimenShipmentAirbills = specimenShipmentAirbills;
	}

}
