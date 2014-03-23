package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * OligoPlateTemplateDesign generated by hbm2java
 */
public class OligoPlateTemplateDesign implements java.io.Serializable {

	private BigDecimal olgTemplateId;
	private PlateTemplate plateTemplate;
	private String createdBy;
	private Date dateCreated;

	public OligoPlateTemplateDesign() {
	}

	public OligoPlateTemplateDesign(BigDecimal olgTemplateId) {
		this.olgTemplateId = olgTemplateId;
	}

	public OligoPlateTemplateDesign(BigDecimal olgTemplateId,
			PlateTemplate plateTemplate, String createdBy, Date dateCreated) {
		this.olgTemplateId = olgTemplateId;
		this.plateTemplate = plateTemplate;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public BigDecimal getOlgTemplateId() {
		return this.olgTemplateId;
	}

	public void setOlgTemplateId(BigDecimal olgTemplateId) {
		this.olgTemplateId = olgTemplateId;
	}

	public PlateTemplate getPlateTemplate() {
		return this.plateTemplate;
	}

	public void setPlateTemplate(PlateTemplate plateTemplate) {
		this.plateTemplate = plateTemplate;
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

}
