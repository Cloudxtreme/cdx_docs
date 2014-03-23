package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * GeneValueId generated by hbm2java
 */
public class GeneValueId implements java.io.Serializable {

	private BigDecimal geneId;
	private BigDecimal numberInSequence;
	private BigDecimal subsidiaryId;

	public GeneValueId() {
	}

	public GeneValueId(BigDecimal geneId, BigDecimal numberInSequence,
			BigDecimal subsidiaryId) {
		this.geneId = geneId;
		this.numberInSequence = numberInSequence;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getGeneId() {
		return this.geneId;
	}

	public void setGeneId(BigDecimal geneId) {
		this.geneId = geneId;
	}

	public BigDecimal getNumberInSequence() {
		return this.numberInSequence;
	}

	public void setNumberInSequence(BigDecimal numberInSequence) {
		this.numberInSequence = numberInSequence;
	}

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GeneValueId))
			return false;
		GeneValueId castOther = (GeneValueId) other;

		return ((this.getGeneId() == castOther.getGeneId()) || (this
				.getGeneId() != null && castOther.getGeneId() != null && this
				.getGeneId().equals(castOther.getGeneId())))
				&& ((this.getNumberInSequence() == castOther
						.getNumberInSequence()) || (this.getNumberInSequence() != null
						&& castOther.getNumberInSequence() != null && this
						.getNumberInSequence().equals(
								castOther.getNumberInSequence())))
				&& ((this.getSubsidiaryId() == castOther.getSubsidiaryId()) || (this
						.getSubsidiaryId() != null
						&& castOther.getSubsidiaryId() != null && this
						.getSubsidiaryId().equals(castOther.getSubsidiaryId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGeneId() == null ? 0 : this.getGeneId().hashCode());
		result = 37
				* result
				+ (getNumberInSequence() == null ? 0 : this
						.getNumberInSequence().hashCode());
		result = 37
				* result
				+ (getSubsidiaryId() == null ? 0 : this.getSubsidiaryId()
						.hashCode());
		return result;
	}

}
