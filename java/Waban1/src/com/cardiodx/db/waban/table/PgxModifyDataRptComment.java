package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

/**
 * PgxModifyDataRptComment generated by hbm2java
 */
public class PgxModifyDataRptComment implements java.io.Serializable {

	private BigDecimal pgxCommentId;
	private PgxSetupTemplate pgxSetupTemplate;
	private StudyProtocol studyProtocol;
	private Subsidiary subsidiary;
	private String modificationComments;
	private String createdBy;
	private Date dateCreated;
	private Blob fileBlob;
	private String fileName;

	public PgxModifyDataRptComment() {
	}

	public PgxModifyDataRptComment(BigDecimal pgxCommentId,
			PgxSetupTemplate pgxSetupTemplate, StudyProtocol studyProtocol) {
		this.pgxCommentId = pgxCommentId;
		this.pgxSetupTemplate = pgxSetupTemplate;
		this.studyProtocol = studyProtocol;
	}

	public PgxModifyDataRptComment(BigDecimal pgxCommentId,
			PgxSetupTemplate pgxSetupTemplate, StudyProtocol studyProtocol,
			Subsidiary subsidiary, String modificationComments,
			String createdBy, Date dateCreated, Blob fileBlob, String fileName) {
		this.pgxCommentId = pgxCommentId;
		this.pgxSetupTemplate = pgxSetupTemplate;
		this.studyProtocol = studyProtocol;
		this.subsidiary = subsidiary;
		this.modificationComments = modificationComments;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.fileBlob = fileBlob;
		this.fileName = fileName;
	}

	public BigDecimal getPgxCommentId() {
		return this.pgxCommentId;
	}

	public void setPgxCommentId(BigDecimal pgxCommentId) {
		this.pgxCommentId = pgxCommentId;
	}

	public PgxSetupTemplate getPgxSetupTemplate() {
		return this.pgxSetupTemplate;
	}

	public void setPgxSetupTemplate(PgxSetupTemplate pgxSetupTemplate) {
		this.pgxSetupTemplate = pgxSetupTemplate;
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

	public Blob getFileBlob() {
		return this.fileBlob;
	}

	public void setFileBlob(Blob fileBlob) {
		this.fileBlob = fileBlob;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
