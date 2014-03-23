package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * VendorProjectAssay generated by hbm2java
 */
public class VendorProjectAssay implements java.io.Serializable {

	private BigDecimal genotypingVendorAssayId;
	private GenotypingVendorProject genotypingVendorProject;
	private StudyProtocol studyProtocol;
	private Subsidiary subsidiary;
	private Assay assay;
	private Boolean tested;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

	public VendorProjectAssay() {
	}

	public VendorProjectAssay(BigDecimal genotypingVendorAssayId,
			GenotypingVendorProject genotypingVendorProject,
			StudyProtocol studyProtocol) {
		this.genotypingVendorAssayId = genotypingVendorAssayId;
		this.genotypingVendorProject = genotypingVendorProject;
		this.studyProtocol = studyProtocol;
	}

	public VendorProjectAssay(BigDecimal genotypingVendorAssayId,
			GenotypingVendorProject genotypingVendorProject,
			StudyProtocol studyProtocol, Subsidiary subsidiary, Assay assay,
			Boolean tested, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified) {
		this.genotypingVendorAssayId = genotypingVendorAssayId;
		this.genotypingVendorProject = genotypingVendorProject;
		this.studyProtocol = studyProtocol;
		this.subsidiary = subsidiary;
		this.assay = assay;
		this.tested = tested;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getGenotypingVendorAssayId() {
		return this.genotypingVendorAssayId;
	}

	public void setGenotypingVendorAssayId(BigDecimal genotypingVendorAssayId) {
		this.genotypingVendorAssayId = genotypingVendorAssayId;
	}

	public GenotypingVendorProject getGenotypingVendorProject() {
		return this.genotypingVendorProject;
	}

	public void setGenotypingVendorProject(
			GenotypingVendorProject genotypingVendorProject) {
		this.genotypingVendorProject = genotypingVendorProject;
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

	public Assay getAssay() {
		return this.assay;
	}

	public void setAssay(Assay assay) {
		this.assay = assay;
	}

	public Boolean getTested() {
		return this.tested;
	}

	public void setTested(Boolean tested) {
		this.tested = tested;
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