package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * PcrCleanupContainer generated by hbm2java
 */
public class PcrCleanupContainer implements java.io.Serializable {

	private BigDecimal pcrContainerId;
	private Container containerByFilterContainerId;
	private Container containerByElutionContainerId;
	private String pcrclContainerId;
	private BigDecimal pcrCleanupId;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;

	public PcrCleanupContainer() {
	}

	public PcrCleanupContainer(BigDecimal pcrContainerId) {
		this.pcrContainerId = pcrContainerId;
	}

	public PcrCleanupContainer(BigDecimal pcrContainerId,
			Container containerByFilterContainerId,
			Container containerByElutionContainerId, String pcrclContainerId,
			BigDecimal pcrCleanupId, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified, BigDecimal subsidiaryId) {
		this.pcrContainerId = pcrContainerId;
		this.containerByFilterContainerId = containerByFilterContainerId;
		this.containerByElutionContainerId = containerByElutionContainerId;
		this.pcrclContainerId = pcrclContainerId;
		this.pcrCleanupId = pcrCleanupId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getPcrContainerId() {
		return this.pcrContainerId;
	}

	public void setPcrContainerId(BigDecimal pcrContainerId) {
		this.pcrContainerId = pcrContainerId;
	}

	public Container getContainerByFilterContainerId() {
		return this.containerByFilterContainerId;
	}

	public void setContainerByFilterContainerId(
			Container containerByFilterContainerId) {
		this.containerByFilterContainerId = containerByFilterContainerId;
	}

	public Container getContainerByElutionContainerId() {
		return this.containerByElutionContainerId;
	}

	public void setContainerByElutionContainerId(
			Container containerByElutionContainerId) {
		this.containerByElutionContainerId = containerByElutionContainerId;
	}

	public String getPcrclContainerId() {
		return this.pcrclContainerId;
	}

	public void setPcrclContainerId(String pcrclContainerId) {
		this.pcrclContainerId = pcrclContainerId;
	}

	public BigDecimal getPcrCleanupId() {
		return this.pcrCleanupId;
	}

	public void setPcrCleanupId(BigDecimal pcrCleanupId) {
		this.pcrCleanupId = pcrCleanupId;
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

	public BigDecimal getSubsidiaryId() {
		return this.subsidiaryId;
	}

	public void setSubsidiaryId(BigDecimal subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

}
