package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * PcrRoiCountViewId generated by hbm2java
 */
public class PcrRoiCountViewId implements java.io.Serializable {

	private BigDecimal sampleId;
	private BigDecimal checklistId;
	private String caseId;
	private BigDecimal roiId;
	private BigDecimal accessionId;
	private BigDecimal caseRoiId;
	private BigDecimal testSetupId;
	private BigDecimal roiSelectionId;
	private BigDecimal controlSamp;
	private BigDecimal testAccessionId;
	private BigDecimal ctrlAccessionId;

	public PcrRoiCountViewId() {
	}

	public PcrRoiCountViewId(BigDecimal sampleId, BigDecimal checklistId,
			BigDecimal caseRoiId, BigDecimal roiSelectionId,
			BigDecimal testAccessionId) {
		this.sampleId = sampleId;
		this.checklistId = checklistId;
		this.caseRoiId = caseRoiId;
		this.roiSelectionId = roiSelectionId;
		this.testAccessionId = testAccessionId;
	}

	public PcrRoiCountViewId(BigDecimal sampleId, BigDecimal checklistId,
			String caseId, BigDecimal roiId, BigDecimal accessionId,
			BigDecimal caseRoiId, BigDecimal testSetupId,
			BigDecimal roiSelectionId, BigDecimal controlSamp,
			BigDecimal testAccessionId, BigDecimal ctrlAccessionId) {
		this.sampleId = sampleId;
		this.checklistId = checklistId;
		this.caseId = caseId;
		this.roiId = roiId;
		this.accessionId = accessionId;
		this.caseRoiId = caseRoiId;
		this.testSetupId = testSetupId;
		this.roiSelectionId = roiSelectionId;
		this.controlSamp = controlSamp;
		this.testAccessionId = testAccessionId;
		this.ctrlAccessionId = ctrlAccessionId;
	}

	public BigDecimal getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(BigDecimal sampleId) {
		this.sampleId = sampleId;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public BigDecimal getRoiId() {
		return this.roiId;
	}

	public void setRoiId(BigDecimal roiId) {
		this.roiId = roiId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public BigDecimal getCaseRoiId() {
		return this.caseRoiId;
	}

	public void setCaseRoiId(BigDecimal caseRoiId) {
		this.caseRoiId = caseRoiId;
	}

	public BigDecimal getTestSetupId() {
		return this.testSetupId;
	}

	public void setTestSetupId(BigDecimal testSetupId) {
		this.testSetupId = testSetupId;
	}

	public BigDecimal getRoiSelectionId() {
		return this.roiSelectionId;
	}

	public void setRoiSelectionId(BigDecimal roiSelectionId) {
		this.roiSelectionId = roiSelectionId;
	}

	public BigDecimal getControlSamp() {
		return this.controlSamp;
	}

	public void setControlSamp(BigDecimal controlSamp) {
		this.controlSamp = controlSamp;
	}

	public BigDecimal getTestAccessionId() {
		return this.testAccessionId;
	}

	public void setTestAccessionId(BigDecimal testAccessionId) {
		this.testAccessionId = testAccessionId;
	}

	public BigDecimal getCtrlAccessionId() {
		return this.ctrlAccessionId;
	}

	public void setCtrlAccessionId(BigDecimal ctrlAccessionId) {
		this.ctrlAccessionId = ctrlAccessionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PcrRoiCountViewId))
			return false;
		PcrRoiCountViewId castOther = (PcrRoiCountViewId) other;

		return ((this.getSampleId() == castOther.getSampleId()) || (this
				.getSampleId() != null && castOther.getSampleId() != null && this
				.getSampleId().equals(castOther.getSampleId())))
				&& ((this.getChecklistId() == castOther.getChecklistId()) || (this
						.getChecklistId() != null
						&& castOther.getChecklistId() != null && this
						.getChecklistId().equals(castOther.getChecklistId())))
				&& ((this.getCaseId() == castOther.getCaseId()) || (this
						.getCaseId() != null && castOther.getCaseId() != null && this
						.getCaseId().equals(castOther.getCaseId())))
				&& ((this.getRoiId() == castOther.getRoiId()) || (this
						.getRoiId() != null && castOther.getRoiId() != null && this
						.getRoiId().equals(castOther.getRoiId())))
				&& ((this.getAccessionId() == castOther.getAccessionId()) || (this
						.getAccessionId() != null
						&& castOther.getAccessionId() != null && this
						.getAccessionId().equals(castOther.getAccessionId())))
				&& ((this.getCaseRoiId() == castOther.getCaseRoiId()) || (this
						.getCaseRoiId() != null
						&& castOther.getCaseRoiId() != null && this
						.getCaseRoiId().equals(castOther.getCaseRoiId())))
				&& ((this.getTestSetupId() == castOther.getTestSetupId()) || (this
						.getTestSetupId() != null
						&& castOther.getTestSetupId() != null && this
						.getTestSetupId().equals(castOther.getTestSetupId())))
				&& ((this.getRoiSelectionId() == castOther.getRoiSelectionId()) || (this
						.getRoiSelectionId() != null
						&& castOther.getRoiSelectionId() != null && this
						.getRoiSelectionId().equals(
								castOther.getRoiSelectionId())))
				&& ((this.getControlSamp() == castOther.getControlSamp()) || (this
						.getControlSamp() != null
						&& castOther.getControlSamp() != null && this
						.getControlSamp().equals(castOther.getControlSamp())))
				&& ((this.getTestAccessionId() == castOther
						.getTestAccessionId()) || (this.getTestAccessionId() != null
						&& castOther.getTestAccessionId() != null && this
						.getTestAccessionId().equals(
								castOther.getTestAccessionId())))
				&& ((this.getCtrlAccessionId() == castOther
						.getCtrlAccessionId()) || (this.getCtrlAccessionId() != null
						&& castOther.getCtrlAccessionId() != null && this
						.getCtrlAccessionId().equals(
								castOther.getCtrlAccessionId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSampleId() == null ? 0 : this.getSampleId().hashCode());
		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		result = 37 * result
				+ (getCaseId() == null ? 0 : this.getCaseId().hashCode());
		result = 37 * result
				+ (getRoiId() == null ? 0 : this.getRoiId().hashCode());
		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		result = 37 * result
				+ (getCaseRoiId() == null ? 0 : this.getCaseRoiId().hashCode());
		result = 37
				* result
				+ (getTestSetupId() == null ? 0 : this.getTestSetupId()
						.hashCode());
		result = 37
				* result
				+ (getRoiSelectionId() == null ? 0 : this.getRoiSelectionId()
						.hashCode());
		result = 37
				* result
				+ (getControlSamp() == null ? 0 : this.getControlSamp()
						.hashCode());
		result = 37
				* result
				+ (getTestAccessionId() == null ? 0 : this.getTestAccessionId()
						.hashCode());
		result = 37
				* result
				+ (getCtrlAccessionId() == null ? 0 : this.getCtrlAccessionId()
						.hashCode());
		return result;
	}

}
