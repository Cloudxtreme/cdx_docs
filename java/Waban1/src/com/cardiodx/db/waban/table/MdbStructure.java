package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MdbStructure generated by hbm2java
 */
public class MdbStructure implements java.io.Serializable {

	private BigDecimal structureId;
	private Gene gene;
	private String transcriptName;
	private BigDecimal isDefault;
	private BigDecimal translationStart;
	private Boolean isComplement;
	private String createdBy;
	private Date dateCreated;
	private Set<MdbProtein> mdbProteins = new HashSet<MdbProtein>(0);
	private Set<MdbVariantStructRel> mdbVariantStructRels = new HashSet<MdbVariantStructRel>(
			0);
	private Set<MdbGeneRegion> mdbGeneRegions = new HashSet<MdbGeneRegion>(0);

	public MdbStructure() {
	}

	public MdbStructure(BigDecimal structureId) {
		this.structureId = structureId;
	}

	public MdbStructure(BigDecimal structureId, Gene gene,
			String transcriptName, BigDecimal isDefault,
			BigDecimal translationStart, Boolean isComplement,
			String createdBy, Date dateCreated, Set<MdbProtein> mdbProteins,
			Set<MdbVariantStructRel> mdbVariantStructRels,
			Set<MdbGeneRegion> mdbGeneRegions) {
		this.structureId = structureId;
		this.gene = gene;
		this.transcriptName = transcriptName;
		this.isDefault = isDefault;
		this.translationStart = translationStart;
		this.isComplement = isComplement;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.mdbProteins = mdbProteins;
		this.mdbVariantStructRels = mdbVariantStructRels;
		this.mdbGeneRegions = mdbGeneRegions;
	}

	public BigDecimal getStructureId() {
		return this.structureId;
	}

	public void setStructureId(BigDecimal structureId) {
		this.structureId = structureId;
	}

	public Gene getGene() {
		return this.gene;
	}

	public void setGene(Gene gene) {
		this.gene = gene;
	}

	public String getTranscriptName() {
		return this.transcriptName;
	}

	public void setTranscriptName(String transcriptName) {
		this.transcriptName = transcriptName;
	}

	public BigDecimal getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(BigDecimal isDefault) {
		this.isDefault = isDefault;
	}

	public BigDecimal getTranslationStart() {
		return this.translationStart;
	}

	public void setTranslationStart(BigDecimal translationStart) {
		this.translationStart = translationStart;
	}

	public Boolean getIsComplement() {
		return this.isComplement;
	}

	public void setIsComplement(Boolean isComplement) {
		this.isComplement = isComplement;
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

	public Set<MdbProtein> getMdbProteins() {
		return this.mdbProteins;
	}

	public void setMdbProteins(Set<MdbProtein> mdbProteins) {
		this.mdbProteins = mdbProteins;
	}

	public Set<MdbVariantStructRel> getMdbVariantStructRels() {
		return this.mdbVariantStructRels;
	}

	public void setMdbVariantStructRels(
			Set<MdbVariantStructRel> mdbVariantStructRels) {
		this.mdbVariantStructRels = mdbVariantStructRels;
	}

	public Set<MdbGeneRegion> getMdbGeneRegions() {
		return this.mdbGeneRegions;
	}

	public void setMdbGeneRegions(Set<MdbGeneRegion> mdbGeneRegions) {
		this.mdbGeneRegions = mdbGeneRegions;
	}

}
