package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * MakeplateSourceViewId generated by hbm2java
 */
public class MakeplateSourceViewId implements java.io.Serializable {

	private BigDecimal checklistId;
	private String containerId;

	public MakeplateSourceViewId() {
	}

	public MakeplateSourceViewId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public MakeplateSourceViewId(BigDecimal checklistId, String containerId) {
		this.checklistId = checklistId;
		this.containerId = containerId;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MakeplateSourceViewId))
			return false;
		MakeplateSourceViewId castOther = (MakeplateSourceViewId) other;

		return ((this.getChecklistId() == castOther.getChecklistId()) || (this
				.getChecklistId() != null && castOther.getChecklistId() != null && this
				.getChecklistId().equals(castOther.getChecklistId())))
				&& ((this.getContainerId() == castOther.getContainerId()) || (this
						.getContainerId() != null
						&& castOther.getContainerId() != null && this
						.getContainerId().equals(castOther.getContainerId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		return result;
	}

}