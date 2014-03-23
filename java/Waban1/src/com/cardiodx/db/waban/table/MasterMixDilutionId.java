package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * MasterMixDilutionId generated by hbm2java
 */
public class MasterMixDilutionId implements java.io.Serializable {

	private BigDecimal masterMixId;
	private BigDecimal dilutionFactor;

	public MasterMixDilutionId() {
	}

	public MasterMixDilutionId(BigDecimal masterMixId, BigDecimal dilutionFactor) {
		this.masterMixId = masterMixId;
		this.dilutionFactor = dilutionFactor;
	}

	public BigDecimal getMasterMixId() {
		return this.masterMixId;
	}

	public void setMasterMixId(BigDecimal masterMixId) {
		this.masterMixId = masterMixId;
	}

	public BigDecimal getDilutionFactor() {
		return this.dilutionFactor;
	}

	public void setDilutionFactor(BigDecimal dilutionFactor) {
		this.dilutionFactor = dilutionFactor;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MasterMixDilutionId))
			return false;
		MasterMixDilutionId castOther = (MasterMixDilutionId) other;

		return ((this.getMasterMixId() == castOther.getMasterMixId()) || (this
				.getMasterMixId() != null && castOther.getMasterMixId() != null && this
				.getMasterMixId().equals(castOther.getMasterMixId())))
				&& ((this.getDilutionFactor() == castOther.getDilutionFactor()) || (this
						.getDilutionFactor() != null
						&& castOther.getDilutionFactor() != null && this
						.getDilutionFactor().equals(
								castOther.getDilutionFactor())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMasterMixId() == null ? 0 : this.getMasterMixId()
						.hashCode());
		result = 37
				* result
				+ (getDilutionFactor() == null ? 0 : this.getDilutionFactor()
						.hashCode());
		return result;
	}

}