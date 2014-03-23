package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * ContainerFilenameId generated by hbm2java
 */
public class ContainerFilenameId implements java.io.Serializable {

	private String containerId;
	private BigDecimal filenameId;

	public ContainerFilenameId() {
	}

	public ContainerFilenameId(String containerId, BigDecimal filenameId) {
		this.containerId = containerId;
		this.filenameId = filenameId;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public BigDecimal getFilenameId() {
		return this.filenameId;
	}

	public void setFilenameId(BigDecimal filenameId) {
		this.filenameId = filenameId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ContainerFilenameId))
			return false;
		ContainerFilenameId castOther = (ContainerFilenameId) other;

		return ((this.getContainerId() == castOther.getContainerId()) || (this
				.getContainerId() != null && castOther.getContainerId() != null && this
				.getContainerId().equals(castOther.getContainerId())))
				&& ((this.getFilenameId() == castOther.getFilenameId()) || (this
						.getFilenameId() != null
						&& castOther.getFilenameId() != null && this
						.getFilenameId().equals(castOther.getFilenameId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		result = 37
				* result
				+ (getFilenameId() == null ? 0 : this.getFilenameId()
						.hashCode());
		return result;
	}

}