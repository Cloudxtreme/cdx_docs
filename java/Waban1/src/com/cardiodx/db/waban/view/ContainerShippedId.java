package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ContainerShippedId generated by hbm2java
 */
public class ContainerShippedId implements java.io.Serializable {

	private Date shippmentDate;
	private String containerId;
	private BigDecimal mtpChecklistId;

	public ContainerShippedId() {
	}

	public ContainerShippedId(BigDecimal mtpChecklistId) {
		this.mtpChecklistId = mtpChecklistId;
	}

	public ContainerShippedId(Date shippmentDate, String containerId,
			BigDecimal mtpChecklistId) {
		this.shippmentDate = shippmentDate;
		this.containerId = containerId;
		this.mtpChecklistId = mtpChecklistId;
	}

	public Date getShippmentDate() {
		return this.shippmentDate;
	}

	public void setShippmentDate(Date shippmentDate) {
		this.shippmentDate = shippmentDate;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public BigDecimal getMtpChecklistId() {
		return this.mtpChecklistId;
	}

	public void setMtpChecklistId(BigDecimal mtpChecklistId) {
		this.mtpChecklistId = mtpChecklistId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ContainerShippedId))
			return false;
		ContainerShippedId castOther = (ContainerShippedId) other;

		return ((this.getShippmentDate() == castOther.getShippmentDate()) || (this
				.getShippmentDate() != null
				&& castOther.getShippmentDate() != null && this
				.getShippmentDate().equals(castOther.getShippmentDate())))
				&& ((this.getContainerId() == castOther.getContainerId()) || (this
						.getContainerId() != null
						&& castOther.getContainerId() != null && this
						.getContainerId().equals(castOther.getContainerId())))
				&& ((this.getMtpChecklistId() == castOther.getMtpChecklistId()) || (this
						.getMtpChecklistId() != null
						&& castOther.getMtpChecklistId() != null && this
						.getMtpChecklistId().equals(
								castOther.getMtpChecklistId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getShippmentDate() == null ? 0 : this.getShippmentDate()
						.hashCode());
		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		result = 37
				* result
				+ (getMtpChecklistId() == null ? 0 : this.getMtpChecklistId()
						.hashCode());
		return result;
	}

}
