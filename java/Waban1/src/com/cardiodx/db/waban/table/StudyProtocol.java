package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * StudyProtocol generated by hbm2java
 */
public class StudyProtocol implements java.io.Serializable {

	private BigDecimal studyProtocolId;
	private OcxLoad ocxLoadByStudyVarOcx;
	private OcxLoad ocxLoadByPatientVarOcx;
	private Contact contact;
	private Subsidiary subsidiary;
	private OcxLoad ocxLoadByAccessionVarOcx;
	private String studyNumber;
	private String sponsorStudyNumber;
	private String studyTitle;
	private String studyDirector;
	private String sponsorStudyTitle;
	private Boolean cascadeAccessionNumber;
	private BigDecimal barcodeLength;
	private String finalTubeBarcodeLowValue;
	private String finalTubeBarcodeHighValue;
	private Boolean studyClosed;
	private Boolean shipDnaBack;
	private String studyUrl;
	private String studyType;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private Set<TestAccession> testAccessions = new HashSet<TestAccession>(0);
	private Set<VendorProjectAssay> vendorProjectAssaies = new HashSet<VendorProjectAssay>(
			0);
	private Set<StudyVariableFld> studyVariableFlds = new HashSet<StudyVariableFld>(
			0);
	private Set<DnaDestructionRequest> dnaDestructionRequests = new HashSet<DnaDestructionRequest>(
			0);
	private Set<OutboundRequest> outboundRequests = new HashSet<OutboundRequest>(
			0);
	private Set<GeneResult> geneResults = new HashSet<GeneResult>(0);
	private Set<ProtocolProcedure> protocolProcedures = new HashSet<ProtocolProcedure>(
			0);
	private Set<ProtocolTest> protocolTests = new HashSet<ProtocolTest>(0);
	private Set<ProtocolDefinedVariable> protocolDefinedVariables = new HashSet<ProtocolDefinedVariable>(
			0);
	private Set<StaarAnonymizationRequest> staarAnonymizationRequestsForStudyProtocolId = new HashSet<StaarAnonymizationRequest>(
			0);
	private Set<PgxModifyTemplateComment> pgxModifyTemplateComments = new HashSet<PgxModifyTemplateComment>(
			0);
	private Set<PendingSampleTable> pendingSampleTables = new HashSet<PendingSampleTable>(
			0);
	private Set<EventSubscription> eventSubscriptions = new HashSet<EventSubscription>(
			0);
	private Set<PgxDataReport> pgxDataReports = new HashSet<PgxDataReport>(0);
	private Set<SampleReception> sampleReceptions = new HashSet<SampleReception>(
			0);
	private Set<Accession> accessions = new HashSet<Accession>(0);
	private Set<AnonymizationStudySetup> anonymizationStudySetups = new HashSet<AnonymizationStudySetup>(
			0);
	private Set<StaarAnonymizationRequest> staarAnonymizationRequestsForResearchStudyProtocolId = new HashSet<StaarAnonymizationRequest>(
			0);
	private Set<Patient> patients = new HashSet<Patient>(0);
	private Set<ProtocolAllele> protocolAlleles = new HashSet<ProtocolAllele>(0);
	private Set<AutoaccessionColumn> autoaccessionColumns = new HashSet<AutoaccessionColumn>(
			0);
	private Set<ProtocolGene> protocolGenes = new HashSet<ProtocolGene>(0);
	private Set<PgxModifyDataRptComment> pgxModifyDataRptComments = new HashSet<PgxModifyDataRptComment>(
			0);
	private Set<GenotypingVendProjDtls> genotypingVendProjDtlses = new HashSet<GenotypingVendProjDtls>(
			0);
	private Set<SampleIdentificationKey> sampleIdentificationKeies = new HashSet<SampleIdentificationKey>(
			0);
	private Set<InvestigatorProtocol> investigatorProtocols = new HashSet<InvestigatorProtocol>(
			0);

	public StudyProtocol() {
	}

	public StudyProtocol(BigDecimal studyProtocolId, String studyDirector) {
		this.studyProtocolId = studyProtocolId;
		this.studyDirector = studyDirector;
	}

	public StudyProtocol(
			BigDecimal studyProtocolId,
			OcxLoad ocxLoadByStudyVarOcx,
			OcxLoad ocxLoadByPatientVarOcx,
			Contact contact,
			Subsidiary subsidiary,
			OcxLoad ocxLoadByAccessionVarOcx,
			String studyNumber,
			String sponsorStudyNumber,
			String studyTitle,
			String studyDirector,
			String sponsorStudyTitle,
			Boolean cascadeAccessionNumber,
			BigDecimal barcodeLength,
			String finalTubeBarcodeLowValue,
			String finalTubeBarcodeHighValue,
			Boolean studyClosed,
			Boolean shipDnaBack,
			String studyUrl,
			String studyType,
			String createdBy,
			Date dateCreated,
			String modifiedBy,
			Date dateModified,
			Set<TestAccession> testAccessions,
			Set<VendorProjectAssay> vendorProjectAssaies,
			Set<StudyVariableFld> studyVariableFlds,
			Set<DnaDestructionRequest> dnaDestructionRequests,
			Set<OutboundRequest> outboundRequests,
			Set<GeneResult> geneResults,
			Set<ProtocolProcedure> protocolProcedures,
			Set<ProtocolTest> protocolTests,
			Set<ProtocolDefinedVariable> protocolDefinedVariables,
			Set<StaarAnonymizationRequest> staarAnonymizationRequestsForStudyProtocolId,
			Set<PgxModifyTemplateComment> pgxModifyTemplateComments,
			Set<PendingSampleTable> pendingSampleTables,
			Set<EventSubscription> eventSubscriptions,
			Set<PgxDataReport> pgxDataReports,
			Set<SampleReception> sampleReceptions,
			Set<Accession> accessions,
			Set<AnonymizationStudySetup> anonymizationStudySetups,
			Set<StaarAnonymizationRequest> staarAnonymizationRequestsForResearchStudyProtocolId,
			Set<Patient> patients, Set<ProtocolAllele> protocolAlleles,
			Set<AutoaccessionColumn> autoaccessionColumns,
			Set<ProtocolGene> protocolGenes,
			Set<PgxModifyDataRptComment> pgxModifyDataRptComments,
			Set<GenotypingVendProjDtls> genotypingVendProjDtlses,
			Set<SampleIdentificationKey> sampleIdentificationKeies,
			Set<InvestigatorProtocol> investigatorProtocols) {
		this.studyProtocolId = studyProtocolId;
		this.ocxLoadByStudyVarOcx = ocxLoadByStudyVarOcx;
		this.ocxLoadByPatientVarOcx = ocxLoadByPatientVarOcx;
		this.contact = contact;
		this.subsidiary = subsidiary;
		this.ocxLoadByAccessionVarOcx = ocxLoadByAccessionVarOcx;
		this.studyNumber = studyNumber;
		this.sponsorStudyNumber = sponsorStudyNumber;
		this.studyTitle = studyTitle;
		this.studyDirector = studyDirector;
		this.sponsorStudyTitle = sponsorStudyTitle;
		this.cascadeAccessionNumber = cascadeAccessionNumber;
		this.barcodeLength = barcodeLength;
		this.finalTubeBarcodeLowValue = finalTubeBarcodeLowValue;
		this.finalTubeBarcodeHighValue = finalTubeBarcodeHighValue;
		this.studyClosed = studyClosed;
		this.shipDnaBack = shipDnaBack;
		this.studyUrl = studyUrl;
		this.studyType = studyType;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.testAccessions = testAccessions;
		this.vendorProjectAssaies = vendorProjectAssaies;
		this.studyVariableFlds = studyVariableFlds;
		this.dnaDestructionRequests = dnaDestructionRequests;
		this.outboundRequests = outboundRequests;
		this.geneResults = geneResults;
		this.protocolProcedures = protocolProcedures;
		this.protocolTests = protocolTests;
		this.protocolDefinedVariables = protocolDefinedVariables;
		this.staarAnonymizationRequestsForStudyProtocolId = staarAnonymizationRequestsForStudyProtocolId;
		this.pgxModifyTemplateComments = pgxModifyTemplateComments;
		this.pendingSampleTables = pendingSampleTables;
		this.eventSubscriptions = eventSubscriptions;
		this.pgxDataReports = pgxDataReports;
		this.sampleReceptions = sampleReceptions;
		this.accessions = accessions;
		this.anonymizationStudySetups = anonymizationStudySetups;
		this.staarAnonymizationRequestsForResearchStudyProtocolId = staarAnonymizationRequestsForResearchStudyProtocolId;
		this.patients = patients;
		this.protocolAlleles = protocolAlleles;
		this.autoaccessionColumns = autoaccessionColumns;
		this.protocolGenes = protocolGenes;
		this.pgxModifyDataRptComments = pgxModifyDataRptComments;
		this.genotypingVendProjDtlses = genotypingVendProjDtlses;
		this.sampleIdentificationKeies = sampleIdentificationKeies;
		this.investigatorProtocols = investigatorProtocols;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public OcxLoad getOcxLoadByStudyVarOcx() {
		return this.ocxLoadByStudyVarOcx;
	}

	public void setOcxLoadByStudyVarOcx(OcxLoad ocxLoadByStudyVarOcx) {
		this.ocxLoadByStudyVarOcx = ocxLoadByStudyVarOcx;
	}

	public OcxLoad getOcxLoadByPatientVarOcx() {
		return this.ocxLoadByPatientVarOcx;
	}

	public void setOcxLoadByPatientVarOcx(OcxLoad ocxLoadByPatientVarOcx) {
		this.ocxLoadByPatientVarOcx = ocxLoadByPatientVarOcx;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public OcxLoad getOcxLoadByAccessionVarOcx() {
		return this.ocxLoadByAccessionVarOcx;
	}

	public void setOcxLoadByAccessionVarOcx(OcxLoad ocxLoadByAccessionVarOcx) {
		this.ocxLoadByAccessionVarOcx = ocxLoadByAccessionVarOcx;
	}

	public String getStudyNumber() {
		return this.studyNumber;
	}

	public void setStudyNumber(String studyNumber) {
		this.studyNumber = studyNumber;
	}

	public String getSponsorStudyNumber() {
		return this.sponsorStudyNumber;
	}

	public void setSponsorStudyNumber(String sponsorStudyNumber) {
		this.sponsorStudyNumber = sponsorStudyNumber;
	}

	public String getStudyTitle() {
		return this.studyTitle;
	}

	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}

	public String getStudyDirector() {
		return this.studyDirector;
	}

	public void setStudyDirector(String studyDirector) {
		this.studyDirector = studyDirector;
	}

	public String getSponsorStudyTitle() {
		return this.sponsorStudyTitle;
	}

	public void setSponsorStudyTitle(String sponsorStudyTitle) {
		this.sponsorStudyTitle = sponsorStudyTitle;
	}

	public Boolean getCascadeAccessionNumber() {
		return this.cascadeAccessionNumber;
	}

	public void setCascadeAccessionNumber(Boolean cascadeAccessionNumber) {
		this.cascadeAccessionNumber = cascadeAccessionNumber;
	}

	public BigDecimal getBarcodeLength() {
		return this.barcodeLength;
	}

	public void setBarcodeLength(BigDecimal barcodeLength) {
		this.barcodeLength = barcodeLength;
	}

	public String getFinalTubeBarcodeLowValue() {
		return this.finalTubeBarcodeLowValue;
	}

	public void setFinalTubeBarcodeLowValue(String finalTubeBarcodeLowValue) {
		this.finalTubeBarcodeLowValue = finalTubeBarcodeLowValue;
	}

	public String getFinalTubeBarcodeHighValue() {
		return this.finalTubeBarcodeHighValue;
	}

	public void setFinalTubeBarcodeHighValue(String finalTubeBarcodeHighValue) {
		this.finalTubeBarcodeHighValue = finalTubeBarcodeHighValue;
	}

	public Boolean getStudyClosed() {
		return this.studyClosed;
	}

	public void setStudyClosed(Boolean studyClosed) {
		this.studyClosed = studyClosed;
	}

	public Boolean getShipDnaBack() {
		return this.shipDnaBack;
	}

	public void setShipDnaBack(Boolean shipDnaBack) {
		this.shipDnaBack = shipDnaBack;
	}

	public String getStudyUrl() {
		return this.studyUrl;
	}

	public void setStudyUrl(String studyUrl) {
		this.studyUrl = studyUrl;
	}

	public String getStudyType() {
		return this.studyType;
	}

	public void setStudyType(String studyType) {
		this.studyType = studyType;
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

	public Set<TestAccession> getTestAccessions() {
		return this.testAccessions;
	}

	public void setTestAccessions(Set<TestAccession> testAccessions) {
		this.testAccessions = testAccessions;
	}

	public Set<VendorProjectAssay> getVendorProjectAssaies() {
		return this.vendorProjectAssaies;
	}

	public void setVendorProjectAssaies(
			Set<VendorProjectAssay> vendorProjectAssaies) {
		this.vendorProjectAssaies = vendorProjectAssaies;
	}

	public Set<StudyVariableFld> getStudyVariableFlds() {
		return this.studyVariableFlds;
	}

	public void setStudyVariableFlds(Set<StudyVariableFld> studyVariableFlds) {
		this.studyVariableFlds = studyVariableFlds;
	}

	public Set<DnaDestructionRequest> getDnaDestructionRequests() {
		return this.dnaDestructionRequests;
	}

	public void setDnaDestructionRequests(
			Set<DnaDestructionRequest> dnaDestructionRequests) {
		this.dnaDestructionRequests = dnaDestructionRequests;
	}

	public Set<OutboundRequest> getOutboundRequests() {
		return this.outboundRequests;
	}

	public void setOutboundRequests(Set<OutboundRequest> outboundRequests) {
		this.outboundRequests = outboundRequests;
	}

	public Set<GeneResult> getGeneResults() {
		return this.geneResults;
	}

	public void setGeneResults(Set<GeneResult> geneResults) {
		this.geneResults = geneResults;
	}

	public Set<ProtocolProcedure> getProtocolProcedures() {
		return this.protocolProcedures;
	}

	public void setProtocolProcedures(Set<ProtocolProcedure> protocolProcedures) {
		this.protocolProcedures = protocolProcedures;
	}

	public Set<ProtocolTest> getProtocolTests() {
		return this.protocolTests;
	}

	public void setProtocolTests(Set<ProtocolTest> protocolTests) {
		this.protocolTests = protocolTests;
	}

	public Set<ProtocolDefinedVariable> getProtocolDefinedVariables() {
		return this.protocolDefinedVariables;
	}

	public void setProtocolDefinedVariables(
			Set<ProtocolDefinedVariable> protocolDefinedVariables) {
		this.protocolDefinedVariables = protocolDefinedVariables;
	}

	public Set<StaarAnonymizationRequest> getStaarAnonymizationRequestsForStudyProtocolId() {
		return this.staarAnonymizationRequestsForStudyProtocolId;
	}

	public void setStaarAnonymizationRequestsForStudyProtocolId(
			Set<StaarAnonymizationRequest> staarAnonymizationRequestsForStudyProtocolId) {
		this.staarAnonymizationRequestsForStudyProtocolId = staarAnonymizationRequestsForStudyProtocolId;
	}

	public Set<PgxModifyTemplateComment> getPgxModifyTemplateComments() {
		return this.pgxModifyTemplateComments;
	}

	public void setPgxModifyTemplateComments(
			Set<PgxModifyTemplateComment> pgxModifyTemplateComments) {
		this.pgxModifyTemplateComments = pgxModifyTemplateComments;
	}

	public Set<PendingSampleTable> getPendingSampleTables() {
		return this.pendingSampleTables;
	}

	public void setPendingSampleTables(
			Set<PendingSampleTable> pendingSampleTables) {
		this.pendingSampleTables = pendingSampleTables;
	}

	public Set<EventSubscription> getEventSubscriptions() {
		return this.eventSubscriptions;
	}

	public void setEventSubscriptions(Set<EventSubscription> eventSubscriptions) {
		this.eventSubscriptions = eventSubscriptions;
	}

	public Set<PgxDataReport> getPgxDataReports() {
		return this.pgxDataReports;
	}

	public void setPgxDataReports(Set<PgxDataReport> pgxDataReports) {
		this.pgxDataReports = pgxDataReports;
	}

	public Set<SampleReception> getSampleReceptions() {
		return this.sampleReceptions;
	}

	public void setSampleReceptions(Set<SampleReception> sampleReceptions) {
		this.sampleReceptions = sampleReceptions;
	}

	public Set<Accession> getAccessions() {
		return this.accessions;
	}

	public void setAccessions(Set<Accession> accessions) {
		this.accessions = accessions;
	}

	public Set<AnonymizationStudySetup> getAnonymizationStudySetups() {
		return this.anonymizationStudySetups;
	}

	public void setAnonymizationStudySetups(
			Set<AnonymizationStudySetup> anonymizationStudySetups) {
		this.anonymizationStudySetups = anonymizationStudySetups;
	}

	public Set<StaarAnonymizationRequest> getStaarAnonymizationRequestsForResearchStudyProtocolId() {
		return this.staarAnonymizationRequestsForResearchStudyProtocolId;
	}

	public void setStaarAnonymizationRequestsForResearchStudyProtocolId(
			Set<StaarAnonymizationRequest> staarAnonymizationRequestsForResearchStudyProtocolId) {
		this.staarAnonymizationRequestsForResearchStudyProtocolId = staarAnonymizationRequestsForResearchStudyProtocolId;
	}

	public Set<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public Set<ProtocolAllele> getProtocolAlleles() {
		return this.protocolAlleles;
	}

	public void setProtocolAlleles(Set<ProtocolAllele> protocolAlleles) {
		this.protocolAlleles = protocolAlleles;
	}

	public Set<AutoaccessionColumn> getAutoaccessionColumns() {
		return this.autoaccessionColumns;
	}

	public void setAutoaccessionColumns(
			Set<AutoaccessionColumn> autoaccessionColumns) {
		this.autoaccessionColumns = autoaccessionColumns;
	}

	public Set<ProtocolGene> getProtocolGenes() {
		return this.protocolGenes;
	}

	public void setProtocolGenes(Set<ProtocolGene> protocolGenes) {
		this.protocolGenes = protocolGenes;
	}

	public Set<PgxModifyDataRptComment> getPgxModifyDataRptComments() {
		return this.pgxModifyDataRptComments;
	}

	public void setPgxModifyDataRptComments(
			Set<PgxModifyDataRptComment> pgxModifyDataRptComments) {
		this.pgxModifyDataRptComments = pgxModifyDataRptComments;
	}

	public Set<GenotypingVendProjDtls> getGenotypingVendProjDtlses() {
		return this.genotypingVendProjDtlses;
	}

	public void setGenotypingVendProjDtlses(
			Set<GenotypingVendProjDtls> genotypingVendProjDtlses) {
		this.genotypingVendProjDtlses = genotypingVendProjDtlses;
	}

	public Set<SampleIdentificationKey> getSampleIdentificationKeies() {
		return this.sampleIdentificationKeies;
	}

	public void setSampleIdentificationKeies(
			Set<SampleIdentificationKey> sampleIdentificationKeies) {
		this.sampleIdentificationKeies = sampleIdentificationKeies;
	}

	public Set<InvestigatorProtocol> getInvestigatorProtocols() {
		return this.investigatorProtocols;
	}

	public void setInvestigatorProtocols(
			Set<InvestigatorProtocol> investigatorProtocols) {
		this.investigatorProtocols = investigatorProtocols;
	}

}
