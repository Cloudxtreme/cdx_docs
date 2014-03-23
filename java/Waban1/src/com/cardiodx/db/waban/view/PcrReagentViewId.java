package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * PcrReagentViewId generated by hbm2java
 */
public class PcrReagentViewId implements java.io.Serializable {

	private String reagentBarcode;
	private String aspPos;
	private String dispBarcode;
	private String dispPos;
	private BigDecimal reagentId;
	private BigDecimal pcrSetupId;

	public PcrReagentViewId() {
	}

	public PcrReagentViewId(BigDecimal reagentId, BigDecimal pcrSetupId) {
		this.reagentId = reagentId;
		this.pcrSetupId = pcrSetupId;
	}

	public PcrReagentViewId(String reagentBarcode, String aspPos,
			String dispBarcode, String dispPos, BigDecimal reagentId,
			BigDecimal pcrSetupId) {
		this.reagentBarcode = reagentBarcode;
		this.aspPos = aspPos;
		this.dispBarcode = dispBarcode;
		this.dispPos = dispPos;
		this.reagentId = reagentId;
		this.pcrSetupId = pcrSetupId;
	}

	public String getReagentBarcode() {
		return this.reagentBarcode;
	}

	public void setReagentBarcode(String reagentBarcode) {
		this.reagentBarcode = reagentBarcode;
	}

	public String getAspPos() {
		return this.aspPos;
	}

	public void setAspPos(String aspPos) {
		this.aspPos = aspPos;
	}

	public String getDispBarcode() {
		return this.dispBarcode;
	}

	public void setDispBarcode(String dispBarcode) {
		this.dispBarcode = dispBarcode;
	}

	public String getDispPos() {
		return this.dispPos;
	}

	public void setDispPos(String dispPos) {
		this.dispPos = dispPos;
	}

	public BigDecimal getReagentId() {
		return this.reagentId;
	}

	public void setReagentId(BigDecimal reagentId) {
		this.reagentId = reagentId;
	}

	public BigDecimal getPcrSetupId() {
		return this.pcrSetupId;
	}

	public void setPcrSetupId(BigDecimal pcrSetupId) {
		this.pcrSetupId = pcrSetupId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PcrReagentViewId))
			return false;
		PcrReagentViewId castOther = (PcrReagentViewId) other;

		return ((this.getReagentBarcode() == castOther.getReagentBarcode()) || (this
				.getReagentBarcode() != null
				&& castOther.getReagentBarcode() != null && this
				.getReagentBarcode().equals(castOther.getReagentBarcode())))
				&& ((this.getAspPos() == castOther.getAspPos()) || (this
						.getAspPos() != null && castOther.getAspPos() != null && this
						.getAspPos().equals(castOther.getAspPos())))
				&& ((this.getDispBarcode() == castOther.getDispBarcode()) || (this
						.getDispBarcode() != null
						&& castOther.getDispBarcode() != null && this
						.getDispBarcode().equals(castOther.getDispBarcode())))
				&& ((this.getDispPos() == castOther.getDispPos()) || (this
						.getDispPos() != null && castOther.getDispPos() != null && this
						.getDispPos().equals(castOther.getDispPos())))
				&& ((this.getReagentId() == castOther.getReagentId()) || (this
						.getReagentId() != null
						&& castOther.getReagentId() != null && this
						.getReagentId().equals(castOther.getReagentId())))
				&& ((this.getPcrSetupId() == castOther.getPcrSetupId()) || (this
						.getPcrSetupId() != null
						&& castOther.getPcrSetupId() != null && this
						.getPcrSetupId().equals(castOther.getPcrSetupId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getReagentBarcode() == null ? 0 : this.getReagentBarcode()
						.hashCode());
		result = 37 * result
				+ (getAspPos() == null ? 0 : this.getAspPos().hashCode());
		result = 37
				* result
				+ (getDispBarcode() == null ? 0 : this.getDispBarcode()
						.hashCode());
		result = 37 * result
				+ (getDispPos() == null ? 0 : this.getDispPos().hashCode());
		result = 37 * result
				+ (getReagentId() == null ? 0 : this.getReagentId().hashCode());
		result = 37
				* result
				+ (getPcrSetupId() == null ? 0 : this.getPcrSetupId()
						.hashCode());
		return result;
	}

}
