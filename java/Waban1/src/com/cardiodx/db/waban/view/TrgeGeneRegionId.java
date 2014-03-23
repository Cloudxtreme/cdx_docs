package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * TrgeGeneRegionId generated by hbm2java
 */
public class TrgeGeneRegionId implements java.io.Serializable {

	private BigDecimal geneRegionId;
	private String regionName;
	private String regionType;
	private BigDecimal regionNumber;
	private BigDecimal startPos;
	private BigDecimal length;
	private Boolean isComplement;
	private BigDecimal geneId;
	private String geneName;

	public TrgeGeneRegionId() {
	}

	public TrgeGeneRegionId(BigDecimal geneRegionId, String regionName,
			BigDecimal regionNumber, BigDecimal geneId, String geneName) {
		this.geneRegionId = geneRegionId;
		this.regionName = regionName;
		this.regionNumber = regionNumber;
		this.geneId = geneId;
		this.geneName = geneName;
	}

	public TrgeGeneRegionId(BigDecimal geneRegionId, String regionName,
			String regionType, BigDecimal regionNumber, BigDecimal startPos,
			BigDecimal length, Boolean isComplement, BigDecimal geneId,
			String geneName) {
		this.geneRegionId = geneRegionId;
		this.regionName = regionName;
		this.regionType = regionType;
		this.regionNumber = regionNumber;
		this.startPos = startPos;
		this.length = length;
		this.isComplement = isComplement;
		this.geneId = geneId;
		this.geneName = geneName;
	}

	public BigDecimal getGeneRegionId() {
		return this.geneRegionId;
	}

	public void setGeneRegionId(BigDecimal geneRegionId) {
		this.geneRegionId = geneRegionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionType() {
		return this.regionType;
	}

	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}

	public BigDecimal getRegionNumber() {
		return this.regionNumber;
	}

	public void setRegionNumber(BigDecimal regionNumber) {
		this.regionNumber = regionNumber;
	}

	public BigDecimal getStartPos() {
		return this.startPos;
	}

	public void setStartPos(BigDecimal startPos) {
		this.startPos = startPos;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public Boolean getIsComplement() {
		return this.isComplement;
	}

	public void setIsComplement(Boolean isComplement) {
		this.isComplement = isComplement;
	}

	public BigDecimal getGeneId() {
		return this.geneId;
	}

	public void setGeneId(BigDecimal geneId) {
		this.geneId = geneId;
	}

	public String getGeneName() {
		return this.geneName;
	}

	public void setGeneName(String geneName) {
		this.geneName = geneName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TrgeGeneRegionId))
			return false;
		TrgeGeneRegionId castOther = (TrgeGeneRegionId) other;

		return ((this.getGeneRegionId() == castOther.getGeneRegionId()) || (this
				.getGeneRegionId() != null
				&& castOther.getGeneRegionId() != null && this
				.getGeneRegionId().equals(castOther.getGeneRegionId())))
				&& ((this.getRegionName() == castOther.getRegionName()) || (this
						.getRegionName() != null
						&& castOther.getRegionName() != null && this
						.getRegionName().equals(castOther.getRegionName())))
				&& ((this.getRegionType() == castOther.getRegionType()) || (this
						.getRegionType() != null
						&& castOther.getRegionType() != null && this
						.getRegionType().equals(castOther.getRegionType())))
				&& ((this.getRegionNumber() == castOther.getRegionNumber()) || (this
						.getRegionNumber() != null
						&& castOther.getRegionNumber() != null && this
						.getRegionNumber().equals(castOther.getRegionNumber())))
				&& ((this.getStartPos() == castOther.getStartPos()) || (this
						.getStartPos() != null
						&& castOther.getStartPos() != null && this
						.getStartPos().equals(castOther.getStartPos())))
				&& ((this.getLength() == castOther.getLength()) || (this
						.getLength() != null && castOther.getLength() != null && this
						.getLength().equals(castOther.getLength())))
				&& ((this.getIsComplement() == castOther.getIsComplement()) || (this
						.getIsComplement() != null
						&& castOther.getIsComplement() != null && this
						.getIsComplement().equals(castOther.getIsComplement())))
				&& ((this.getGeneId() == castOther.getGeneId()) || (this
						.getGeneId() != null && castOther.getGeneId() != null && this
						.getGeneId().equals(castOther.getGeneId())))
				&& ((this.getGeneName() == castOther.getGeneName()) || (this
						.getGeneName() != null
						&& castOther.getGeneName() != null && this
						.getGeneName().equals(castOther.getGeneName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getGeneRegionId() == null ? 0 : this.getGeneRegionId()
						.hashCode());
		result = 37
				* result
				+ (getRegionName() == null ? 0 : this.getRegionName()
						.hashCode());
		result = 37
				* result
				+ (getRegionType() == null ? 0 : this.getRegionType()
						.hashCode());
		result = 37
				* result
				+ (getRegionNumber() == null ? 0 : this.getRegionNumber()
						.hashCode());
		result = 37 * result
				+ (getStartPos() == null ? 0 : this.getStartPos().hashCode());
		result = 37 * result
				+ (getLength() == null ? 0 : this.getLength().hashCode());
		result = 37
				* result
				+ (getIsComplement() == null ? 0 : this.getIsComplement()
						.hashCode());
		result = 37 * result
				+ (getGeneId() == null ? 0 : this.getGeneId().hashCode());
		result = 37 * result
				+ (getGeneName() == null ? 0 : this.getGeneName().hashCode());
		return result;
	}

}