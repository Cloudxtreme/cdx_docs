package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudPgxModifyDataRptCom generated by hbm2java
 */
public class AudPgxModifyDataRptCom implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal pgxCommentId;
	private BigDecimal studyProtocolId;
	private BigDecimal setupTemplateId;
	private String modificationComments;
	private String createdBy;
	private Date dateCreated;
	private String fileName;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudPgxModifyDataRptCom() {
	}

	public AudPgxModifyDataRptCom(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudPgxModifyDataRptCom(BigDecimal auditId,
			BigDecimal changeReasonId, BigDecimal pgxCommentId,
			BigDecimal studyProtocolId, BigDecimal setupTemplateId,
			String modificationComments, String createdBy, Date dateCreated,
			String fileName, String changedBy, Date dateChanged,
			String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.pgxCommentId = pgxCommentId;
		this.studyProtocolId = studyProtocolId;
		this.setupTemplateId = setupTemplateId;
		this.modificationComments = modificationComments;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.fileName = fileName;
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

	public BigDecimal getPgxCommentId() {
		return this.pgxCommentId;
	}

	public void setPgxCommentId(BigDecimal pgxCommentId) {
		this.pgxCommentId = pgxCommentId;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public BigDecimal getSetupTemplateId() {
		return this.setupTemplateId;
	}

	public void setSetupTemplateId(BigDecimal setupTemplateId) {
		this.setupTemplateId = setupTemplateId;
	}

	public String getModificationComments() {
		return this.modificationComments;
	}

	public void setModificationComments(String modificationComments) {
		this.modificationComments = modificationComments;
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

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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