package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;

/**
 * AudGene generated by hbm2java
 */
public class AudGene implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal geneId;
	private String geneName;
	private String geneLongName;
	private BigDecimal numberInSequence;
	private String description;
	private Clob sequence;
	private String organism;
	private String range;
	private String ensemblId;
	private String changedBy;
	private Date dateChanged;
	private String changeType;

	public AudGene() {
	}

	public AudGene(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudGene(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal geneId, String geneName, String geneLongName,
			BigDecimal numberInSequence, String description, Clob sequence,
			String organism, String range, String ensemblId, String changedBy,
			Date dateChanged, String changeType) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.geneId = geneId;
		this.geneName = geneName;
		this.geneLongName = geneLongName;
		this.numberInSequence = numberInSequence;
		this.description = description;
		this.sequence = sequence;
		this.organism = organism;
		this.range = range;
		this.ensemblId = ensemblId;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
	}

	public BigDecimal getAuditId() {
		return this.auditId;
	}

	public void setAuditId(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public BigDecimal getChangeReasonId() {
		return this.changeReasonId;
	}

	public void setChangeReasonId(BigDecimal changeReasonId) {
		this.changeReasonId = changeReasonId;
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

	public String getGeneLongName() {
		return this.geneLongName;
	}

	public void setGeneLongName(String geneLongName) {
		this.geneLongName = geneLongName;
	}

	public BigDecimal getNumberInSequence() {
		return this.numberInSequence;
	}

	public void setNumberInSequence(BigDecimal numberInSequence) {
		this.numberInSequence = numberInSequence;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Clob getSequence() {
		return this.sequence;
	}

	public void setSequence(Clob sequence) {
		this.sequence = sequence;
	}

	public String getOrganism() {
		return this.organism;
	}

	public void setOrganism(String organism) {
		this.organism = organism;
	}

	public String getRange() {
		return this.range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getEnsemblId() {
		return this.ensemblId;
	}

	public void setEnsemblId(String ensemblId) {
		this.ensemblId = ensemblId;
	}

	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public String getChangeType() {
		return this.changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

}
