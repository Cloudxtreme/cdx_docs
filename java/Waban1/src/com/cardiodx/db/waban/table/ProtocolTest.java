package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProtocolTest generated by hbm2java
 */
public class ProtocolTest implements java.io.Serializable {

	private BigDecimal protocolTestId;
	private TestSetup testSetup;
	private StudyProtocol studyProtocol;
	private Subsidiary subsidiary;
	private BigDecimal turnAroundTime;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;

	public ProtocolTest() {
	}

	public ProtocolTest(BigDecimal protocolTestId, TestSetup testSetup,
			StudyProtocol studyProtocol) {
		this.protocolTestId = protocolTestId;
		this.testSetup = testSetup;
		this.studyProtocol = studyProtocol;
	}

	public ProtocolTest(BigDecimal protocolTestId, TestSetup testSetup,
			StudyProtocol studyProtocol, Subsidiary subsidiary,
			BigDecimal turnAroundTime, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified) {
		this.protocolTestId = protocolTestId;
		this.testSetup = testSetup;
		this.studyProtocol = studyProtocol;
		this.subsidiary = subsidiary;
		this.turnAroundTime = turnAroundTime;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
	}

	public BigDecimal getProtocolTestId() {
		return this.protocolTestId;
	}

	public void setProtocolTestId(BigDecimal protocolTestId) {
		this.protocolTestId = protocolTestId;
	}

	public TestSetup getTestSetup() {
		return this.testSetup;
	}

	public void setTestSetup(TestSetup testSetup) {
		this.testSetup = testSetup;
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

	public BigDecimal getTurnAroundTime() {
		return this.turnAroundTime;
	}

	public void setTurnAroundTime(BigDecimal turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
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
