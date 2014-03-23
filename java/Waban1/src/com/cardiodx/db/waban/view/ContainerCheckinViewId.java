package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * ContainerCheckinViewId generated by hbm2java
 */
public class ContainerCheckinViewId implements java.io.Serializable {

	private String containerId;
	private String lab;
	private String freezer;
	private String shelf;
	private String rack;
	private String compartment;
	private Character lastCol;
	private String checkoutBy;
	private BigDecimal checklistId;
	private BigDecimal checklistRow;

	public ContainerCheckinViewId() {
	}

	public ContainerCheckinViewId(String containerId, String lab,
			String freezer, String shelf, String rack, String compartment,
			Character lastCol, String checkoutBy, BigDecimal checklistId,
			BigDecimal checklistRow) {
		this.containerId = containerId;
		this.lab = lab;
		this.freezer = freezer;
		this.shelf = shelf;
		this.rack = rack;
		this.compartment = compartment;
		this.lastCol = lastCol;
		this.checkoutBy = checkoutBy;
		this.checklistId = checklistId;
		this.checklistRow = checklistRow;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public String getLab() {
		return this.lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public String getFreezer() {
		return this.freezer;
	}

	public void setFreezer(String freezer) {
		this.freezer = freezer;
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

	public String getCompartment() {
		return this.compartment;
	}

	public void setCompartment(String compartment) {
		this.compartment = compartment;
	}

	public Character getLastCol() {
		return this.lastCol;
	}

	public void setLastCol(Character lastCol) {
		this.lastCol = lastCol;
	}

	public String getCheckoutBy() {
		return this.checkoutBy;
	}

	public void setCheckoutBy(String checkoutBy) {
		this.checkoutBy = checkoutBy;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public BigDecimal getChecklistRow() {
		return this.checklistRow;
	}

	public void setChecklistRow(BigDecimal checklistRow) {
		this.checklistRow = checklistRow;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ContainerCheckinViewId))
			return false;
		ContainerCheckinViewId castOther = (ContainerCheckinViewId) other;

		return ((this.getContainerId() == castOther.getContainerId()) || (this
				.getContainerId() != null && castOther.getContainerId() != null && this
				.getContainerId().equals(castOther.getContainerId())))
				&& ((this.getLab() == castOther.getLab()) || (this.getLab() != null
						&& castOther.getLab() != null && this.getLab().equals(
						castOther.getLab())))
				&& ((this.getFreezer() == castOther.getFreezer()) || (this
						.getFreezer() != null && castOther.getFreezer() != null && this
						.getFreezer().equals(castOther.getFreezer())))
				&& ((this.getShelf() == castOther.getShelf()) || (this
						.getShelf() != null && castOther.getShelf() != null && this
						.getShelf().equals(castOther.getShelf())))
				&& ((this.getRack() == castOther.getRack()) || (this.getRack() != null
						&& castOther.getRack() != null && this.getRack()
						.equals(castOther.getRack())))
				&& ((this.getCompartment() == castOther.getCompartment()) || (this
						.getCompartment() != null
						&& castOther.getCompartment() != null && this
						.getCompartment().equals(castOther.getCompartment())))
				&& ((this.getLastCol() == castOther.getLastCol()) || (this
						.getLastCol() != null && castOther.getLastCol() != null && this
						.getLastCol().equals(castOther.getLastCol())))
				&& ((this.getCheckoutBy() == castOther.getCheckoutBy()) || (this
						.getCheckoutBy() != null
						&& castOther.getCheckoutBy() != null && this
						.getCheckoutBy().equals(castOther.getCheckoutBy())))
				&& ((this.getChecklistId() == castOther.getChecklistId()) || (this
						.getChecklistId() != null
						&& castOther.getChecklistId() != null && this
						.getChecklistId().equals(castOther.getChecklistId())))
				&& ((this.getChecklistRow() == castOther.getChecklistRow()) || (this
						.getChecklistRow() != null
						&& castOther.getChecklistRow() != null && this
						.getChecklistRow().equals(castOther.getChecklistRow())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		result = 37 * result
				+ (getLab() == null ? 0 : this.getLab().hashCode());
		result = 37 * result
				+ (getFreezer() == null ? 0 : this.getFreezer().hashCode());
		result = 37 * result
				+ (getShelf() == null ? 0 : this.getShelf().hashCode());
		result = 37 * result
				+ (getRack() == null ? 0 : this.getRack().hashCode());
		result = 37
				* result
				+ (getCompartment() == null ? 0 : this.getCompartment()
						.hashCode());
		result = 37 * result
				+ (getLastCol() == null ? 0 : this.getLastCol().hashCode());
		result = 37
				* result
				+ (getCheckoutBy() == null ? 0 : this.getCheckoutBy()
						.hashCode());
		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		result = 37
				* result
				+ (getChecklistRow() == null ? 0 : this.getChecklistRow()
						.hashCode());
		return result;
	}

}
