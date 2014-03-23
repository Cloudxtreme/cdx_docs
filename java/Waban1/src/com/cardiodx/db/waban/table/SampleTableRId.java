package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SampleTableRId generated by hbm2java
 */
public class SampleTableRId implements java.io.Serializable {

	private BigDecimal parentId;
	private BigDecimal childId;

	public SampleTableRId() {
	}

	public SampleTableRId(BigDecimal parentId, BigDecimal childId) {
		this.parentId = parentId;
		this.childId = childId;
	}

	public BigDecimal getParentId() {
		return this.parentId;
	}

	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
	}

	public BigDecimal getChildId() {
		return this.childId;
	}

	public void setChildId(BigDecimal childId) {
		this.childId = childId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SampleTableRId))
			return false;
		SampleTableRId castOther = (SampleTableRId) other;

		return ((this.getParentId() == castOther.getParentId()) || (this
				.getParentId() != null && castOther.getParentId() != null && this
				.getParentId().equals(castOther.getParentId())))
				&& ((this.getChildId() == castOther.getChildId()) || (this
						.getChildId() != null && castOther.getChildId() != null && this
						.getChildId().equals(castOther.getChildId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getParentId() == null ? 0 : this.getParentId().hashCode());
		result = 37 * result
				+ (getChildId() == null ? 0 : this.getChildId().hashCode());
		return result;
	}

}
