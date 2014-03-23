package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudMaintenanceSchedule generated by hbm2java
 */
public class AudMaintenanceSchedule implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal maintenanceScheduleId;
	private BigDecimal instrumentSetupId;
	private Date scheduleDate;
	private String scheduleTime;
	private Date actualDownDate;
	private String actualDownTime;
	private Date actualUpDate;
	private String actualUpTime;
	private String status;
	private String createdBy;
	private Date dateCreated;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudMaintenanceSchedule() {
	}

	public AudMaintenanceSchedule(BigDecimal auditId) {
		this.auditId = auditId;
	}

	public AudMaintenanceSchedule(BigDecimal auditId,
			BigDecimal changeReasonId, BigDecimal maintenanceScheduleId,
			BigDecimal instrumentSetupId, Date scheduleDate,
			String scheduleTime, Date actualDownDate, String actualDownTime,
			Date actualUpDate, String actualUpTime, String status,
			String createdBy, Date dateCreated, String changedBy,
			Date dateChanged, String changeType, BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.maintenanceScheduleId = maintenanceScheduleId;
		this.instrumentSetupId = instrumentSetupId;
		this.scheduleDate = scheduleDate;
		this.scheduleTime = scheduleTime;
		this.actualDownDate = actualDownDate;
		this.actualDownTime = actualDownTime;
		this.actualUpDate = actualUpDate;
		this.actualUpTime = actualUpTime;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
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

	public BigDecimal getMaintenanceScheduleId() {
		return this.maintenanceScheduleId;
	}

	public void setMaintenanceScheduleId(BigDecimal maintenanceScheduleId) {
		this.maintenanceScheduleId = maintenanceScheduleId;
	}

	public BigDecimal getInstrumentSetupId() {
		return this.instrumentSetupId;
	}

	public void setInstrumentSetupId(BigDecimal instrumentSetupId) {
		this.instrumentSetupId = instrumentSetupId;
	}

	public Date getScheduleDate() {
		return this.scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleTime() {
		return this.scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Date getActualDownDate() {
		return this.actualDownDate;
	}

	public void setActualDownDate(Date actualDownDate) {
		this.actualDownDate = actualDownDate;
	}

	public String getActualDownTime() {
		return this.actualDownTime;
	}

	public void setActualDownTime(String actualDownTime) {
		this.actualDownTime = actualDownTime;
	}

	public Date getActualUpDate() {
		return this.actualUpDate;
	}

	public void setActualUpDate(Date actualUpDate) {
		this.actualUpDate = actualUpDate;
	}

	public String getActualUpTime() {
		return this.actualUpTime;
	}

	public void setActualUpTime(String actualUpTime) {
		this.actualUpTime = actualUpTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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