package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OligoDesign generated by hbm2java
 */
public class OligoDesign implements java.io.Serializable {

	private BigDecimal oligoId;
	private Roi roi;
	private String oligoName;
	private String oligoSequence;
	private String modification5;
	private String modification3;
	private String internalModification;
	private String oligoType;
	private String temperature;
	private String purpose;
	private String mixture;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private Set<OligoReagent> oligoReagents = new HashSet<OligoReagent>(0);
	private Set<CpValue> cpValues = new HashSet<CpValue>(0);
	private Set<OligoMixtureDesign> oligoMixtureDesignsForOligoMixtureId = new HashSet<OligoMixtureDesign>(
			0);
	private Set<OligoAssayDesign> oligoAssayDesigns = new HashSet<OligoAssayDesign>(
			0);
	private Set<CpNormalizedValue> cpNormalizedValues = new HashSet<CpNormalizedValue>(
			0);
	private Set<OligoMixtureDesign> oligoMixtureDesignsForOligoId = new HashSet<OligoMixtureDesign>(
			0);
	private Set<OligoPurposeDesign> oligoPurposeDesigns = new HashSet<OligoPurposeDesign>(
			0);

	public OligoDesign() {
	}

	public OligoDesign(BigDecimal oligoId, String oligoName) {
		this.oligoId = oligoId;
		this.oligoName = oligoName;
	}

	public OligoDesign(BigDecimal oligoId, Roi roi, String oligoName,
			String oligoSequence, String modification5, String modification3,
			String internalModification, String oligoType, String temperature,
			String purpose, String mixture, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified,
			Set<OligoReagent> oligoReagents, Set<CpValue> cpValues,
			Set<OligoMixtureDesign> oligoMixtureDesignsForOligoMixtureId,
			Set<OligoAssayDesign> oligoAssayDesigns,
			Set<CpNormalizedValue> cpNormalizedValues,
			Set<OligoMixtureDesign> oligoMixtureDesignsForOligoId,
			Set<OligoPurposeDesign> oligoPurposeDesigns) {
		this.oligoId = oligoId;
		this.roi = roi;
		this.oligoName = oligoName;
		this.oligoSequence = oligoSequence;
		this.modification5 = modification5;
		this.modification3 = modification3;
		this.internalModification = internalModification;
		this.oligoType = oligoType;
		this.temperature = temperature;
		this.purpose = purpose;
		this.mixture = mixture;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.oligoReagents = oligoReagents;
		this.cpValues = cpValues;
		this.oligoMixtureDesignsForOligoMixtureId = oligoMixtureDesignsForOligoMixtureId;
		this.oligoAssayDesigns = oligoAssayDesigns;
		this.cpNormalizedValues = cpNormalizedValues;
		this.oligoMixtureDesignsForOligoId = oligoMixtureDesignsForOligoId;
		this.oligoPurposeDesigns = oligoPurposeDesigns;
	}

	public BigDecimal getOligoId() {
		return this.oligoId;
	}

	public void setOligoId(BigDecimal oligoId) {
		this.oligoId = oligoId;
	}

	public Roi getRoi() {
		return this.roi;
	}

	public void setRoi(Roi roi) {
		this.roi = roi;
	}

	public String getOligoName() {
		return this.oligoName;
	}

	public void setOligoName(String oligoName) {
		this.oligoName = oligoName;
	}

	public String getOligoSequence() {
		return this.oligoSequence;
	}

	public void setOligoSequence(String oligoSequence) {
		this.oligoSequence = oligoSequence;
	}

	public String getModification5() {
		return this.modification5;
	}

	public void setModification5(String modification5) {
		this.modification5 = modification5;
	}

	public String getModification3() {
		return this.modification3;
	}

	public void setModification3(String modification3) {
		this.modification3 = modification3;
	}

	public String getInternalModification() {
		return this.internalModification;
	}

	public void setInternalModification(String internalModification) {
		this.internalModification = internalModification;
	}

	public String getOligoType() {
		return this.oligoType;
	}

	public void setOligoType(String oligoType) {
		this.oligoType = oligoType;
	}

	public String getTemperature() {
		return this.temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getMixture() {
		return this.mixture;
	}

	public void setMixture(String mixture) {
		this.mixture = mixture;
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

	public Set<OligoReagent> getOligoReagents() {
		return this.oligoReagents;
	}

	public void setOligoReagents(Set<OligoReagent> oligoReagents) {
		this.oligoReagents = oligoReagents;
	}

	public Set<CpValue> getCpValues() {
		return this.cpValues;
	}

	public void setCpValues(Set<CpValue> cpValues) {
		this.cpValues = cpValues;
	}

	public Set<OligoMixtureDesign> getOligoMixtureDesignsForOligoMixtureId() {
		return this.oligoMixtureDesignsForOligoMixtureId;
	}

	public void setOligoMixtureDesignsForOligoMixtureId(
			Set<OligoMixtureDesign> oligoMixtureDesignsForOligoMixtureId) {
		this.oligoMixtureDesignsForOligoMixtureId = oligoMixtureDesignsForOligoMixtureId;
	}

	public Set<OligoAssayDesign> getOligoAssayDesigns() {
		return this.oligoAssayDesigns;
	}

	public void setOligoAssayDesigns(Set<OligoAssayDesign> oligoAssayDesigns) {
		this.oligoAssayDesigns = oligoAssayDesigns;
	}

	public Set<CpNormalizedValue> getCpNormalizedValues() {
		return this.cpNormalizedValues;
	}

	public void setCpNormalizedValues(Set<CpNormalizedValue> cpNormalizedValues) {
		this.cpNormalizedValues = cpNormalizedValues;
	}

	public Set<OligoMixtureDesign> getOligoMixtureDesignsForOligoId() {
		return this.oligoMixtureDesignsForOligoId;
	}

	public void setOligoMixtureDesignsForOligoId(
			Set<OligoMixtureDesign> oligoMixtureDesignsForOligoId) {
		this.oligoMixtureDesignsForOligoId = oligoMixtureDesignsForOligoId;
	}

	public Set<OligoPurposeDesign> getOligoPurposeDesigns() {
		return this.oligoPurposeDesigns;
	}

	public void setOligoPurposeDesigns(
			Set<OligoPurposeDesign> oligoPurposeDesigns) {
		this.oligoPurposeDesigns = oligoPurposeDesigns;
	}

}
