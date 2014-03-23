package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * StaarAssayResultViewId generated by hbm2java
 */
public class StaarAssayResultViewId implements java.io.Serializable {

	private BigDecimal geneId;
	private BigDecimal alleleId;
	private BigDecimal alleleResultId;
	private String procedureName;
	private String sopVersion;
	private String assResult;
	private String assStatus;
	private BigDecimal checklistId;
	private BigDecimal sampleId;
	private String sampleTubeId;
	private String comments;
	private BigDecimal assayResultId;
	private String location;
	private String assWho;
	private Date assWhen;
	private String createdBy;
	private Date dateCreated;
	private String lasttube;
	private BigDecimal accessionId;

	public StaarAssayResultViewId() {
	}

	public StaarAssayResultViewId(BigDecimal geneId, BigDecimal alleleId,
			BigDecimal alleleResultId, BigDecimal sampleId,
			BigDecimal assayResultId, BigDecimal accessionId) {
		this.geneId = geneId;
		this.alleleId = alleleId;
		this.alleleResultId = alleleResultId;
		this.sampleId = sampleId;
		this.assayResultId = assayResultId;
		this.accessionId = accessionId;
	}

	public StaarAssayResultViewId(BigDecimal geneId, BigDecimal alleleId,
			BigDecimal alleleResultId, String procedureName, String sopVersion,
			String assResult, String assStatus, BigDecimal checklistId,
			BigDecimal sampleId, String sampleTubeId, String comments,
			BigDecimal assayResultId, String location, String assWho,
			Date assWhen, String createdBy, Date dateCreated, String lasttube,
			BigDecimal accessionId) {
		this.geneId = geneId;
		this.alleleId = alleleId;
		this.alleleResultId = alleleResultId;
		this.procedureName = procedureName;
		this.sopVersion = sopVersion;
		this.assResult = assResult;
		this.assStatus = assStatus;
		this.checklistId = checklistId;
		this.sampleId = sampleId;
		this.sampleTubeId = sampleTubeId;
		this.comments = comments;
		this.assayResultId = assayResultId;
		this.location = location;
		this.assWho = assWho;
		this.assWhen = assWhen;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lasttube = lasttube;
		this.accessionId = accessionId;
	}

	public BigDecimal getGeneId() {
		return this.geneId;
	}

	public void setGeneId(BigDecimal geneId) {
		this.geneId = geneId;
	}

	public BigDecimal getAlleleId() {
		return this.alleleId;
	}

	public void setAlleleId(BigDecimal alleleId) {
		this.alleleId = alleleId;
	}

	public BigDecimal getAlleleResultId() {
		return this.alleleResultId;
	}

	public void setAlleleResultId(BigDecimal alleleResultId) {
		this.alleleResultId = alleleResultId;
	}

	public String getProcedureName() {
		return this.procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getSopVersion() {
		return this.sopVersion;
	}

	public void setSopVersion(String sopVersion) {
		this.sopVersion = sopVersion;
	}

	public String getAssResult() {
		return this.assResult;
	}

	public void setAssResult(String assResult) {
		this.assResult = assResult;
	}

	public String getAssStatus() {
		return this.assStatus;
	}

	public void setAssStatus(String assStatus) {
		this.assStatus = assStatus;
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

	public String getSampleTubeId() {
		return this.sampleTubeId;
	}

	public void setSampleTubeId(String sampleTubeId) {
		this.sampleTubeId = sampleTubeId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigDecimal getAssayResultId() {
		return this.assayResultId;
	}

	public void setAssayResultId(BigDecimal assayResultId) {
		this.assayResultId = assayResultId;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAssWho() {
		return this.assWho;
	}

	public void setAssWho(String assWho) {
		this.assWho = assWho;
	}

	public Date getAssWhen() {
		return this.assWhen;
	}

	public void setAssWhen(Date assWhen) {
		this.assWhen = assWhen;
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

	public String getLasttube() {
		return this.lasttube;
	}

	public void setLasttube(String lasttube) {
		this.lasttube = lasttube;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StaarAssayResultViewId))
			return false;
		StaarAssayResultViewId castOther = (StaarAssayResultViewId) other;

		return ((this.getGeneId() == castOther.getGeneId()) || (this
				.getGeneId() != null && castOther.getGeneId() != null && this
				.getGeneId().equals(castOther.getGeneId())))
				&& ((this.getAlleleId() == castOther.getAlleleId()) || (this
						.getAlleleId() != null
						&& castOther.getAlleleId() != null && this
						.getAlleleId().equals(castOther.getAlleleId())))
				&& ((this.getAlleleResultId() == castOther.getAlleleResultId()) || (this
						.getAlleleResultId() != null
						&& castOther.getAlleleResultId() != null && this
						.getAlleleResultId().equals(
								castOther.getAlleleResultId())))
				&& ((this.getProcedureName() == castOther.getProcedureName()) || (this
						.getProcedureName() != null
						&& castOther.getProcedureName() != null && this
						.getProcedureName()
						.equals(castOther.getProcedureName())))
				&& ((this.getSopVersion() == castOther.getSopVersion()) || (this
						.getSopVersion() != null
						&& castOther.getSopVersion() != null && this
						.getSopVersion().equals(castOther.getSopVersion())))
				&& ((this.getAssResult() == castOther.getAssResult()) || (this
						.getAssResult() != null
						&& castOther.getAssResult() != null && this
						.getAssResult().equals(castOther.getAssResult())))
				&& ((this.getAssStatus() == castOther.getAssStatus()) || (this
						.getAssStatus() != null
						&& castOther.getAssStatus() != null && this
						.getAssStatus().equals(castOther.getAssStatus())))
				&& ((this.getChecklistId() == castOther.getChecklistId()) || (this
						.getChecklistId() != null
						&& castOther.getChecklistId() != null && this
						.getChecklistId().equals(castOther.getChecklistId())))
				&& ((this.getSampleId() == castOther.getSampleId()) || (this
						.getSampleId() != null
						&& castOther.getSampleId() != null && this
						.getSampleId().equals(castOther.getSampleId())))
				&& ((this.getSampleTubeId() == castOther.getSampleTubeId()) || (this
						.getSampleTubeId() != null
						&& castOther.getSampleTubeId() != null && this
						.getSampleTubeId().equals(castOther.getSampleTubeId())))
				&& ((this.getComments() == castOther.getComments()) || (this
						.getComments() != null
						&& castOther.getComments() != null && this
						.getComments().equals(castOther.getComments())))
				&& ((this.getAssayResultId() == castOther.getAssayResultId()) || (this
						.getAssayResultId() != null
						&& castOther.getAssayResultId() != null && this
						.getAssayResultId()
						.equals(castOther.getAssayResultId())))
				&& ((this.getLocation() == castOther.getLocation()) || (this
						.getLocation() != null
						&& castOther.getLocation() != null && this
						.getLocation().equals(castOther.getLocation())))
				&& ((this.getAssWho() == castOther.getAssWho()) || (this
						.getAssWho() != null && castOther.getAssWho() != null && this
						.getAssWho().equals(castOther.getAssWho())))
				&& ((this.getAssWhen() == castOther.getAssWhen()) || (this
						.getAssWhen() != null && castOther.getAssWhen() != null && this
						.getAssWhen().equals(castOther.getAssWhen())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getLasttube() == castOther.getLasttube()) || (this
						.getLasttube() != null
						&& castOther.getLasttube() != null && this
						.getLasttube().equals(castOther.getLasttube())))
				&& ((this.getAccessionId() == castOther.getAccessionId()) || (this
						.getAccessionId() != null
						&& castOther.getAccessionId() != null && this
						.getAccessionId().equals(castOther.getAccessionId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGeneId() == null ? 0 : this.getGeneId().hashCode());
		result = 37 * result
				+ (getAlleleId() == null ? 0 : this.getAlleleId().hashCode());
		result = 37
				* result
				+ (getAlleleResultId() == null ? 0 : this.getAlleleResultId()
						.hashCode());
		result = 37
				* result
				+ (getProcedureName() == null ? 0 : this.getProcedureName()
						.hashCode());
		result = 37
				* result
				+ (getSopVersion() == null ? 0 : this.getSopVersion()
						.hashCode());
		result = 37 * result
				+ (getAssResult() == null ? 0 : this.getAssResult().hashCode());
		result = 37 * result
				+ (getAssStatus() == null ? 0 : this.getAssStatus().hashCode());
		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		result = 37 * result
				+ (getSampleId() == null ? 0 : this.getSampleId().hashCode());
		result = 37
				* result
				+ (getSampleTubeId() == null ? 0 : this.getSampleTubeId()
						.hashCode());
		result = 37 * result
				+ (getComments() == null ? 0 : this.getComments().hashCode());
		result = 37
				* result
				+ (getAssayResultId() == null ? 0 : this.getAssayResultId()
						.hashCode());
		result = 37 * result
				+ (getLocation() == null ? 0 : this.getLocation().hashCode());
		result = 37 * result
				+ (getAssWho() == null ? 0 : this.getAssWho().hashCode());
		result = 37 * result
				+ (getAssWhen() == null ? 0 : this.getAssWhen().hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37 * result
				+ (getLasttube() == null ? 0 : this.getLasttube().hashCode());
		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		return result;
	}

}
