package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AssignInstrumentValue generated by hbm2java
 */
public class AssignInstrumentValue implements java.io.Serializable {

	private BigDecimal assignInstrumentValueId;
	private ConfigAttribute configAttribute;
	private AssignInstrument assignInstrument;
	private String value;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private BigDecimal subsidiaryId;

	public AssignInstrumentValue() {
	}

	public AssignInstrumentValue(BigDecimal assignInstrumentValueId,
			ConfigAttribute configAttribute, AssignInstrument assignInstrument) {
		this.assignInstrumentValueId = assignInstrumentValueId;
		this.configAttribute = configAttribute;
		this.assignInstrument = assignInstrument;
	}

	public AssignInstrumentValue(BigDecimal assignInstrumentValueId,
			ConfigAttribute configAttribute, AssignInstrument assignInstrument,
			String value, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified, BigDecimal subsidiaryId) {
		this.assignInstrumentValueId = assignInstrumentValueId;
		this.configAttribute = configAttribute;
		this.assignInstrument = assignInstrument;
		this.value = value;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.subsidiaryId = subsidiaryId;
	}

	public BigDecimal getAssignInstrumentValueId() {
		return this.assignInstrumentValueId;
	}

	public void setAssignInstrumentValueId(BigDecimal assignInstrumentValueId) {
		this.assignInstrumentValueId = assignInstrumentValueId;
	}

	public ConfigAttribute getConfigAttribute() {
		return this.configAttribute;
	}

	public void setConfigAttribute(ConfigAttribute configAttribute) {
		this.configAttribute = configAttribute;
	}

	public AssignInstrument getAssignInstrument() {
		return this.assignInstrument;
	}

	public void setAssignInstrument(AssignInstrument assignInstrument) {
		this.assignInstrument = assignInstrument;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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
