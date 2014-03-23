package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudDeadline generated by hbm2java
 */
public class AudDeadline implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal deadlineId;
	private BigDecimal checklistId;
	private String userName;
	private String userOrRole;
	private String noDays;
	private String notificationFrequency;
	private Date deadlineDate;
	private Date lastNotifiedDate;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudDeadline() {
	}

	public AudDeadline(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudDeadline(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal deadlineId, BigDecimal checklistId, String userName,
			String userOrRole, String noDays, String notificationFrequency,
			Date deadlineDate, Date lastNotifiedDate, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			String changedBy, Date dateChanged, String changeType,
			BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.deadlineId = deadlineId;
		this.checklistId = checklistId;
		this.userName = userName;
		this.userOrRole = userOrRole;
		this.noDays = noDays;
		this.notificationFrequency = notificationFrequency;
		this.deadlineDate = deadlineDate;
		this.lastNotifiedDate = lastNotifiedDate;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
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

	public BigDecimal getDeadlineId() {
		return this.deadlineId;
	}

	public void setDeadlineId(BigDecimal deadlineId) {
		this.deadlineId = deadlineId;
	}

	public BigDecimal getChecklistId() {
		return this.checklistId;
	}

	public void setChecklistId(BigDecimal checklistId) {
		this.checklistId = checklistId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserOrRole() {
		return this.userOrRole;
	}

	public void setUserOrRole(String userOrRole) {
		this.userOrRole = userOrRole;
	}

	public String getNoDays() {
		return this.noDays;
	}

	public void setNoDays(String noDays) {
		this.noDays = noDays;
	}

	public String getNotificationFrequency() {
		return this.notificationFrequency;
	}

	public void setNotificationFrequency(String notificationFrequency) {
		this.notificationFrequency = notificationFrequency;
	}

	public Date getDeadlineDate() {
		return this.deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public Date getLastNotifiedDate() {
		return this.lastNotifiedDate;
	}

	public void setLastNotifiedDate(Date lastNotifiedDate) {
		this.lastNotifiedDate = lastNotifiedDate;
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
