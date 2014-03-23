package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Accession generated by hbm2java
 */
public class Accession implements java.io.Serializable {

	private BigDecimal accessionId;
	private StudyProtocol studyProtocol;
	private Subsidiary subsidiary;
	private String accessionNumber;
	private Date dateReceived;
	private String resultStatus;
	private Boolean destroyed;
	private Date dateShipped;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String gpiCode;
	private Set<CdxFaxAttempt> cdxFaxAttempts = new HashSet<CdxFaxAttempt>(0);
	private Set<PendingSampleTable> pendingSampleTables = new HashSet<PendingSampleTable>(
			0);
	private Set<RoiSelection> roiSelections = new HashSet<RoiSelection>(0);
	private Set<AnonymizedLabAccessionNo> anonymizedLabAccessionNos = new HashSet<AnonymizedLabAccessionNo>(
			0);
	private Set<CpRunReport> cpRunReports = new HashSet<CpRunReport>(0);
	private Set<SampleTable> sampleTables = new HashSet<SampleTable>(0);
	private Set<AccessionProcedure> accessionProcedures = new HashSet<AccessionProcedure>(
			0);
	private Set<GeneResult> geneResults = new HashSet<GeneResult>(0);
	private Set<AccessionVariableFldTable> accessionVariableFldTables = new HashSet<AccessionVariableFldTable>(
			0);
	private Set<AccessionComment> accessionComments = new HashSet<AccessionComment>(
			0);
	private Set<TestAccession> testAccessions = new HashSet<TestAccession>(0);

	public Accession() {
	}

	public Accession(BigDecimal accessionId, StudyProtocol studyProtocol,
			String accessionNumber, Date dateReceived) {
		this.accessionId = accessionId;
		this.studyProtocol = studyProtocol;
		this.accessionNumber = accessionNumber;
		this.dateReceived = dateReceived;
	}

	public Accession(BigDecimal accessionId, StudyProtocol studyProtocol,
			Subsidiary subsidiary, String accessionNumber, Date dateReceived,
			String resultStatus, Boolean destroyed, Date dateShipped,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, String gpiCode,
			Set<CdxFaxAttempt> cdxFaxAttempts,
			Set<PendingSampleTable> pendingSampleTables,
			Set<RoiSelection> roiSelections,
			Set<AnonymizedLabAccessionNo> anonymizedLabAccessionNos,
			Set<CpRunReport> cpRunReports, Set<SampleTable> sampleTables,
			Set<AccessionProcedure> accessionProcedures,
			Set<GeneResult> geneResults,
			Set<AccessionVariableFldTable> accessionVariableFldTables,
			Set<AccessionComment> accessionComments,
			Set<TestAccession> testAccessions) {
		this.accessionId = accessionId;
		this.studyProtocol = studyProtocol;
		this.subsidiary = subsidiary;
		this.accessionNumber = accessionNumber;
		this.dateReceived = dateReceived;
		this.resultStatus = resultStatus;
		this.destroyed = destroyed;
		this.dateShipped = dateShipped;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.gpiCode = gpiCode;
		this.cdxFaxAttempts = cdxFaxAttempts;
		this.pendingSampleTables = pendingSampleTables;
		this.roiSelections = roiSelections;
		this.anonymizedLabAccessionNos = anonymizedLabAccessionNos;
		this.cpRunReports = cpRunReports;
		this.sampleTables = sampleTables;
		this.accessionProcedures = accessionProcedures;
		this.geneResults = geneResults;
		this.accessionVariableFldTables = accessionVariableFldTables;
		this.accessionComments = accessionComments;
		this.testAccessions = testAccessions;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
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

	public String getAccessionNumber() {
		return this.accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public Date getDateReceived() {
		return this.dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getResultStatus() {
		return this.resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Boolean getDestroyed() {
		return this.destroyed;
	}

	public void setDestroyed(Boolean destroyed) {
		this.destroyed = destroyed;
	}

	public Date getDateShipped() {
		return this.dateShipped;
	}

	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
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

	public String getGpiCode() {
		return this.gpiCode;
	}

	public void setGpiCode(String gpiCode) {
		this.gpiCode = gpiCode;
	}

	public Set<CdxFaxAttempt> getCdxFaxAttempts() {
		return this.cdxFaxAttempts;
	}

	public void setCdxFaxAttempts(Set<CdxFaxAttempt> cdxFaxAttempts) {
		this.cdxFaxAttempts = cdxFaxAttempts;
	}

	public Set<PendingSampleTable> getPendingSampleTables() {
		return this.pendingSampleTables;
	}

	public void setPendingSampleTables(
			Set<PendingSampleTable> pendingSampleTables) {
		this.pendingSampleTables = pendingSampleTables;
	}

	public Set<RoiSelection> getRoiSelections() {
		return this.roiSelections;
	}

	public void setRoiSelections(Set<RoiSelection> roiSelections) {
		this.roiSelections = roiSelections;
	}

	public Set<AnonymizedLabAccessionNo> getAnonymizedLabAccessionNos() {
		return this.anonymizedLabAccessionNos;
	}

	public void setAnonymizedLabAccessionNos(
			Set<AnonymizedLabAccessionNo> anonymizedLabAccessionNos) {
		this.anonymizedLabAccessionNos = anonymizedLabAccessionNos;
	}

	public Set<CpRunReport> getCpRunReports() {
		return this.cpRunReports;
	}

	public void setCpRunReports(Set<CpRunReport> cpRunReports) {
		this.cpRunReports = cpRunReports;
	}

	public Set<SampleTable> getSampleTables() {
		return this.sampleTables;
	}

	public void setSampleTables(Set<SampleTable> sampleTables) {
		this.sampleTables = sampleTables;
	}

	public Set<AccessionProcedure> getAccessionProcedures() {
		return this.accessionProcedures;
	}

	public void setAccessionProcedures(
			Set<AccessionProcedure> accessionProcedures) {
		this.accessionProcedures = accessionProcedures;
	}

	public Set<GeneResult> getGeneResults() {
		return this.geneResults;
	}

	public void setGeneResults(Set<GeneResult> geneResults) {
		this.geneResults = geneResults;
	}

	public Set<AccessionVariableFldTable> getAccessionVariableFldTables() {
		return this.accessionVariableFldTables;
	}

	public void setAccessionVariableFldTables(
			Set<AccessionVariableFldTable> accessionVariableFldTables) {
		this.accessionVariableFldTables = accessionVariableFldTables;
	}

	public Set<AccessionComment> getAccessionComments() {
		return this.accessionComments;
	}

	public void setAccessionComments(Set<AccessionComment> accessionComments) {
		this.accessionComments = accessionComments;
	}

	public Set<TestAccession> getTestAccessions() {
		return this.testAccessions;
	}

	public void setTestAccessions(Set<TestAccession> testAccessions) {
		this.testAccessions = testAccessions;
	}

}
