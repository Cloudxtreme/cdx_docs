package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudStaarAnonRequest generated by hbm2java
 */
public class AudStaarAnonRequest implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal staarAnonymizationRequestId;
	private BigDecimal studyProtocolId;
	private String requestStatus;
	private String requestMessage;
	private BigDecimal checklistId;
	private Date dateCreated;
	private String createdBy;
	private String samplesReaccessioned;
	private String reaccessionedBy;
	private Date dateReaccessioned;
	private String clinicalDataImported;
	private String clinicalDataImportedBy;
	private Date dateClinicalDataImported;
	private String isStudyClosed;
	private String studyClosedBy;
	private Date dateStudyClosed;
	private BigDecimal researchStudyProtocolId;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudStaarAnonRequest() {
	}

	public AudStaarAnonRequest(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudStaarAnonRequest(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal staarAnonymizationRequestId, BigDecimal studyProtocolId,
			String requestStatus, String requestMessage,
			BigDecimal checklistId, Date dateCreated, String createdBy,
			String samplesReaccessioned, String reaccessionedBy,
			Date dateReaccessioned, String clinicalDataImported,
			String clinicalDataImportedBy, Date dateClinicalDataImported,
			String isStudyClosed, String studyClosedBy, Date dateStudyClosed,
			BigDecimal researchStudyProtocolId, String changedBy,
			Date dateChanged, String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.staarAnonymizationRequestId = staarAnonymizationRequestId;
		this.studyProtocolId = studyProtocolId;
		this.requestStatus = requestStatus;
		this.requestMessage = requestMessage;
		this.checklistId = checklistId;
		this.dateCreated = dateCreated;
		this.createdBy = createdBy;
		this.samplesReaccessioned = samplesReaccessioned;
		this.reaccessionedBy = reaccessionedBy;
		this.dateReaccessioned = dateReaccessioned;
		this.clinicalDataImported = clinicalDataImported;
		this.clinicalDataImportedBy = clinicalDataImportedBy;
		this.dateClinicalDataImported = dateClinicalDataImported;
		this.isStudyClosed = isStudyClosed;
		this.studyClosedBy = studyClosedBy;
		this.dateStudyClosed = dateStudyClosed;
		this.researchStudyProtocolId = researchStudyProtocolId;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
		this.subsidiaryId = subsidiaryId;
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

	public BigDecimal getStaarAnonymizationRequestId() {
		return this.staarAnonymizationRequestId;
	}

	public void setStaarAnonymizationRequestId(
			BigDecimal staarAnonymizationRequestId) {
		this.staarAnonymizationRequestId = staarAnonymizationRequestId;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public String getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getRequestMessage() {
		return this.requestMessage;
	}

	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSamplesReaccessioned() {
		return this.samplesReaccessioned;
	}

	public void setSamplesReaccessioned(String samplesReaccessioned) {
		this.samplesReaccessioned = samplesReaccessioned;
	}

	public String getReaccessionedBy() {
		return this.reaccessionedBy;
	}

	public void setReaccessionedBy(String reaccessionedBy) {
		this.reaccessionedBy = reaccessionedBy;
	}

	public Date getDateReaccessioned() {
		return this.dateReaccessioned;
	}

	public void setDateReaccessioned(Date dateReaccessioned) {
		this.dateReaccessioned = dateReaccessioned;
	}

	public String getClinicalDataImported() {
		return this.clinicalDataImported;
	}

	public void setClinicalDataImported(String clinicalDataImported) {
		this.clinicalDataImported = clinicalDataImported;
	}

	public String getClinicalDataImportedBy() {
		return this.clinicalDataImportedBy;
	}

	public void setClinicalDataImportedBy(String clinicalDataImportedBy) {
		this.clinicalDataImportedBy = clinicalDataImportedBy;
	}

	public Date getDateClinicalDataImported() {
		return this.dateClinicalDataImported;
	}

	public void setDateClinicalDataImported(Date dateClinicalDataImported) {
		this.dateClinicalDataImported = dateClinicalDataImported;
	}

	public String getIsStudyClosed() {
		return this.isStudyClosed;
	}

	public void setIsStudyClosed(String isStudyClosed) {
		this.isStudyClosed = isStudyClosed;
	}

	public String getStudyClosedBy() {
		return this.studyClosedBy;
	}

	public void setStudyClosedBy(String studyClosedBy) {
		this.studyClosedBy = studyClosedBy;
	}

	public Date getDateStudyClosed() {
		return this.dateStudyClosed;
	}

	public void setDateStudyClosed(Date dateStudyClosed) {
		this.dateStudyClosed = dateStudyClosed;
	}

	public BigDecimal getResearchStudyProtocolId() {
		return this.researchStudyProtocolId;
	}

	public void setResearchStudyProtocolId(BigDecimal researchStudyProtocolId) {
		this.researchStudyProtocolId = researchStudyProtocolId;
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

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

}