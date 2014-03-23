package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SamplesYearlyViewId generated by hbm2java
 */
public class SamplesYearlyViewId implements java.io.Serializable {

	private String year;
	private BigDecimal totalSamples;

	public SamplesYearlyViewId() {
	}

	public SamplesYearlyViewId(String year, BigDecimal totalSamples) {
		this.year = year;
		this.totalSamples = totalSamples;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public BigDecimal getTotalSamples() {
		return this.totalSamples;
	}

	public void setTotalSamples(BigDecimal totalSamples) {
		this.totalSamples = totalSamples;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SamplesYearlyViewId))
			return false;
		SamplesYearlyViewId castOther = (SamplesYearlyViewId) other;

		return ((this.getYear() == castOther.getYear()) || (this.getYear() != null
				&& castOther.getYear() != null && this.getYear().equals(
				castOther.getYear())))
				&& ((this.getTotalSamples() == castOther.getTotalSamples()) || (this
						.getTotalSamples() != null
						&& castOther.getTotalSamples() != null && this
						.getTotalSamples().equals(castOther.getTotalSamples())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getYear() == null ? 0 : this.getYear().hashCode());
		result = 37
				* result
				+ (getTotalSamples() == null ? 0 : this.getTotalSamples()
						.hashCode());
		return result;
	}

}
