package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * WorkflowCaseItemViewId generated by hbm2java
 */
public class WorkflowCaseItemViewId implements java.io.Serializable {

	private BigDecimal workflowId;
	private BigDecimal workflowItemId;
	private String accessionNumber;
	private String studyNumber;
	private String status;
	private Date dateCreated;
	private Date dateCompleted;
	private BigDecimal studyProtocolId;
	private BigDecimal accessionId;
	private String errNumber;
	private String errDescription;
	private String lastProcResult;
	private String testNumber;
	private String testName;
	private String testDescription;
	private String testType;
	private String version;
	private BigDecimal testAccessionId;

	public WorkflowCaseItemViewId() {
	}

	public WorkflowCaseItemViewId(BigDecimal workflowItemId,
			String accessionNumber, BigDecimal studyProtocolId,
			BigDecimal accessionId, String testNumber, String testName,
			String testType, BigDecimal testAccessionId) {
		this.workflowItemId = workflowItemId;
		this.accessionNumber = accessionNumber;
		this.studyProtocolId = studyProtocolId;
		this.accessionId = accessionId;
		this.testNumber = testNumber;
		this.testName = testName;
		this.testType = testType;
		this.testAccessionId = testAccessionId;
	}

	public WorkflowCaseItemViewId(BigDecimal workflowId,
			BigDecimal workflowItemId, String accessionNumber,
			String studyNumber, String status, Date dateCreated,
			Date dateCompleted, BigDecimal studyProtocolId,
			BigDecimal accessionId, String errNumber, String errDescription,
			String lastProcResult, String testNumber, String testName,
			String testDescription, String testType, String version,
			BigDecimal testAccessionId) {
		this.workflowId = workflowId;
		this.workflowItemId = workflowItemId;
		this.accessionNumber = accessionNumber;
		this.studyNumber = studyNumber;
		this.status = status;
		this.dateCreated = dateCreated;
		this.dateCompleted = dateCompleted;
		this.studyProtocolId = studyProtocolId;
		this.accessionId = accessionId;
		this.errNumber = errNumber;
		this.errDescription = errDescription;
		this.lastProcResult = lastProcResult;
		this.testNumber = testNumber;
		this.testName = testName;
		this.testDescription = testDescription;
		this.testType = testType;
		this.version = version;
		this.testAccessionId = testAccessionId;
	}

	public BigDecimal getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(BigDecimal workflowId) {
		this.workflowId = workflowId;
	}

	public BigDecimal getWorkflowItemId() {
		return this.workflowItemId;
	}

	public void setWorkflowItemId(BigDecimal workflowItemId) {
		this.workflowItemId = workflowItemId;
	}

	public String getAccessionNumber() {
		return this.accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public String getStudyNumber() {
		return this.studyNumber;
	}

	public void setStudyNumber(String studyNumber) {
		this.studyNumber = studyNumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateCompleted() {
		return this.dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public String getErrNumber() {
		return this.errNumber;
	}

	public void setErrNumber(String errNumber) {
		this.errNumber = errNumber;
	}

	public String getErrDescription() {
		return this.errDescription;
	}

	public void setErrDescription(String errDescription) {
		this.errDescription = errDescription;
	}

	public String getLastProcResult() {
		return this.lastProcResult;
	}

	public void setLastProcResult(String lastProcResult) {
		this.lastProcResult = lastProcResult;
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

	public String getTestDescription() {
		return this.testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public String getTestType() {
		return this.testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BigDecimal getTestAccessionId() {
		return this.testAccessionId;
	}

	public void setTestAccessionId(BigDecimal testAccessionId) {
		this.testAccessionId = testAccessionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WorkflowCaseItemViewId))
			return false;
		WorkflowCaseItemViewId castOther = (WorkflowCaseItemViewId) other;

		return ((this.getWorkflowId() == castOther.getWorkflowId()) || (this
				.getWorkflowId() != null && castOther.getWorkflowId() != null && this
				.getWorkflowId().equals(castOther.getWorkflowId())))
				&& ((this.getWorkflowItemId() == castOther.getWorkflowItemId()) || (this
						.getWorkflowItemId() != null
						&& castOther.getWorkflowItemId() != null && this
						.getWorkflowItemId().equals(
								castOther.getWorkflowItemId())))
				&& ((this.getAccessionNumber() == castOther
						.getAccessionNumber()) || (this.getAccessionNumber() != null
						&& castOther.getAccessionNumber() != null && this
						.getAccessionNumber().equals(
								castOther.getAccessionNumber())))
				&& ((this.getStudyNumber() == castOther.getStudyNumber()) || (this
						.getStudyNumber() != null
						&& castOther.getStudyNumber() != null && this
						.getStudyNumber().equals(castOther.getStudyNumber())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getDateCompleted() == castOther.getDateCompleted()) || (this
						.getDateCompleted() != null
						&& castOther.getDateCompleted() != null && this
						.getDateCompleted()
						.equals(castOther.getDateCompleted())))
				&& ((this.getStudyProtocolId() == castOther
						.getStudyProtocolId()) || (this.getStudyProtocolId() != null
						&& castOther.getStudyProtocolId() != null && this
						.getStudyProtocolId().equals(
								castOther.getStudyProtocolId())))
				&& ((this.getAccessionId() == castOther.getAccessionId()) || (this
						.getAccessionId() != null
						&& castOther.getAccessionId() != null && this
						.getAccessionId().equals(castOther.getAccessionId())))
				&& ((this.getErrNumber() == castOther.getErrNumber()) || (this
						.getErrNumber() != null
						&& castOther.getErrNumber() != null && this
						.getErrNumber().equals(castOther.getErrNumber())))
				&& ((this.getErrDescription() == castOther.getErrDescription()) || (this
						.getErrDescription() != null
						&& castOther.getErrDescription() != null && this
						.getErrDescription().equals(
								castOther.getErrDescription())))
				&& ((this.getLastProcResult() == castOther.getLastProcResult()) || (this
						.getLastProcResult() != null
						&& castOther.getLastProcResult() != null && this
						.getLastProcResult().equals(
								castOther.getLastProcResult())))
				&& ((this.getTestNumber() == castOther.getTestNumber()) || (this
						.getTestNumber() != null
						&& castOther.getTestNumber() != null && this
						.getTestNumber().equals(castOther.getTestNumber())))
				&& ((this.getTestName() == castOther.getTestName()) || (this
						.getTestName() != null
						&& castOther.getTestName() != null && this
						.getTestName().equals(castOther.getTestName())))
				&& ((this.getTestDescription() == castOther
						.getTestDescription()) || (this.getTestDescription() != null
						&& castOther.getTestDescription() != null && this
						.getTestDescription().equals(
								castOther.getTestDescription())))
				&& ((this.getTestType() == castOther.getTestType()) || (this
						.getTestType() != null
						&& castOther.getTestType() != null && this
						.getTestType().equals(castOther.getTestType())))
				&& ((this.getVersion() == castOther.getVersion()) || (this
						.getVersion() != null && castOther.getVersion() != null && this
						.getVersion().equals(castOther.getVersion())))
				&& ((this.getTestAccessionId() == castOther
						.getTestAccessionId()) || (this.getTestAccessionId() != null
						&& castOther.getTestAccessionId() != null && this
						.getTestAccessionId().equals(
								castOther.getTestAccessionId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getWorkflowId() == null ? 0 : this.getWorkflowId()
						.hashCode());
		result = 37
				* result
				+ (getWorkflowItemId() == null ? 0 : this.getWorkflowItemId()
						.hashCode());
		result = 37
				* result
				+ (getAccessionNumber() == null ? 0 : this.getAccessionNumber()
						.hashCode());
		result = 37
				* result
				+ (getStudyNumber() == null ? 0 : this.getStudyNumber()
						.hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37
				* result
				+ (getDateCompleted() == null ? 0 : this.getDateCompleted()
						.hashCode());
		result = 37
				* result
				+ (getStudyProtocolId() == null ? 0 : this.getStudyProtocolId()
						.hashCode());
		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		result = 37 * result
				+ (getErrNumber() == null ? 0 : this.getErrNumber().hashCode());
		result = 37
				* result
				+ (getErrDescription() == null ? 0 : this.getErrDescription()
						.hashCode());
		result = 37
				* result
				+ (getLastProcResult() == null ? 0 : this.getLastProcResult()
						.hashCode());
		result = 37
				* result
				+ (getTestNumber() == null ? 0 : this.getTestNumber()
						.hashCode());
		result = 37 * result
				+ (getTestName() == null ? 0 : this.getTestName().hashCode());
		result = 37
				* result
				+ (getTestDescription() == null ? 0 : this.getTestDescription()
						.hashCode());
		result = 37 * result
				+ (getTestType() == null ? 0 : this.getTestType().hashCode());
		result = 37 * result
				+ (getVersion() == null ? 0 : this.getVersion().hashCode());
		result = 37
				* result
				+ (getTestAccessionId() == null ? 0 : this.getTestAccessionId()
						.hashCode());
		return result;
	}

}
