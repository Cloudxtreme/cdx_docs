package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * GetFgNumberViewId generated by hbm2java
 */
public class GetFgNumberViewId implements java.io.Serializable {

	private BigDecimal studyProtocolId;
	private String fgNumber;

	public GetFgNumberViewId() {
	}

	public GetFgNumberViewId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public GetFgNumberViewId(BigDecimal studyProtocolId, String fgNumber) {
		this.studyProtocolId = studyProtocolId;
		this.fgNumber = fgNumber;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public String getFgNumber() {
		return this.fgNumber;
	}

	public void setFgNumber(String fgNumber) {
		this.fgNumber = fgNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GetFgNumberViewId))
			return false;
		GetFgNumberViewId castOther = (GetFgNumberViewId) other;

		return ((this.getStudyProtocolId() == castOther.getStudyProtocolId()) || (this
				.getStudyProtocolId() != null
				&& castOther.getStudyProtocolId() != null && this
				.getStudyProtocolId().equals(castOther.getStudyProtocolId())))
				&& ((this.getFgNumber() == castOther.getFgNumber()) || (this
						.getFgNumber() != null
						&& castOther.getFgNumber() != null && this
						.getFgNumber().equals(castOther.getFgNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudyProtocolId() == null ? 0 : this.getStudyProtocolId()
						.hashCode());
		result = 37 * result
				+ (getFgNumber() == null ? 0 : this.getFgNumber().hashCode());
		return result;
	}

}