package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RoiSelection generated by hbm2java
 */
public class RoiSelection implements java.io.Serializable {

	private BigDecimal roiSelectionId;
	private Roi roi;
	private TestSetup testSetup;
	private Accession accession;
	private Subsidiary subsidiary;
	private String purpose;
	private String techniqueType;
	private String controlType;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private Set<TestAttributeFld> testAttributeFlds = new HashSet<TestAttributeFld>(
			0);
	private Set<CaseRoi> caseRois = new HashSet<CaseRoi>(0);

	public RoiSelection() {
	}

	public RoiSelection(BigDecimal roiSelectionId, TestSetup testSetup) {
		this.roiSelectionId = roiSelectionId;
		this.testSetup = testSetup;
	}

	public RoiSelection(BigDecimal roiSelectionId, Roi roi,
			TestSetup testSetup, Accession accession, Subsidiary subsidiary,
			String purpose, String techniqueType, String controlType,
			String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, Set<TestAttributeFld> testAttributeFlds,
			Set<CaseRoi> caseRois) {
		this.roiSelectionId = roiSelectionId;
		this.roi = roi;
		this.testSetup = testSetup;
		this.accession = accession;
		this.subsidiary = subsidiary;
		this.purpose = purpose;
		this.techniqueType = techniqueType;
		this.controlType = controlType;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.testAttributeFlds = testAttributeFlds;
		this.caseRois = caseRois;
	}

	public BigDecimal getRoiSelectionId() {
		return this.roiSelectionId;
	}

	public void setRoiSelectionId(BigDecimal roiSelectionId) {
		this.roiSelectionId = roiSelectionId;
	}

	public Roi getRoi() {
		return this.roi;
	}

	public void setRoi(Roi roi) {
		this.roi = roi;
	}

	public TestSetup getTestSetup() {
		return this.testSetup;
	}

	public void setTestSetup(TestSetup testSetup) {
		this.testSetup = testSetup;
	}

	public Accession getAccession() {
		return this.accession;
	}

	public void setAccession(Accession accession) {
		this.accession = accession;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getTechniqueType() {
		return this.techniqueType;
	}

	public void setTechniqueType(String techniqueType) {
		this.techniqueType = techniqueType;
	}

	public String getControlType() {
		return this.controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
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

	public Set<TestAttributeFld> getTestAttributeFlds() {
		return this.testAttributeFlds;
	}

	public void setTestAttributeFlds(Set<TestAttributeFld> testAttributeFlds) {
		this.testAttributeFlds = testAttributeFlds;
	}

	public Set<CaseRoi> getCaseRois() {
		return this.caseRois;
	}

	public void setCaseRois(Set<CaseRoi> caseRois) {
		this.caseRois = caseRois;
	}

}
