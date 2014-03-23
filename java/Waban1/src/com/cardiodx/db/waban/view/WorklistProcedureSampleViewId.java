package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * WorklistProcedureSampleViewId generated by hbm2java
 */
public class WorklistProcedureSampleViewId implements java.io.Serializable {

	private BigDecimal origSampleId;
	private BigDecimal accessionId;
	private BigDecimal sampleId;
	private String containerId;
	private BigDecimal containerRow;
	private BigDecimal containerColumn;
	private String sampleTubeId;
	private BigDecimal hasHistory;
	private Character status;
	private BigDecimal worklistId;
	private String accessionNumber;

	public WorklistProcedureSampleViewId() {
	}

	public WorklistProcedureSampleViewId(BigDecimal origSampleId,
			BigDecimal sampleId, BigDecimal worklistId, String accessionNumber) {
		this.origSampleId = origSampleId;
		this.sampleId = sampleId;
		this.worklistId = worklistId;
		this.accessionNumber = accessionNumber;
	}

	public WorklistProcedureSampleViewId(BigDecimal origSampleId,
			BigDecimal accessionId, BigDecimal sampleId, String containerId,
			BigDecimal containerRow, BigDecimal containerColumn,
			String sampleTubeId, BigDecimal hasHistory, Character status,
			BigDecimal worklistId, String accessionNumber) {
		this.origSampleId = origSampleId;
		this.accessionId = accessionId;
		this.sampleId = sampleId;
		this.containerId = containerId;
		this.containerRow = containerRow;
		this.containerColumn = containerColumn;
		this.sampleTubeId = sampleTubeId;
		this.hasHistory = hasHistory;
		this.status = status;
		this.worklistId = worklistId;
		this.accessionNumber = accessionNumber;
	}

	public BigDecimal getOrigSampleId() {
		return this.origSampleId;
	}

	public void setOrigSampleId(BigDecimal origSampleId) {
		this.origSampleId = origSampleId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public BigDecimal getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(BigDecimal sampleId) {
		this.sampleId = sampleId;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public BigDecimal getContainerRow() {
		return this.containerRow;
	}

	public void setContainerRow(BigDecimal containerRow) {
		this.containerRow = containerRow;
	}

	public BigDecimal getContainerColumn() {
		return this.containerColumn;
	}

	public void setContainerColumn(BigDecimal containerColumn) {
		this.containerColumn = containerColumn;
	}

	public String getSampleTubeId() {
		return this.sampleTubeId;
	}

	public void setSampleTubeId(String sampleTubeId) {
		this.sampleTubeId = sampleTubeId;
	}

	public BigDecimal getHasHistory() {
		return this.hasHistory;
	}

	public void setHasHistory(BigDecimal hasHistory) {
		this.hasHistory = hasHistory;
	}

	public Character getStatus() {
		return this.status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public BigDecimal getWorklistId() {
		return this.worklistId;
	}

	public void setWorklistId(BigDecimal worklistId) {
		this.worklistId = worklistId;
	}

	public String getAccessionNumber() {
		return this.accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WorklistProcedureSampleViewId))
			return false;
		WorklistProcedureSampleViewId castOther = (WorklistProcedureSampleViewId) other;

		return ((this.getOrigSampleId() == castOther.getOrigSampleId()) || (this
				.getOrigSampleId() != null
				&& castOther.getOrigSampleId() != null && this
				.getOrigSampleId().equals(castOther.getOrigSampleId())))
				&& ((this.getAccessionId() == castOther.getAccessionId()) || (this
						.getAccessionId() != null
						&& castOther.getAccessionId() != null && this
						.getAccessionId().equals(castOther.getAccessionId())))
				&& ((this.getSampleId() == castOther.getSampleId()) || (this
						.getSampleId() != null
						&& castOther.getSampleId() != null && this
						.getSampleId().equals(castOther.getSampleId())))
				&& ((this.getContainerId() == castOther.getContainerId()) || (this
						.getContainerId() != null
						&& castOther.getContainerId() != null && this
						.getContainerId().equals(castOther.getContainerId())))
				&& ((this.getContainerRow() == castOther.getContainerRow()) || (this
						.getContainerRow() != null
						&& castOther.getContainerRow() != null && this
						.getContainerRow().equals(castOther.getContainerRow())))
				&& ((this.getContainerColumn() == castOther
						.getContainerColumn()) || (this.getContainerColumn() != null
						&& castOther.getContainerColumn() != null && this
						.getContainerColumn().equals(
								castOther.getContainerColumn())))
				&& ((this.getSampleTubeId() == castOther.getSampleTubeId()) || (this
						.getSampleTubeId() != null
						&& castOther.getSampleTubeId() != null && this
						.getSampleTubeId().equals(castOther.getSampleTubeId())))
				&& ((this.getHasHistory() == castOther.getHasHistory()) || (this
						.getHasHistory() != null
						&& castOther.getHasHistory() != null && this
						.getHasHistory().equals(castOther.getHasHistory())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())))
				&& ((this.getWorklistId() == castOther.getWorklistId()) || (this
						.getWorklistId() != null
						&& castOther.getWorklistId() != null && this
						.getWorklistId().equals(castOther.getWorklistId())))
				&& ((this.getAccessionNumber() == castOther
						.getAccessionNumber()) || (this.getAccessionNumber() != null
						&& castOther.getAccessionNumber() != null && this
						.getAccessionNumber().equals(
								castOther.getAccessionNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getOrigSampleId() == null ? 0 : this.getOrigSampleId()
						.hashCode());
		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		result = 37 * result
				+ (getSampleId() == null ? 0 : this.getSampleId().hashCode());
		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		result = 37
				* result
				+ (getContainerRow() == null ? 0 : this.getContainerRow()
						.hashCode());
		result = 37
				* result
				+ (getContainerColumn() == null ? 0 : this.getContainerColumn()
						.hashCode());
		result = 37
				* result
				+ (getSampleTubeId() == null ? 0 : this.getSampleTubeId()
						.hashCode());
		result = 37
				* result
				+ (getHasHistory() == null ? 0 : this.getHasHistory()
						.hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37
				* result
				+ (getWorklistId() == null ? 0 : this.getWorklistId()
						.hashCode());
		result = 37
				* result
				+ (getAccessionNumber() == null ? 0 : this.getAccessionNumber()
						.hashCode());
		return result;
	}

}
