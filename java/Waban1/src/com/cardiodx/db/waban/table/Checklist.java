package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Checklist generated by hbm2java
 */
public class Checklist implements java.io.Serializable {

	private BigDecimal checklistId;
	private ProcedureTemplate procedureTemplate;
	private Subsidiary subsidiary;
	private String assignedTo;
	private Boolean completed;
	private Date dateCompleted;
	private String createdBy;
	private Date dateCreated;
	private String lockedBy;
	private Date dateLocked;
	private Boolean isAnalytical;
	private String checklistName;
	private BigDecimal sessionId;
	private String assignedToRole;
	private Set<Wordreport> wordreports = new HashSet<Wordreport>(0);
	private Set<ChecklistContent> checklistContents = new HashSet<ChecklistContent>(
			0);
	private Set<Transfer> transfers = new HashSet<Transfer>(0);
	private Set<SampleInstrumentAssoc> sampleInstrumentAssocs = new HashSet<SampleInstrumentAssoc>(
			0);
	private Set<Approval> approvals = new HashSet<Approval>(0);
	private Set<RecordTimer> recordTimers = new HashSet<RecordTimer>(0);
	private Set<TraceQc> traceQcs = new HashSet<TraceQc>(0);
	private Set<MtpSample> mtpSamples = new HashSet<MtpSample>(0);
	private Set<SeqSetup> seqSetups = new HashSet<SeqSetup>(0);
	private Set<ChecklistSample> checklistSamples = new HashSet<ChecklistSample>(
			0);
	private Set<Deadline> deadlines = new HashSet<Deadline>(0);
	private Set<CpRun> cpRuns = new HashSet<CpRun>(0);
	private Set<ConcentrationAdjustment> concentrationAdjustments = new HashSet<ConcentrationAdjustment>(
			0);
	private Set<DnaDestructionVendor> dnaDestructionVendors = new HashSet<DnaDestructionVendor>(
			0);
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<PlateTemplateContainer> plateTemplateContainers = new HashSet<PlateTemplateContainer>(
			0);
	private Set<ChecklistReagent> checklistReagents = new HashSet<ChecklistReagent>(
			0);
	private Set<AssignInstrument> assignInstruments = new HashSet<AssignInstrument>(
			0);
	private Set<StaarAnonymizationRequest> staarAnonymizationRequests = new HashSet<StaarAnonymizationRequest>(
			0);
	private Set<AnonymizationQuery> anonymizationQueries = new HashSet<AnonymizationQuery>(
			0);
	private Set<AssayResultLoad> assayResultLoads = new HashSet<AssayResultLoad>(
			0);
	private Set<MasterMixReagent> masterMixReagents = new HashSet<MasterMixReagent>(
			0);
	private Set<PcrSetup> pcrSetups = new HashSet<PcrSetup>(0);
	private Set<ContainerBatch> containerBatchs = new HashSet<ContainerBatch>(0);
	private Set<CdxChlistFileValue> cdxChlistFileValues = new HashSet<CdxChlistFileValue>(
			0);
	private Set<OutboundRequest> outboundRequests = new HashSet<OutboundRequest>(
			0);
	private Set<SampleReception> sampleReceptions = new HashSet<SampleReception>(
			0);
	private Set<Measurement> measurements = new HashSet<Measurement>(0);
	private Set<AssayResult> assayResults = new HashSet<AssayResult>(0);
	private Set<PcrCleanup> pcrCleanups = new HashSet<PcrCleanup>(0);
	private Set<CaseRoiHistory> caseRoiHistories = new HashSet<CaseRoiHistory>(
			0);
	private Set<DnaDestructionRequest> dnaDestructionRequests = new HashSet<DnaDestructionRequest>(
			0);
	private Set<WorkflowProcChecklist> workflowProcChecklists = new HashSet<WorkflowProcChecklist>(
			0);

	public Checklist() {
	}

	public Checklist(BigDecimal checklistId, ProcedureTemplate procedureTemplate) {
		this.checklistId = checklistId;
		this.procedureTemplate = procedureTemplate;
	}

	public Checklist(BigDecimal checklistId,
			ProcedureTemplate procedureTemplate, Subsidiary subsidiary,
			String assignedTo, Boolean completed, Date dateCompleted,
			String createdBy, Date dateCreated, String lockedBy,
			Date dateLocked, Boolean isAnalytical, String checklistName,
			BigDecimal sessionId, String assignedToRole,
			Set<Wordreport> wordreports,
			Set<ChecklistContent> checklistContents, Set<Transfer> transfers,
			Set<SampleInstrumentAssoc> sampleInstrumentAssocs,
			Set<Approval> approvals, Set<RecordTimer> recordTimers,
			Set<TraceQc> traceQcs, Set<MtpSample> mtpSamples,
			Set<SeqSetup> seqSetups, Set<ChecklistSample> checklistSamples,
			Set<Deadline> deadlines, Set<CpRun> cpRuns,
			Set<ConcentrationAdjustment> concentrationAdjustments,
			Set<DnaDestructionVendor> dnaDestructionVendors,
			Set<Review> reviews,
			Set<PlateTemplateContainer> plateTemplateContainers,
			Set<ChecklistReagent> checklistReagents,
			Set<AssignInstrument> assignInstruments,
			Set<StaarAnonymizationRequest> staarAnonymizationRequests,
			Set<AnonymizationQuery> anonymizationQueries,
			Set<AssayResultLoad> assayResultLoads,
			Set<MasterMixReagent> masterMixReagents, Set<PcrSetup> pcrSetups,
			Set<ContainerBatch> containerBatchs,
			Set<CdxChlistFileValue> cdxChlistFileValues,
			Set<OutboundRequest> outboundRequests,
			Set<SampleReception> sampleReceptions,
			Set<Measurement> measurements, Set<AssayResult> assayResults,
			Set<PcrCleanup> pcrCleanups, Set<CaseRoiHistory> caseRoiHistories,
			Set<DnaDestructionRequest> dnaDestructionRequests,
			Set<WorkflowProcChecklist> workflowProcChecklists) {
		this.checklistId = checklistId;
		this.procedureTemplate = procedureTemplate;
		this.subsidiary = subsidiary;
		this.assignedTo = assignedTo;
		this.completed = completed;
		this.dateCompleted = dateCompleted;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lockedBy = lockedBy;
		this.dateLocked = dateLocked;
		this.isAnalytical = isAnalytical;
		this.checklistName = checklistName;
		this.sessionId = sessionId;
		this.assignedToRole = assignedToRole;
		this.wordreports = wordreports;
		this.checklistContents = checklistContents;
		this.transfers = transfers;
		this.sampleInstrumentAssocs = sampleInstrumentAssocs;
		this.approvals = approvals;
		this.recordTimers = recordTimers;
		this.traceQcs = traceQcs;
		this.mtpSamples = mtpSamples;
		this.seqSetups = seqSetups;
		this.checklistSamples = checklistSamples;
		this.deadlines = deadlines;
		this.cpRuns = cpRuns;
		this.concentrationAdjustments = concentrationAdjustments;
		this.dnaDestructionVendors = dnaDestructionVendors;
		this.reviews = reviews;
		this.plateTemplateContainers = plateTemplateContainers;
		this.checklistReagents = checklistReagents;
		this.assignInstruments = assignInstruments;
		this.staarAnonymizationRequests = staarAnonymizationRequests;
		this.anonymizationQueries = anonymizationQueries;
		this.assayResultLoads = assayResultLoads;
		this.masterMixReagents = masterMixReagents;
		this.pcrSetups = pcrSetups;
		this.containerBatchs = containerBatchs;
		this.cdxChlistFileValues = cdxChlistFileValues;
		this.outboundRequests = outboundRequests;
		this.sampleReceptions = sampleReceptions;
		this.measurements = measurements;
		this.assayResults = assayResults;
		this.pcrCleanups = pcrCleanups;
		this.caseRoiHistories = caseRoiHistories;
		this.dnaDestructionRequests = dnaDestructionRequests;
		this.workflowProcChecklists = workflowProcChecklists;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public ProcedureTemplate getProcedureTemplate() {
		return this.procedureTemplate;
	}

	public void setProcedureTemplate(ProcedureTemplate procedureTemplate) {
		this.procedureTemplate = procedureTemplate;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getAssignedTo() {
		return this.assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Boolean getCompleted() {
		return this.completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Date getDateCompleted() {
		return this.dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
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

	public String getLockedBy() {
		return this.lockedBy;
	}

	public void setLockedBy(String lockedBy) {
		this.lockedBy = lockedBy;
	}

	public Date getDateLocked() {
		return this.dateLocked;
	}

	public void setDateLocked(Date dateLocked) {
		this.dateLocked = dateLocked;
	}

	public Boolean getIsAnalytical() {
		return this.isAnalytical;
	}

	public void setIsAnalytical(Boolean isAnalytical) {
		this.isAnalytical = isAnalytical;
	}

	public String getChecklistName() {
		return this.checklistName;
	}

	public void setChecklistName(String checklistName) {
		this.checklistName = checklistName;
	}

	public BigDecimal getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(BigDecimal sessionId) {
		this.sessionId = sessionId;
	}

	public String getAssignedToRole() {
		return this.assignedToRole;
	}

	public void setAssignedToRole(String assignedToRole) {
		this.assignedToRole = assignedToRole;
	}

	public Set<Wordreport> getWordreports() {
		return this.wordreports;
	}

	public void setWordreports(Set<Wordreport> wordreports) {
		this.wordreports = wordreports;
	}

	public Set<ChecklistContent> getChecklistContents() {
		return this.checklistContents;
	}

	public void setChecklistContents(Set<ChecklistContent> checklistContents) {
		this.checklistContents = checklistContents;
	}

	public Set<Transfer> getTransfers() {
		return this.transfers;
	}

	public void setTransfers(Set<Transfer> transfers) {
		this.transfers = transfers;
	}

	public Set<SampleInstrumentAssoc> getSampleInstrumentAssocs() {
		return this.sampleInstrumentAssocs;
	}

	public void setSampleInstrumentAssocs(
			Set<SampleInstrumentAssoc> sampleInstrumentAssocs) {
		this.sampleInstrumentAssocs = sampleInstrumentAssocs;
	}

	public Set<Approval> getApprovals() {
		return this.approvals;
	}

	public void setApprovals(Set<Approval> approvals) {
		this.approvals = approvals;
	}

	public Set<RecordTimer> getRecordTimers() {
		return this.recordTimers;
	}

	public void setRecordTimers(Set<RecordTimer> recordTimers) {
		this.recordTimers = recordTimers;
	}

	public Set<TraceQc> getTraceQcs() {
		return this.traceQcs;
	}

	public void setTraceQcs(Set<TraceQc> traceQcs) {
		this.traceQcs = traceQcs;
	}

	public Set<MtpSample> getMtpSamples() {
		return this.mtpSamples;
	}

	public void setMtpSamples(Set<MtpSample> mtpSamples) {
		this.mtpSamples = mtpSamples;
	}

	public Set<SeqSetup> getSeqSetups() {
		return this.seqSetups;
	}

	public void setSeqSetups(Set<SeqSetup> seqSetups) {
		this.seqSetups = seqSetups;
	}

	public Set<ChecklistSample> getChecklistSamples() {
		return this.checklistSamples;
	}

	public void setChecklistSamples(Set<ChecklistSample> checklistSamples) {
		this.checklistSamples = checklistSamples;
	}

	public Set<Deadline> getDeadlines() {
		return this.deadlines;
	}

	public void setDeadlines(Set<Deadline> deadlines) {
		this.deadlines = deadlines;
	}

	public Set<CpRun> getCpRuns() {
		return this.cpRuns;
	}

	public void setCpRuns(Set<CpRun> cpRuns) {
		this.cpRuns = cpRuns;
	}

	public Set<ConcentrationAdjustment> getConcentrationAdjustments() {
		return this.concentrationAdjustments;
	}

	public void setConcentrationAdjustments(
			Set<ConcentrationAdjustment> concentrationAdjustments) {
		this.concentrationAdjustments = concentrationAdjustments;
	}

	public Set<DnaDestructionVendor> getDnaDestructionVendors() {
		return this.dnaDestructionVendors;
	}

	public void setDnaDestructionVendors(
			Set<DnaDestructionVendor> dnaDestructionVendors) {
		this.dnaDestructionVendors = dnaDestructionVendors;
	}

	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<PlateTemplateContainer> getPlateTemplateContainers() {
		return this.plateTemplateContainers;
	}

	public void setPlateTemplateContainers(
			Set<PlateTemplateContainer> plateTemplateContainers) {
		this.plateTemplateContainers = plateTemplateContainers;
	}

	public Set<ChecklistReagent> getChecklistReagents() {
		return this.checklistReagents;
	}

	public void setChecklistReagents(Set<ChecklistReagent> checklistReagents) {
		this.checklistReagents = checklistReagents;
	}

	public Set<AssignInstrument> getAssignInstruments() {
		return this.assignInstruments;
	}

	public void setAssignInstruments(Set<AssignInstrument> assignInstruments) {
		this.assignInstruments = assignInstruments;
	}

	public Set<StaarAnonymizationRequest> getStaarAnonymizationRequests() {
		return this.staarAnonymizationRequests;
	}

	public void setStaarAnonymizationRequests(
			Set<StaarAnonymizationRequest> staarAnonymizationRequests) {
		this.staarAnonymizationRequests = staarAnonymizationRequests;
	}

	public Set<AnonymizationQuery> getAnonymizationQueries() {
		return this.anonymizationQueries;
	}

	public void setAnonymizationQueries(
			Set<AnonymizationQuery> anonymizationQueries) {
		this.anonymizationQueries = anonymizationQueries;
	}

	public Set<AssayResultLoad> getAssayResultLoads() {
		return this.assayResultLoads;
	}

	public void setAssayResultLoads(Set<AssayResultLoad> assayResultLoads) {
		this.assayResultLoads = assayResultLoads;
	}

	public Set<MasterMixReagent> getMasterMixReagents() {
		return this.masterMixReagents;
	}

	public void setMasterMixReagents(Set<MasterMixReagent> masterMixReagents) {
		this.masterMixReagents = masterMixReagents;
	}

	public Set<PcrSetup> getPcrSetups() {
		return this.pcrSetups;
	}

	public void setPcrSetups(Set<PcrSetup> pcrSetups) {
		this.pcrSetups = pcrSetups;
	}

	public Set<ContainerBatch> getContainerBatchs() {
		return this.containerBatchs;
	}

	public void setContainerBatchs(Set<ContainerBatch> containerBatchs) {
		this.containerBatchs = containerBatchs;
	}

	public Set<CdxChlistFileValue> getCdxChlistFileValues() {
		return this.cdxChlistFileValues;
	}

	public void setCdxChlistFileValues(
			Set<CdxChlistFileValue> cdxChlistFileValues) {
		this.cdxChlistFileValues = cdxChlistFileValues;
	}

	public Set<OutboundRequest> getOutboundRequests() {
		return this.outboundRequests;
	}

	public void setOutboundRequests(Set<OutboundRequest> outboundRequests) {
		this.outboundRequests = outboundRequests;
	}

	public Set<SampleReception> getSampleReceptions() {
		return this.sampleReceptions;
	}

	public void setSampleReceptions(Set<SampleReception> sampleReceptions) {
		this.sampleReceptions = sampleReceptions;
	}

	public Set<Measurement> getMeasurements() {
		return this.measurements;
	}

	public void setMeasurements(Set<Measurement> measurements) {
		this.measurements = measurements;
	}

	public Set<AssayResult> getAssayResults() {
		return this.assayResults;
	}

	public void setAssayResults(Set<AssayResult> assayResults) {
		this.assayResults = assayResults;
	}

	public Set<PcrCleanup> getPcrCleanups() {
		return this.pcrCleanups;
	}

	public void setPcrCleanups(Set<PcrCleanup> pcrCleanups) {
		this.pcrCleanups = pcrCleanups;
	}

	public Set<CaseRoiHistory> getCaseRoiHistories() {
		return this.caseRoiHistories;
	}

	public void setCaseRoiHistories(Set<CaseRoiHistory> caseRoiHistories) {
		this.caseRoiHistories = caseRoiHistories;
	}

	public Set<DnaDestructionRequest> getDnaDestructionRequests() {
		return this.dnaDestructionRequests;
	}

	public void setDnaDestructionRequests(
			Set<DnaDestructionRequest> dnaDestructionRequests) {
		this.dnaDestructionRequests = dnaDestructionRequests;
	}

	public Set<WorkflowProcChecklist> getWorkflowProcChecklists() {
		return this.workflowProcChecklists;
	}

	public void setWorkflowProcChecklists(
			Set<WorkflowProcChecklist> workflowProcChecklists) {
		this.workflowProcChecklists = workflowProcChecklists;
	}

}