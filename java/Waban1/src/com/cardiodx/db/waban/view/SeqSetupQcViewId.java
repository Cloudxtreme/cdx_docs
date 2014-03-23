package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SeqSetupQcViewId generated by hbm2java
 */
public class SeqSetupQcViewId implements java.io.Serializable {

	private BigDecimal column;
	private String sampleTube;
	private String operation;
	private String data;
	private String lastCol;
	private BigDecimal checklistId;
	private BigDecimal stepTemplateId;

	public SeqSetupQcViewId() {
	}

	public SeqSetupQcViewId(BigDecimal column) {
		this.column = column;
	}

	public SeqSetupQcViewId(BigDecimal column, String sampleTube,
			String operation, String data, String lastCol,
			BigDecimal checklistId, BigDecimal stepTemplateId) {
		this.column = column;
		this.sampleTube = sampleTube;
		this.operation = operation;
		this.data = data;
		this.lastCol = lastCol;
		this.checklistId = checklistId;
		this.stepTemplateId = stepTemplateId;
	}

	public BigDecimal getColumn() {
		return this.column;
	}

	public void setColumn(BigDecimal column) {
		this.column = column;
	}

	public String getSampleTube() {
		return this.sampleTube;
	}

	public void setSampleTube(String sampleTube) {
		this.sampleTube = sampleTube;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLastCol() {
		return this.lastCol;
	}

	public void setLastCol(String lastCol) {
		this.lastCol = lastCol;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public BigDecimal getStepTemplateId() {
		return this.stepTemplateId;
	}

	public void setStepTemplateId(BigDecimal stepTemplateId) {
		this.stepTemplateId = stepTemplateId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SeqSetupQcViewId))
			return false;
		SeqSetupQcViewId castOther = (SeqSetupQcViewId) other;

		return ((this.getColumn() == castOther.getColumn()) || (this
				.getColumn() != null && castOther.getColumn() != null && this
				.getColumn().equals(castOther.getColumn())))
				&& ((this.getSampleTube() == castOther.getSampleTube()) || (this
						.getSampleTube() != null
						&& castOther.getSampleTube() != null && this
						.getSampleTube().equals(castOther.getSampleTube())))
				&& ((this.getOperation() == castOther.getOperation()) || (this
						.getOperation() != null
						&& castOther.getOperation() != null && this
						.getOperation().equals(castOther.getOperation())))
				&& ((this.getData() == castOther.getData()) || (this.getData() != null
						&& castOther.getData() != null && this.getData()
						.equals(castOther.getData())))
				&& ((this.getLastCol() == castOther.getLastCol()) || (this
						.getLastCol() != null && castOther.getLastCol() != null && this
						.getLastCol().equals(castOther.getLastCol())))
				&& ((this.getChecklistId() == castOther.getChecklistId()) || (this
						.getChecklistId() != null
						&& castOther.getChecklistId() != null && this
						.getChecklistId().equals(castOther.getChecklistId())))
				&& ((this.getStepTemplateId() == castOther.getStepTemplateId()) || (this
						.getStepTemplateId() != null
						&& castOther.getStepTemplateId() != null && this
						.getStepTemplateId().equals(
								castOther.getStepTemplateId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getColumn() == null ? 0 : this.getColumn().hashCode());
		result = 37
				* result
				+ (getSampleTube() == null ? 0 : this.getSampleTube()
						.hashCode());
		result = 37 * result
				+ (getOperation() == null ? 0 : this.getOperation().hashCode());
		result = 37 * result
				+ (getData() == null ? 0 : this.getData().hashCode());
		result = 37 * result
				+ (getLastCol() == null ? 0 : this.getLastCol().hashCode());
		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		result = 37
				* result
				+ (getStepTemplateId() == null ? 0 : this.getStepTemplateId()
						.hashCode());
		return result;
	}

}
