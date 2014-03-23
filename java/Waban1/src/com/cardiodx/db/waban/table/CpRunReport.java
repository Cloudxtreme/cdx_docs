package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * CpRunReport generated by hbm2java
 */
public class CpRunReport implements java.io.Serializable {

	private BigDecimal cpRunReportId;
	private CpRun cpRun;
	private Accession accession;
	private BigDecimal versionedDocumentId;
	private BigDecimal subsidiaryId;

	public CpRunReport() {
	}

	public CpRunReport(BigDecimal cpRunReportId, Accession accession,
			BigDecimal versionedDocumentId) {
		this.cpRunReportId = cpRunReportId;
		this.accession = accession;
		this.versionedDocumentId = versionedDocumentId;
	}

	public CpRunReport(BigDecimal cpRunReportId, CpRun cpRun,
			Accession accession, BigDecimal versionedDocumentId,
			BigDecimal subsidiaryId) {
		this.cpRunReportId = cpRunReportId;
		this.cpRun = cpRun;
		this.accession = accession;
		this.versionedDocumentId = versionedDocumentId;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getCpRunReportId() {
		return this.cpRunReportId;
	}

	public void setCpRunReportId(BigDecimal cpRunReportId) {
		this.cpRunReportId = cpRunReportId;
	}

	public CpRun getCpRun() {
		return this.cpRun;
	}

	public void setCpRun(CpRun cpRun) {
		this.cpRun = cpRun;
	}

	public Accession getAccession() {
		return this.accession;
	}

	public void setAccession(Accession accession) {
		this.accession = accession;
	}

	public BigDecimal getVersionedDocumentId() {
		return this.versionedDocumentId;
	}

	public void setVersionedDocumentId(BigDecimal versionedDocumentId) {
		this.versionedDocumentId = versionedDocumentId;
	}

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

}
