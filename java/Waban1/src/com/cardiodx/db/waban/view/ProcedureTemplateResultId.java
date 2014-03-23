package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * ProcedureTemplateResultId generated by hbm2java
 */
public class ProcedureTemplateResultId implements java.io.Serializable {

	private BigDecimal procedureTemplateId;
	private BigDecimal numberInSequence;

	public ProcedureTemplateResultId() {
	}

	public ProcedureTemplateResultId(BigDecimal procedureTemplateId,
			BigDecimal numberInSequence) {
		this.procedureTemplateId = procedureTemplateId;
		this.numberInSequence = numberInSequence;
	}

	public BigDecimal getProcedureTemplateId() {
		return this.procedureTemplateId;
	}

	public void setProcedureTemplateId(BigDecimal procedureTemplateId) {
		this.procedureTemplateId = procedureTemplateId;
	}

	public BigDecimal getNumberInSequence() {
		return this.numberInSequence;
	}

	public void setNumberInSequence(BigDecimal numberInSequence) {
		this.numberInSequence = numberInSequence;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProcedureTemplateResultId))
			return false;
		ProcedureTemplateResultId castOther = (ProcedureTemplateResultId) other;

		return ((this.getProcedureTemplateId() == castOther
				.getProcedureTemplateId()) || (this.getProcedureTemplateId() != null
				&& castOther.getProcedureTemplateId() != null && this
				.getProcedureTemplateId().equals(
						castOther.getProcedureTemplateId())))
				&& ((this.getNumberInSequence() == castOther
						.getNumberInSequence()) || (this.getNumberInSequence() != null
						&& castOther.getNumberInSequence() != null && this
						.getNumberInSequence().equals(
								castOther.getNumberInSequence())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getProcedureTemplateId() == null ? 0 : this
						.getProcedureTemplateId().hashCode());
		result = 37
				* result
				+ (getNumberInSequence() == null ? 0 : this
						.getNumberInSequence().hashCode());
		return result;
	}

}