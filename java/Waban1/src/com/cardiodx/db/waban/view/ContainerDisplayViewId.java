package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ContainerDisplayViewId generated by hbm2java
 */
public class ContainerDisplayViewId implements java.io.Serializable {

	private String containerId;
	private String purpose;
	private String layout;
	private String containerLocation;
	private BigDecimal freesp;
	private String checklistId;
	private String procedureName;
	private String status;
	private String comments;
	private Character lastCol;
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
	private BigDecimal subsidiaryId;
	private String containerCondition;
	private String type;

	public ContainerDisplayViewId() {
	}

	public ContainerDisplayViewId(String containerId) {
		this.containerId = containerId;
	}

	public ContainerDisplayViewId(String containerId, String purpose,
			String layout, String containerLocation, BigDecimal freesp,
			String checklistId, String procedureName, String status,
			String comments, Character lastCol, BigDecimal freezerId,
			BigDecimal containerMapId, String compartment, String shelf,
			String rack, String location, String description,
			String checkoutBy, Date dateCheckout, Boolean discarded,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, BigDecimal subsidiaryId,
			String containerCondition, String type) {
		this.containerId = containerId;
		this.purpose = purpose;
		this.layout = layout;
		this.containerLocation = containerLocation;
		this.freesp = freesp;
		this.checklistId = checklistId;
		this.procedureName = procedureName;
		this.status = status;
		this.comments = comments;
		this.lastCol = lastCol;
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
		this.subsidiaryId = subsidiaryId;
		this.containerCondition = containerCondition;
		this.type = type;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getLayout() {
		return this.layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getContainerLocation() {
		return this.containerLocation;
	}

	public void setContainerLocation(String containerLocation) {
		this.containerLocation = containerLocation;
	}

	public BigDecimal getFreesp() {
		return this.freesp;
	}

	public void setFreesp(BigDecimal freesp) {
		this.freesp = freesp;
	}

	public String getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(String checklistId) {
		this.checklistId = checklistId;
	}

	public String getProcedureName() {
		return this.procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
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

	public Character getLastCol() {
		return this.lastCol;
	}

	public void setLastCol(Character lastCol) {
		this.lastCol = lastCol;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ContainerDisplayViewId))
			return false;
		ContainerDisplayViewId castOther = (ContainerDisplayViewId) other;

		return ((this.getContainerId() == castOther.getContainerId()) || (this
				.getContainerId() != null && castOther.getContainerId() != null && this
				.getContainerId().equals(castOther.getContainerId())))
				&& ((this.getPurpose() == castOther.getPurpose()) || (this
						.getPurpose() != null && castOther.getPurpose() != null && this
						.getPurpose().equals(castOther.getPurpose())))
				&& ((this.getLayout() == castOther.getLayout()) || (this
						.getLayout() != null && castOther.getLayout() != null && this
						.getLayout().equals(castOther.getLayout())))
				&& ((this.getContainerLocation() == castOther
						.getContainerLocation()) || (this
						.getContainerLocation() != null
						&& castOther.getContainerLocation() != null && this
						.getContainerLocation().equals(
								castOther.getContainerLocation())))
				&& ((this.getFreesp() == castOther.getFreesp()) || (this
						.getFreesp() != null && castOther.getFreesp() != null && this
						.getFreesp().equals(castOther.getFreesp())))
				&& ((this.getChecklistId() == castOther.getChecklistId()) || (this
						.getChecklistId() != null
						&& castOther.getChecklistId() != null && this
						.getChecklistId().equals(castOther.getChecklistId())))
				&& ((this.getProcedureName() == castOther.getProcedureName()) || (this
						.getProcedureName() != null
						&& castOther.getProcedureName() != null && this
						.getProcedureName()
						.equals(castOther.getProcedureName())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())))
				&& ((this.getComments() == castOther.getComments()) || (this
						.getComments() != null
						&& castOther.getComments() != null && this
						.getComments().equals(castOther.getComments())))
				&& ((this.getLastCol() == castOther.getLastCol()) || (this
						.getLastCol() != null && castOther.getLastCol() != null && this
						.getLastCol().equals(castOther.getLastCol())))
				&& ((this.getFreezerId() == castOther.getFreezerId()) || (this
						.getFreezerId() != null
						&& castOther.getFreezerId() != null && this
						.getFreezerId().equals(castOther.getFreezerId())))
				&& ((this.getContainerMapId() == castOther.getContainerMapId()) || (this
						.getContainerMapId() != null
						&& castOther.getContainerMapId() != null && this
						.getContainerMapId().equals(
								castOther.getContainerMapId())))
				&& ((this.getCompartment() == castOther.getCompartment()) || (this
						.getCompartment() != null
						&& castOther.getCompartment() != null && this
						.getCompartment().equals(castOther.getCompartment())))
				&& ((this.getShelf() == castOther.getShelf()) || (this
						.getShelf() != null && castOther.getShelf() != null && this
						.getShelf().equals(castOther.getShelf())))
				&& ((this.getRack() == castOther.getRack()) || (this.getRack() != null
						&& castOther.getRack() != null && this.getRack()
						.equals(castOther.getRack())))
				&& ((this.getLocation() == castOther.getLocation()) || (this
						.getLocation() != null
						&& castOther.getLocation() != null && this
						.getLocation().equals(castOther.getLocation())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())))
				&& ((this.getCheckoutBy() == castOther.getCheckoutBy()) || (this
						.getCheckoutBy() != null
						&& castOther.getCheckoutBy() != null && this
						.getCheckoutBy().equals(castOther.getCheckoutBy())))
				&& ((this.getDateCheckout() == castOther.getDateCheckout()) || (this
						.getDateCheckout() != null
						&& castOther.getDateCheckout() != null && this
						.getDateCheckout().equals(castOther.getDateCheckout())))
				&& ((this.getDiscarded() == castOther.getDiscarded()) || (this
						.getDiscarded() != null
						&& castOther.getDiscarded() != null && this
						.getDiscarded().equals(castOther.getDiscarded())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getModifiedBy() == castOther.getModifiedBy()) || (this
						.getModifiedBy() != null
						&& castOther.getModifiedBy() != null && this
						.getModifiedBy().equals(castOther.getModifiedBy())))
				&& ((this.getDateModified() == castOther.getDateModified()) || (this
						.getDateModified() != null
						&& castOther.getDateModified() != null && this
						.getDateModified().equals(castOther.getDateModified())))
				&& ((this.getSubsidiaryId() == castOther.getSubsidiaryId()) || (this
						.getSubsidiaryId() != null
						&& castOther.getSubsidiaryId() != null && this
						.getSubsidiaryId().equals(castOther.getSubsidiaryId())))
				&& ((this.getContainerCondition() == castOther
						.getContainerCondition()) || (this
						.getContainerCondition() != null
						&& castOther.getContainerCondition() != null && this
						.getContainerCondition().equals(
								castOther.getContainerCondition())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		result = 37 * result
				+ (getPurpose() == null ? 0 : this.getPurpose().hashCode());
		result = 37 * result
				+ (getLayout() == null ? 0 : this.getLayout().hashCode());
		result = 37
				* result
				+ (getContainerLocation() == null ? 0 : this
						.getContainerLocation().hashCode());
		result = 37 * result
				+ (getFreesp() == null ? 0 : this.getFreesp().hashCode());
		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		result = 37
				* result
				+ (getProcedureName() == null ? 0 : this.getProcedureName()
						.hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37 * result
				+ (getComments() == null ? 0 : this.getComments().hashCode());
		result = 37 * result
				+ (getLastCol() == null ? 0 : this.getLastCol().hashCode());
		result = 37 * result
				+ (getFreezerId() == null ? 0 : this.getFreezerId().hashCode());
		result = 37
				* result
				+ (getContainerMapId() == null ? 0 : this.getContainerMapId()
						.hashCode());
		result = 37
				* result
				+ (getCompartment() == null ? 0 : this.getCompartment()
						.hashCode());
		result = 37 * result
				+ (getShelf() == null ? 0 : this.getShelf().hashCode());
		result = 37 * result
				+ (getRack() == null ? 0 : this.getRack().hashCode());
		result = 37 * result
				+ (getLocation() == null ? 0 : this.getLocation().hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		result = 37
				* result
				+ (getCheckoutBy() == null ? 0 : this.getCheckoutBy()
						.hashCode());
		result = 37
				* result
				+ (getDateCheckout() == null ? 0 : this.getDateCheckout()
						.hashCode());
		result = 37 * result
				+ (getDiscarded() == null ? 0 : this.getDiscarded().hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37
				* result
				+ (getModifiedBy() == null ? 0 : this.getModifiedBy()
						.hashCode());
		result = 37
				* result
				+ (getDateModified() == null ? 0 : this.getDateModified()
						.hashCode());
		result = 37
				* result
				+ (getSubsidiaryId() == null ? 0 : this.getSubsidiaryId()
						.hashCode());
		result = 37
				* result
				+ (getContainerCondition() == null ? 0 : this
						.getContainerCondition().hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		return result;
	}

}
