package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * MTimeForecastViewId generated by hbm2java
 */
public class MTimeForecastViewId implements java.io.Serializable {

	private BigDecimal studyProtocolId;
	private String studyNumber;
	private String sponsorStudyNumber;
	private String variableName;
	private String milestoneDate;

	public MTimeForecastViewId() {
	}

	public MTimeForecastViewId(BigDecimal studyProtocolId, String variableName) {
		this.studyProtocolId = studyProtocolId;
		this.variableName = variableName;
	}

	public MTimeForecastViewId(BigDecimal studyProtocolId, String studyNumber,
			String sponsorStudyNumber, String variableName, String milestoneDate) {
		this.studyProtocolId = studyProtocolId;
		this.studyNumber = studyNumber;
		this.sponsorStudyNumber = sponsorStudyNumber;
		this.variableName = variableName;
		this.milestoneDate = milestoneDate;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public String getStudyNumber() {
		return this.studyNumber;
	}

	public void setStudyNumber(String studyNumber) {
		this.studyNumber = studyNumber;
	}

	public String getSponsorStudyNumber() {
		return this.sponsorStudyNumber;
	}

	public void setSponsorStudyNumber(String sponsorStudyNumber) {
		this.sponsorStudyNumber = sponsorStudyNumber;
	}

	public String getVariableName() {
		return this.variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getMilestoneDate() {
		return this.milestoneDate;
	}

	public void setMilestoneDate(String milestoneDate) {
		this.milestoneDate = milestoneDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MTimeForecastViewId))
			return false;
		MTimeForecastViewId castOther = (MTimeForecastViewId) other;

		return ((this.getStudyProtocolId() == castOther.getStudyProtocolId()) || (this
				.getStudyProtocolId() != null
				&& castOther.getStudyProtocolId() != null && this
				.getStudyProtocolId().equals(castOther.getStudyProtocolId())))
				&& ((this.getStudyNumber() == castOther.getStudyNumber()) || (this
						.getStudyNumber() != null
						&& castOther.getStudyNumber() != null && this
						.getStudyNumber().equals(castOther.getStudyNumber())))
				&& ((this.getSponsorStudyNumber() == castOther
						.getSponsorStudyNumber()) || (this
						.getSponsorStudyNumber() != null
						&& castOther.getSponsorStudyNumber() != null && this
						.getSponsorStudyNumber().equals(
								castOther.getSponsorStudyNumber())))
				&& ((this.getVariableName() == castOther.getVariableName()) || (this
						.getVariableName() != null
						&& castOther.getVariableName() != null && this
						.getVariableName().equals(castOther.getVariableName())))
				&& ((this.getMilestoneDate() == castOther.getMilestoneDate()) || (this
						.getMilestoneDate() != null
						&& castOther.getMilestoneDate() != null && this
						.getMilestoneDate()
						.equals(castOther.getMilestoneDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudyProtocolId() == null ? 0 : this.getStudyProtocolId()
						.hashCode());
		result = 37
				* result
				+ (getStudyNumber() == null ? 0 : this.getStudyNumber()
						.hashCode());
		result = 37
				* result
				+ (getSponsorStudyNumber() == null ? 0 : this
						.getSponsorStudyNumber().hashCode());
		result = 37
				* result
				+ (getVariableName() == null ? 0 : this.getVariableName()
						.hashCode());
		result = 37
				* result
				+ (getMilestoneDate() == null ? 0 : this.getMilestoneDate()
						.hashCode());
		return result;
	}

}
