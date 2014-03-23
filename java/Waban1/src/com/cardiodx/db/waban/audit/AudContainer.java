package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudContainer generated by hbm2java
 */
public class AudContainer implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private String containerId;
	private BigDecimal freezerId;
	private BigDecimal containerMapId;
	private String compartment;
	private String shelf;
	private String rack;
	private String location;
	private String description;
	private String checkoutBy;
	private Date dateCheckout;
	private Boolean discarded;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;
	private String containerCondition;
	private String status;
	private String comments;

	public AudContainer() {
	}

	public AudContainer(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudContainer(BigDecimal auditId, BigDecimal changeReasonId,
			String containerId, BigDecimal freezerId,
			BigDecimal containerMapId, String compartment, String shelf,
			String rack, String location, String description,
			String checkoutBy, Date dateCheckout, Boolean discarded,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, String changedBy, Date dateChanged,
			String changeType, BigDecimal subsidiaryId,
			String containerCondition, String status, String comments) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.containerId = containerId;
		this.freezerId = freezerId;
		this.containerMapId = containerMapId;
		this.compartment = compartment;
		this.shelf = shelf;
		this.rack = rack;
		this.location = location;
		this.description = description;
		this.checkoutBy = checkoutBy;
		this.dateCheckout = dateCheckout;
		this.discarded = discarded;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
		this.subsidiaryId = subsidiaryId;
		this.containerCondition = containerCondition;
		this.status = status;
		this.comments = comments;
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

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public BigDecimal getFreezerId() {
		return this.freezerId;
	}

	public void setFreezerId(BigDecimal freezerId) {
		this.freezerId = freezerId;
	}

	public BigDecimal getContainerMapId() {
		return this.containerMapId;
	}

	public void setContainerMapId(BigDecimal containerMapId) {
		this.containerMapId = containerMapId;
	}

	public String getCompartment() {
		return this.compartment;
	}

	public void setCompartment(String compartment) {
		this.compartment = compartment;
	}

	public String getShelf() {
		return this.shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public String getRack() {
		return this.rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCheckoutBy() {
		return this.checkoutBy;
	}

	public void setCheckoutBy(String checkoutBy) {
		this.checkoutBy = checkoutBy;
	}

	public Date getDateCheckout() {
		return this.dateCheckout;
	}

	public void setDateCheckout(Date dateCheckout) {
		this.dateCheckout = dateCheckout;
	}

	public Boolean getDiscarded() {
		return this.discarded;
	}

	public void setDiscarded(Boolean discarded) {
		this.discarded = discarded;
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

	public String getContainerCondition() {
		return this.containerCondition;
	}

	public void setContainerCondition(String containerCondition) {
		this.containerCondition = containerCondition;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}