package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ConflictResolutionViewId generated by hbm2java
 */
public class ConflictResolutionViewId implements java.io.Serializable {

	private String caseId;
	private String caseRoiId;
	private BigDecimal roiId;
	private BigDecimal generegionId;
	private String roiName;
	private String position;
	private String genotype;
	private String firstAllele;
	private String secondAllele;
	private String contextSequence;
	private String wildTypeSequence;
	private String createdBy;
	private Date dateCreated;
	private BigDecimal checklistId;

	public ConflictResolutionViewId() {
	}

	public ConflictResolutionViewId(String caseRoiId, String roiName) {
		this.caseRoiId = caseRoiId;
		this.roiName = roiName;
	}

	public ConflictResolutionViewId(String caseId, String caseRoiId,
			BigDecimal roiId, BigDecimal generegionId, String roiName,
			String position, String genotype, String firstAllele,
			String secondAllele, String contextSequence,
			String wildTypeSequence, String createdBy, Date dateCreated,
			BigDecimal checklistId) {
		this.caseId = caseId;
		this.caseRoiId = caseRoiId;
		this.roiId = roiId;
		this.generegionId = generegionId;
		this.roiName = roiName;
		this.position = position;
		this.genotype = genotype;
		this.firstAllele = firstAllele;
		this.secondAllele = secondAllele;
		this.contextSequence = contextSequence;
		this.wildTypeSequence = wildTypeSequence;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.checklistId = checklistId;
	}

	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseRoiId() {
		return this.caseRoiId;
	}

	public void setCaseRoiId(String caseRoiId) {
		this.caseRoiId = caseRoiId;
	}

	public BigDecimal getRoiId() {
		return this.roiId;
	}

	public void setRoiId(BigDecimal roiId) {
		this.roiId = roiId;
	}

	public BigDecimal getGeneregionId() {
		return this.generegionId;
	}

	public void setGeneregionId(BigDecimal generegionId) {
		this.generegionId = generegionId;
	}

	public String getRoiName() {
		return this.roiName;
	}

	public void setRoiName(String roiName) {
		this.roiName = roiName;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGenotype() {
		return this.genotype;
	}

	public void setGenotype(String genotype) {
		this.genotype = genotype;
	}

	public String getFirstAllele() {
		return this.firstAllele;
	}

	public void setFirstAllele(String firstAllele) {
		this.firstAllele = firstAllele;
	}

	public String getSecondAllele() {
		return this.secondAllele;
	}

	public void setSecondAllele(String secondAllele) {
		this.secondAllele = secondAllele;
	}

	public String getContextSequence() {
		return this.contextSequence;
	}

	public void setContextSequence(String contextSequence) {
		this.contextSequence = contextSequence;
	}

	public String getWildTypeSequence() {
		return this.wildTypeSequence;
	}

	public void setWildTypeSequence(String wildTypeSequence) {
		this.wildTypeSequence = wildTypeSequence;
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

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ConflictResolutionViewId))
			return false;
		ConflictResolutionViewId castOther = (ConflictResolutionViewId) other;

		return ((this.getCaseId() == castOther.getCaseId()) || (this
				.getCaseId() != null && castOther.getCaseId() != null && this
				.getCaseId().equals(castOther.getCaseId())))
				&& ((this.getCaseRoiId() == castOther.getCaseRoiId()) || (this
						.getCaseRoiId() != null
						&& castOther.getCaseRoiId() != null && this
						.getCaseRoiId().equals(castOther.getCaseRoiId())))
				&& ((this.getRoiId() == castOther.getRoiId()) || (this
						.getRoiId() != null && castOther.getRoiId() != null && this
						.getRoiId().equals(castOther.getRoiId())))
				&& ((this.getGeneregionId() == castOther.getGeneregionId()) || (this
						.getGeneregionId() != null
						&& castOther.getGeneregionId() != null && this
						.getGeneregionId().equals(castOther.getGeneregionId())))
				&& ((this.getRoiName() == castOther.getRoiName()) || (this
						.getRoiName() != null && castOther.getRoiName() != null && this
						.getRoiName().equals(castOther.getRoiName())))
				&& ((this.getPosition() == castOther.getPosition()) || (this
						.getPosition() != null
						&& castOther.getPosition() != null && this
						.getPosition().equals(castOther.getPosition())))
				&& ((this.getGenotype() == castOther.getGenotype()) || (this
						.getGenotype() != null
						&& castOther.getGenotype() != null && this
						.getGenotype().equals(castOther.getGenotype())))
				&& ((this.getFirstAllele() == castOther.getFirstAllele()) || (this
						.getFirstAllele() != null
						&& castOther.getFirstAllele() != null && this
						.getFirstAllele().equals(castOther.getFirstAllele())))
				&& ((this.getSecondAllele() == castOther.getSecondAllele()) || (this
						.getSecondAllele() != null
						&& castOther.getSecondAllele() != null && this
						.getSecondAllele().equals(castOther.getSecondAllele())))
				&& ((this.getContextSequence() == castOther
						.getContextSequence()) || (this.getContextSequence() != null
						&& castOther.getContextSequence() != null && this
						.getContextSequence().equals(
								castOther.getContextSequence())))
				&& ((this.getWildTypeSequence() == castOther
						.getWildTypeSequence()) || (this.getWildTypeSequence() != null
						&& castOther.getWildTypeSequence() != null && this
						.getWildTypeSequence().equals(
								castOther.getWildTypeSequence())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getChecklistId() == castOther.getChecklistId()) || (this
						.getChecklistId() != null
						&& castOther.getChecklistId() != null && this
						.getChecklistId().equals(castOther.getChecklistId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCaseId() == null ? 0 : this.getCaseId().hashCode());
		result = 37 * result
				+ (getCaseRoiId() == null ? 0 : this.getCaseRoiId().hashCode());
		result = 37 * result
				+ (getRoiId() == null ? 0 : this.getRoiId().hashCode());
		result = 37
				* result
				+ (getGeneregionId() == null ? 0 : this.getGeneregionId()
						.hashCode());
		result = 37 * result
				+ (getRoiName() == null ? 0 : this.getRoiName().hashCode());
		result = 37 * result
				+ (getPosition() == null ? 0 : this.getPosition().hashCode());
		result = 37 * result
				+ (getGenotype() == null ? 0 : this.getGenotype().hashCode());
		result = 37
				* result
				+ (getFirstAllele() == null ? 0 : this.getFirstAllele()
						.hashCode());
		result = 37
				* result
				+ (getSecondAllele() == null ? 0 : this.getSecondAllele()
						.hashCode());
		result = 37
				* result
				+ (getContextSequence() == null ? 0 : this.getContextSequence()
						.hashCode());
		result = 37
				* result
				+ (getWildTypeSequence() == null ? 0 : this
						.getWildTypeSequence().hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37
				* result
				+ (getChecklistId() == null ? 0 : this.getChecklistId()
						.hashCode());
		return result;
	}

}
