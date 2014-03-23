package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * VariantEntryValidRoiViewId generated by hbm2java
 */
public class VariantEntryValidRoiViewId implements java.io.Serializable {

	private BigDecimal checklistId;
	private String caseId;
	private String roiName;
	private BigDecimal variantId;
	private String analyst;
	private String caseRoiId;

	public VariantEntryValidRoiViewId() {
	}

	public VariantEntryValidRoiViewId(String roiName, BigDecimal variantId,
			String caseRoiId) {
		this.roiName = roiName;
		this.variantId = variantId;
		this.caseRoiId = caseRoiId;
	}

	public VariantEntryValidRoiViewId(BigDecimal checklistId, String caseId,
			String roiName, BigDecimal variantId, String analyst,
			String caseRoiId) {
		this.checklistId = checklistId;
		this.caseId = caseId;
		this.roiName = roiName;
		this.variantId = variantId;
		this.analyst = analyst;
		this.caseRoiId = caseRoiId;
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

	public String getRoiName() {
		return this.roiName;
	}

	public void setRoiName(String roiName) {
		this.roiName = roiName;
	}

	public BigDecimal getVariantId() {
		return this.variantId;
	}

	public void setVariantId(BigDecimal variantId) {
		this.variantId = variantId;
	}

	public String getAnalyst() {
		return this.analyst;
	}

	public void setAnalyst(String analyst) {
		this.analyst = analyst;
	}

	public String getCaseRoiId() {
		return this.caseRoiId;
	}

	public void setCaseRoiId(String caseRoiId) {
		this.caseRoiId = caseRoiId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VariantEntryValidRoiViewId))
			return false;
		VariantEntryValidRoiViewId castOther = (VariantEntryValidRoiViewId) other;

		return ((this.getChecklistId() == castOther.getChecklistId()) || (this
				.getChecklistId() != null && castOther.getChecklistId() != null && this
				.getChecklistId().equals(castOther.getChecklistId())))
				&& ((this.getCaseId() == castOther.getCaseId()) || (this
						.getCaseId() != null && castOther.getCaseId() != null && this
						.getCaseId().equals(castOther.getCaseId())))
				&& ((this.getRoiName() == castOther.getRoiName()) || (this
						.getRoiName() != null && castOther.getRoiName() != null && this
						.getRoiName().equals(castOther.getRoiName())))
				&& ((this.getVariantId() == castOther.getVariantId()) || (this
						.getVariantId() != null
						&& castOther.getVariantId() != null && this
						.getVariantId().equals(castOther.getVariantId())))
				&& ((this.getAnalyst() == castOther.getAnalyst()) || (this
						.getAnalyst() != null && castOther.getAnalyst() != null && this
						.getAnalyst().equals(castOther.getAnalyst())))
				&& ((this.getCaseRoiId() == castOther.getCaseRoiId()) || (this
						.getCaseRoiId() != null
						&& castOther.getCaseRoiId() != null && this
						.getCaseRoiId().equals(castOther.getCaseRoiId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		result = 37 * result
				+ (getCaseId() == null ? 0 : this.getCaseId().hashCode());
		result = 37 * result
				+ (getRoiName() == null ? 0 : this.getRoiName().hashCode());
		result = 37 * result
				+ (getVariantId() == null ? 0 : this.getVariantId().hashCode());
		result = 37 * result
				+ (getAnalyst() == null ? 0 : this.getAnalyst().hashCode());
		result = 37 * result
				+ (getCaseRoiId() == null ? 0 : this.getCaseRoiId().hashCode());
		return result;
	}

}