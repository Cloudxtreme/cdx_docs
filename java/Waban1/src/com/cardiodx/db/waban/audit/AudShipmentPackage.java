package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudShipmentPackage generated by hbm2java
 */
public class AudShipmentPackage implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal shipmentPackageId;
	private BigDecimal shipmentAirbillId;
	private String packageNo;
	private BigDecimal actualSpecimen;
	private String packageCondition;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudShipmentPackage() {
	}

	public AudShipmentPackage(BigDecimal auditId, BigDecimal shipmentPackageId) {
		this.auditId = auditId;
		this.shipmentPackageId = shipmentPackageId;
	}

	public AudShipmentPackage(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal shipmentPackageId, BigDecimal shipmentAirbillId,
			String packageNo, BigDecimal actualSpecimen,
			String packageCondition, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified, String changedBy,
			Date dateChanged, String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.shipmentPackageId = shipmentPackageId;
		this.shipmentAirbillId = shipmentAirbillId;
		this.packageNo = packageNo;
		this.actualSpecimen = actualSpecimen;
		this.packageCondition = packageCondition;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
		this.subsidiaryId = subsidiaryId;
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

	public BigDecimal getShipmentPackageId() {
		return this.shipmentPackageId;
	}

	public void setShipmentPackageId(BigDecimal shipmentPackageId) {
		this.shipmentPackageId = shipmentPackageId;
	}

	public BigDecimal getShipmentAirbillId() {
		return this.shipmentAirbillId;
	}

	public void setShipmentAirbillId(BigDecimal shipmentAirbillId) {
		this.shipmentAirbillId = shipmentAirbillId;
	}

	public String getPackageNo() {
		return this.packageNo;
	}

	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}

	public BigDecimal getActualSpecimen() {
		return this.actualSpecimen;
	}

	public void setActualSpecimen(BigDecimal actualSpecimen) {
		this.actualSpecimen = actualSpecimen;
	}

	public String getPackageCondition() {
		return this.packageCondition;
	}

	public void setPackageCondition(String packageCondition) {
		this.packageCondition = packageCondition;
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

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

}
