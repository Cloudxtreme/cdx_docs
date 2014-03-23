package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AudTestSetup generated by hbm2java
 */
public class AudTestSetup implements java.io.Serializable {

	private BigDecimal auditId;
	private String version;
	private BigDecimal changeReasonId;
	private BigDecimal testSetupId;
	private String testNumber;
	private String testName;
	private String testType;
	private String status;
	private String testSource;
	private String testClass;
	private String testDescription;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private String changedBy;
	private Date dateChanged;
	private String changeType;
	private BigDecimal subsidiaryId;

	public AudTestSetup() {
	}

	public AudTestSetup(BigDecimal auditId, BigDecimal testSetupId,
			String testNumber, String status, String createdBy, Date dateCreated) {
		this.auditId = auditId;
		this.testSetupId = testSetupId;
		this.testNumber = testNumber;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public AudTestSetup(BigDecimal auditId, BigDecimal changeReasonId,
			BigDecimal testSetupId, String testNumber, String testName,
			String testType, String status, String testSource,
			String testClass, String testDescription, String createdBy,
			Date dateCreated, String modifiedBy, Date dateModified,
			String changedBy, Date dateChanged, String changeType,
			BigDecimal subsidiaryId) {
		this.auditId = auditId;
		this.changeReasonId = changeReasonId;
		this.testSetupId = testSetupId;
		this.testNumber = testNumber;
		this.testName = testName;
		this.testType = testType;
		this.status = status;
		this.testSource = testSource;
		this.testClass = testClass;
		this.testDescription = testDescription;
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

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BigDecimal getChangeReasonId() {
		return this.changeReasonId;
	}

	public void setChangeReasonId(BigDecimal changeReasonId) {
		this.changeReasonId = changeReasonId;
	}

	public BigDecimal getTestSetupId() {
		return this.testSetupId;
	}

	public void setTestSetupId(BigDecimal testSetupId) {
		this.testSetupId = testSetupId;
	}

	public String getTestNumber() {
		return this.testNumber;
	}

	public void setTestNumber(String testNumber) {
		this.testNumber = testNumber;
	}

	public String getTestName() {
		return this.testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestType() {
		return this.testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTestSource() {
		return this.testSource;
	}

	public void setTestSource(String testSource) {
		this.testSource = testSource;
	}

	public String getTestClass() {
		return this.testClass;
	}

	public void setTestClass(String testClass) {
		this.testClass = testClass;
	}

	public String getTestDescription() {
		return this.testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
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