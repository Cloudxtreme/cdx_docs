package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Approval generated by hbm2java
 */
public class Approval implements java.io.Serializable {

	private BigDecimal approvalId;
	private Checklist checklist;
	private Subsidiary subsidiary;
	private String approvalName;
	private String approvalStatus;
	private String username;
	private String rolename;
	private String md5digest;
	private BigDecimal checklistRow;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

	public Approval() {
	}

	public Approval(BigDecimal approvalId, String createdBy, Date dateCreated) {
		this.approvalId = approvalId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public Approval(BigDecimal approvalId, Checklist checklist,
			Subsidiary subsidiary, String approvalName, String approvalStatus,
			String username, String rolename, String md5digest,
			BigDecimal checklistRow, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified) {
		this.approvalId = approvalId;
		this.checklist = checklist;
		this.subsidiary = subsidiary;
		this.approvalName = approvalName;
		this.approvalStatus = approvalStatus;
		this.username = username;
		this.rolename = rolename;
		this.md5digest = md5digest;
		this.checklistRow = checklistRow;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getApprovalId() {
		return this.approvalId;
	}

	public void setApprovalId(BigDecimal approvalId) {
		this.approvalId = approvalId;
	}

	public Checklist getChecklist() {
		return this.checklist;
	}

	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getApprovalName() {
		return this.approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getMd5digest() {
		return this.md5digest;
	}

	public void setMd5digest(String md5digest) {
		this.md5digest = md5digest;
	}

	public BigDecimal getChecklistRow() {
		return this.checklistRow;
	}

	public void setChecklistRow(BigDecimal checklistRow) {
		this.checklistRow = checklistRow;
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

}