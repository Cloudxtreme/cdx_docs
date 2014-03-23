package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ProtocolAllele generated by hbm2java
 */
public class ProtocolAllele implements java.io.Serializable {

	private BigDecimal protocolAlleleId;
	private Allele allele;
	private StudyProtocol studyProtocol;
	private Subsidiary subsidiary;
	private Boolean mandatory;
	private BigDecimal displaySequence;
	private String modifiedBy;
	private Date dateModified;
	private Set<ProtocolAlleleValue> protocolAlleleValues = new HashSet<ProtocolAlleleValue>(
			0);

	public ProtocolAllele() {
	}

	public ProtocolAllele(BigDecimal protocolAlleleId, Allele allele,
			StudyProtocol studyProtocol) {
		this.protocolAlleleId = protocolAlleleId;
		this.allele = allele;
		this.studyProtocol = studyProtocol;
	}

	public ProtocolAllele(BigDecimal protocolAlleleId, Allele allele,
			StudyProtocol studyProtocol, Subsidiary subsidiary,
			Boolean mandatory, BigDecimal displaySequence, String modifiedBy,
			Date dateModified, Set<ProtocolAlleleValue> protocolAlleleValues) {
		this.protocolAlleleId = protocolAlleleId;
		this.allele = allele;
		this.studyProtocol = studyProtocol;
		this.subsidiary = subsidiary;
		this.mandatory = mandatory;
		this.displaySequence = displaySequence;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.protocolAlleleValues = protocolAlleleValues;
	}

	public BigDecimal getProtocolAlleleId() {
		return this.protocolAlleleId;
	}

	public void setProtocolAlleleId(BigDecimal protocolAlleleId) {
		this.protocolAlleleId = protocolAlleleId;
	}

	public Allele getAllele() {
		return this.allele;
	}

	public void setAllele(Allele allele) {
		this.allele = allele;
	}

	public StudyProtocol getStudyProtocol() {
		return this.studyProtocol;
	}

	public void setStudyProtocol(StudyProtocol studyProtocol) {
		this.studyProtocol = studyProtocol;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public Boolean getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public BigDecimal getDisplaySequence() {
		return this.displaySequence;
	}

	public void setDisplaySequence(BigDecimal displaySequence) {
		this.displaySequence = displaySequence;
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

	public Set<ProtocolAlleleValue> getProtocolAlleleValues() {
		return this.protocolAlleleValues;
	}

	public void setProtocolAlleleValues(
			Set<ProtocolAlleleValue> protocolAlleleValues) {
		this.protocolAlleleValues = protocolAlleleValues;
	}

}