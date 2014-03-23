package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudContainerMap generated by hbm2java
 */
public class AudContainerMap implements java.io.Serializable {

	private BigDecimal auditId;
	private BigDecimal changeReasonId;
	private BigDecimal containerMapId;
	private String type;
	private BigDecimal containerRows;
	private BigDecimal containerColumns;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;

	public AudContainerMap() {
	}

	public AudContainerMap(BigDecimal auditId, BigDecimal containerMapId) {
		this.auditId = auditId;
		this.containerMapId = containerMapId;
	}

	public AudContainerMap(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal containerMapId, String type, BigDecimal containerRows,
			BigDecimal containerColumns, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified, String changedBy,
			Date dateChanged, String changeType) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.containerMapId = containerMapId;
		this.type = type;
		this.containerRows = containerRows;
		this.containerColumns = containerColumns;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.changeType = changeType;
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

	public BigDecimal getContainerMapId() {
		return this.containerMapId;
	}

	public void setContainerMapId(BigDecimal containerMapId) {
		this.containerMapId = containerMapId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getContainerRows() {
		return this.containerRows;
	}

	public void setContainerRows(BigDecimal containerRows) {
		this.containerRows = containerRows;
	}

	public BigDecimal getContainerColumns() {
		return this.containerColumns;
	}

	public void setContainerColumns(BigDecimal containerColumns) {
		this.containerColumns = containerColumns;
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

}
