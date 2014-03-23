package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudPgxModifyTemplateCom generated by hbm2java
 */
public class AudPgxModifyTemplateCom implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal pgxModifyCommentId;
	private BigDecimal studyProtocolId;
	private BigDecimal pgxGeneId;
	private String modificationComments;
	private String createdBy;
	private Date dateCreated;
	private String fileName;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudPgxModifyTemplateCom() {
	}

	public AudPgxModifyTemplateCom(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudPgxModifyTemplateCom(BigDecimal auditId,
			BigDecimal changeReasonId, BigDecimal pgxModifyCommentId,
			BigDecimal studyProtocolId, BigDecimal pgxGeneId,
			String modificationComments, String createdBy, Date dateCreated,
			String fileName, String changedBy, Date dateChanged,
			String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.pgxModifyCommentId = pgxModifyCommentId;
		this.studyProtocolId = studyProtocolId;
		this.pgxGeneId = pgxGeneId;
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

	public BigDecimal getPgxModifyCommentId() {
		return this.pgxModifyCommentId;
	}

	public void setPgxModifyCommentId(BigDecimal pgxModifyCommentId) {
		this.pgxModifyCommentId = pgxModifyCommentId;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public BigDecimal getPgxGeneId() {
		return this.pgxGeneId;
	}

	public void setPgxGeneId(BigDecimal pgxGeneId) {
		this.pgxGeneId = pgxGeneId;
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
