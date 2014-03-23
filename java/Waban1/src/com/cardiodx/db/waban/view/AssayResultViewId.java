package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AssayResultViewId generated by hbm2java
 */
public class AssayResultViewId implements java.io.Serializable {

	private BigDecimal accessionId;
	private BigDecimal assayResultId;
	private BigDecimal checklistId;
	private BigDecimal sampleId;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;
	private BigDecimal assayResultLoadId;

	public AssayResultViewId() {
	}

	public AssayResultViewId(BigDecimal assayResultId) {
		this.assayResultId = assayResultId;
	}

	public AssayResultViewId(BigDecimal accessionId, BigDecimal assayResultId,
			BigDecimal checklistId, BigDecimal sampleId, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			BigDecimal subsidiaryId, BigDecimal assayResultLoadId) {
		this.accessionId = accessionId;
		this.assayResultId = assayResultId;
		this.checklistId = checklistId;
		this.sampleId = sampleId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
		this.assayResultLoadId = assayResultLoadId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public BigDecimal getAssayResultId() {
		return this.assayResultId;
	}

	public void setAssayResultId(BigDecimal assayResultId) {
		this.assayResultId = assayResultId;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public BigDecimal getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(BigDecimal sampleId) {
		this.sampleId = sampleId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getAssayResultLoadId() {
		return this.assayResultLoadId;
	}

	public void setAssayResultLoadId(BigDecimal assayResultLoadId) {
		this.assayResultLoadId = assayResultLoadId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AssayResultViewId))
			return false;
		AssayResultViewId castOther = (AssayResultViewId) other;

		return ((this.getAccessionId() == castOther.getAccessionId()) || (this
				.getAccessionId() != null && castOther.getAccessionId() != null && this
				.getAccessionId().equals(castOther.getAccessionId())))
				&& ((this.getAssayResultId() == castOther.getAssayResultId()) || (this
						.getAssayResultId() != null
						&& castOther.getAssayResultId() != null && this
						.getAssayResultId()
						.equals(castOther.getAssayResultId())))
				&& ((this.getChecklistId() == castOther.getChecklistId()) || (this
						.getChecklistId() != null
						&& castOther.getChecklistId() != null && this
						.getChecklistId().equals(castOther.getChecklistId())))
				&& ((this.getSampleId() == castOther.getSampleId()) || (this
						.getSampleId() != null
						&& castOther.getSampleId() != null && this
						.getSampleId().equals(castOther.getSampleId())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getModifiedBy() == castOther.getModifiedBy()) || (this
						.getModifiedBy() != null
						&& castOther.getModifiedBy() != null && this
						.getModifiedBy().equals(castOther.getModifiedBy())))
				&& ((this.getDateModified() == castOther.getDateModified()) || (this
						.getDateModified() != null
						&& castOther.getDateModified() != null && this
						.getDateModified().equals(castOther.getDateModified())))
				&& ((this.getSubsidiaryId() == castOther.getSubsidiaryId()) || (this
						.getSubsidiaryId() != null
						&& castOther.getSubsidiaryId() != null && this
						.getSubsidiaryId().equals(castOther.getSubsidiaryId())))
				&& ((this.getAssayResultLoadId() == castOther
						.getAssayResultLoadId()) || (this
						.getAssayResultLoadId() != null
						&& castOther.getAssayResultLoadId() != null && this
						.getAssayResultLoadId().equals(
								castOther.getAssayResultLoadId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		result = 37
				* result
				+ (getAssayResultId() == null ? 0 : this.getAssayResultId()
						.hashCode());
		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		result = 37 * result
				+ (getSampleId() == null ? 0 : this.getSampleId().hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37
				* result
				+ (getModifiedBy() == null ? 0 : this.getModifiedBy()
						.hashCode());
		result = 37
				* result
				+ (getDateModified() == null ? 0 : this.getDateModified()
						.hashCode());
		result = 37
				* result
				+ (getSubsidiaryId() == null ? 0 : this.getSubsidiaryId()
						.hashCode());
		result = 37
				* result
				+ (getAssayResultLoadId() == null ? 0 : this
						.getAssayResultLoadId().hashCode());
		return result;
	}

}