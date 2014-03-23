package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * DnaDesRequestId generated by hbm2java
 */
public class DnaDesRequestId implements java.io.Serializable {

	private String requestor;
	private BigDecimal destructionRequestId;

	public DnaDesRequestId() {
	}

	public DnaDesRequestId(BigDecimal destructionRequestId) {
		this.destructionRequestId = destructionRequestId;
	}

	public DnaDesRequestId(String requestor, BigDecimal destructionRequestId) {
		this.requestor = requestor;
		this.destructionRequestId = destructionRequestId;
	}

	public String getRequestor() {
		return this.requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public BigDecimal getDestructionRequestId() {
		return this.destructionRequestId;
	}

	public void setDestructionRequestId(BigDecimal destructionRequestId) {
		this.destructionRequestId = destructionRequestId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DnaDesRequestId))
			return false;
		DnaDesRequestId castOther = (DnaDesRequestId) other;

		return ((this.getRequestor() == castOther.getRequestor()) || (this
				.getRequestor() != null && castOther.getRequestor() != null && this
				.getRequestor().equals(castOther.getRequestor())))
				&& ((this.getDestructionRequestId() == castOther
						.getDestructionRequestId()) || (this
						.getDestructionRequestId() != null
						&& castOther.getDestructionRequestId() != null && this
						.getDestructionRequestId().equals(
								castOther.getDestructionRequestId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRequestor() == null ? 0 : this.getRequestor().hashCode());
		result = 37
				* result
				+ (getDestructionRequestId() == null ? 0 : this
						.getDestructionRequestId().hashCode());
		return result;
	}

}