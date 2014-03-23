package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * GelMarkerId generated by hbm2java
 */
public class GelMarkerId implements java.io.Serializable {

	private String containerId;
	private BigDecimal containerRow;
	private BigDecimal containerColumn;

	public GelMarkerId() {
	}

	public GelMarkerId(String containerId, BigDecimal containerRow,
			BigDecimal containerColumn) {
		this.containerId = containerId;
		this.containerRow = containerRow;
		this.containerColumn = containerColumn;
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
		if (!(other instanceof GelMarkerId))
			return false;
		GelMarkerId castOther = (GelMarkerId) other;

		return ((this.getContainerId() == castOther.getContainerId()) || (this
				.getContainerId() != null && castOther.getContainerId() != null && this
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