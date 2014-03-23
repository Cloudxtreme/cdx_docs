package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MasterMix generated by hbm2java
 */
public class MasterMix implements java.io.Serializable {

	private BigDecimal masterMixId;
	private String version;
	private String mixName;
	private String status;
	private BigDecimal volume;
	private String comments;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String calculateBy;
	private Set<MasterMixItem> masterMixItems = new HashSet<MasterMixItem>(0);
	private Set<MasterMixDilution> masterMixDilutions = new HashSet<MasterMixDilution>(
			0);

	public MasterMix() {
	}

	public MasterMix(BigDecimal masterMixId, String createdBy, Date dateCreated) {
		this.masterMixId = masterMixId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public MasterMix(BigDecimal masterMixId, String mixName, String status,
			BigDecimal volume, String comments, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			String calculateBy, Set<MasterMixItem> masterMixItems,
			Set<MasterMixDilution> masterMixDilutions) {
		this.masterMixId = masterMixId;
		this.mixName = mixName;
		this.status = status;
		this.volume = volume;
		this.comments = comments;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.calculateBy = calculateBy;
		this.masterMixItems = masterMixItems;
		this.masterMixDilutions = masterMixDilutions;
	}

	public BigDecimal getMasterMixId() {
		return this.masterMixId;
	}

	public void setMasterMixId(BigDecimal masterMixId) {
		this.masterMixId = masterMixId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMixName() {
		return this.mixName;
	}

	public void setMixName(String mixName) {
		this.mixName = mixName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getCalculateBy() {
		return this.calculateBy;
	}

	public void setCalculateBy(String calculateBy) {
		this.calculateBy = calculateBy;
	}

	public Set<MasterMixItem> getMasterMixItems() {
		return this.masterMixItems;
	}

	public void setMasterMixItems(Set<MasterMixItem> masterMixItems) {
		this.masterMixItems = masterMixItems;
	}

	public Set<MasterMixDilution> getMasterMixDilutions() {
		return this.masterMixDilutions;
	}

	public void setMasterMixDilutions(Set<MasterMixDilution> masterMixDilutions) {
		this.masterMixDilutions = masterMixDilutions;
	}

}
