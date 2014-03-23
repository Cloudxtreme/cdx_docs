package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * OligoTrackingMixtureViewId generated by hbm2java
 */
public class OligoTrackingMixtureViewId implements java.io.Serializable {

	private BigDecimal oligoId;
	private String mixture;
	private String oligoName;
	private String oligoType;
	private BigDecimal volume;
	private BigDecimal oligoMixtureId;

	public OligoTrackingMixtureViewId() {
	}

	public OligoTrackingMixtureViewId(BigDecimal oligoId, String oligoName) {
		this.oligoId = oligoId;
		this.oligoName = oligoName;
	}

	public OligoTrackingMixtureViewId(BigDecimal oligoId, String mixture,
			String oligoName, String oligoType, BigDecimal volume,
			BigDecimal oligoMixtureId) {
		this.oligoId = oligoId;
		this.mixture = mixture;
		this.oligoName = oligoName;
		this.oligoType = oligoType;
		this.volume = volume;
		this.oligoMixtureId = oligoMixtureId;
	}

	public BigDecimal getOligoId() {
		return this.oligoId;
	}

	public void setOligoId(BigDecimal oligoId) {
		this.oligoId = oligoId;
	}

	public String getMixture() {
		return this.mixture;
	}

	public void setMixture(String mixture) {
		this.mixture = mixture;
	}

	public String getOligoName() {
		return this.oligoName;
	}

	public void setOligoName(String oligoName) {
		this.oligoName = oligoName;
	}

	public String getOligoType() {
		return this.oligoType;
	}

	public void setOligoType(String oligoType) {
		this.oligoType = oligoType;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getOligoMixtureId() {
		return this.oligoMixtureId;
	}

	public void setOligoMixtureId(BigDecimal oligoMixtureId) {
		this.oligoMixtureId = oligoMixtureId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OligoTrackingMixtureViewId))
			return false;
		OligoTrackingMixtureViewId castOther = (OligoTrackingMixtureViewId) other;

		return ((this.getOligoId() == castOther.getOligoId()) || (this
				.getOligoId() != null && castOther.getOligoId() != null && this
				.getOligoId().equals(castOther.getOligoId())))
				&& ((this.getMixture() == castOther.getMixture()) || (this
						.getMixture() != null && castOther.getMixture() != null && this
						.getMixture().equals(castOther.getMixture())))
				&& ((this.getOligoName() == castOther.getOligoName()) || (this
						.getOligoName() != null
						&& castOther.getOligoName() != null && this
						.getOligoName().equals(castOther.getOligoName())))
				&& ((this.getOligoType() == castOther.getOligoType()) || (this
						.getOligoType() != null
						&& castOther.getOligoType() != null && this
						.getOligoType().equals(castOther.getOligoType())))
				&& ((this.getVolume() == castOther.getVolume()) || (this
						.getVolume() != null && castOther.getVolume() != null && this
						.getVolume().equals(castOther.getVolume())))
				&& ((this.getOligoMixtureId() == castOther.getOligoMixtureId()) || (this
						.getOligoMixtureId() != null
						&& castOther.getOligoMixtureId() != null && this
						.getOligoMixtureId().equals(
								castOther.getOligoMixtureId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOligoId() == null ? 0 : this.getOligoId().hashCode());
		result = 37 * result
				+ (getMixture() == null ? 0 : this.getMixture().hashCode());
		result = 37 * result
				+ (getOligoName() == null ? 0 : this.getOligoName().hashCode());
		result = 37 * result
				+ (getOligoType() == null ? 0 : this.getOligoType().hashCode());
		result = 37 * result
				+ (getVolume() == null ? 0 : this.getVolume().hashCode());
		result = 37
				* result
				+ (getOligoMixtureId() == null ? 0 : this.getOligoMixtureId()
						.hashCode());
		return result;
	}

}