package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * MdbGenotype generated by hbm2java
 */
public class MdbGenotype implements java.io.Serializable {

	private BigDecimal genotypeId;
	private MdbVariant mdbVariantByAllele2VariantId;
	private Roi roi;
	private MdbVariant mdbVariantByVariantId;
	private MdbClassification mdbClassification;
	private TestAccession testAccession;
	private String zygosity;
	private String createdBy;
	private Date dateCreated;

	public MdbGenotype() {
	}

	public MdbGenotype(BigDecimal genotypeId, TestAccession testAccession) {
		this.genotypeId = genotypeId;
		this.testAccession = testAccession;
	}

	public MdbGenotype(BigDecimal genotypeId,
			MdbVariant mdbVariantByAllele2VariantId, Roi roi,
			MdbVariant mdbVariantByVariantId,
			MdbClassification mdbClassification, TestAccession testAccession,
			String zygosity, String createdBy, Date dateCreated) {
		this.genotypeId = genotypeId;
		this.mdbVariantByAllele2VariantId = mdbVariantByAllele2VariantId;
		this.roi = roi;
		this.mdbVariantByVariantId = mdbVariantByVariantId;
		this.mdbClassification = mdbClassification;
		this.testAccession = testAccession;
		this.zygosity = zygosity;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public BigDecimal getGenotypeId() {
		return this.genotypeId;
	}

	public void setGenotypeId(BigDecimal genotypeId) {
		this.genotypeId = genotypeId;
	}

	public MdbVariant getMdbVariantByAllele2VariantId() {
		return this.mdbVariantByAllele2VariantId;
	}

	public void setMdbVariantByAllele2VariantId(
			MdbVariant mdbVariantByAllele2VariantId) {
		this.mdbVariantByAllele2VariantId = mdbVariantByAllele2VariantId;
	}

	public Roi getRoi() {
		return this.roi;
	}

	public void setRoi(Roi roi) {
		this.roi = roi;
	}

	public MdbVariant getMdbVariantByVariantId() {
		return this.mdbVariantByVariantId;
	}

	public void setMdbVariantByVariantId(MdbVariant mdbVariantByVariantId) {
		this.mdbVariantByVariantId = mdbVariantByVariantId;
	}

	public MdbClassification getMdbClassification() {
		return this.mdbClassification;
	}

	public void setMdbClassification(MdbClassification mdbClassification) {
		this.mdbClassification = mdbClassification;
	}

	public TestAccession getTestAccession() {
		return this.testAccession;
	}

	public void setTestAccession(TestAccession testAccession) {
		this.testAccession = testAccession;
	}

	public String getZygosity() {
		return this.zygosity;
	}

	public void setZygosity(String zygosity) {
		this.zygosity = zygosity;
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

}