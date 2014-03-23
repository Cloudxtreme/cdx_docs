package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * OligoTemplateViewId generated by hbm2java
 */
public class OligoTemplateViewId implements java.io.Serializable {

	private BigDecimal plateTemplateId;
	private String templateName;

	public OligoTemplateViewId() {
	}

	public OligoTemplateViewId(BigDecimal plateTemplateId, String templateName) {
		this.plateTemplateId = plateTemplateId;
		this.templateName = templateName;
	}

	public BigDecimal getPlateTemplateId() {
		return this.plateTemplateId;
	}

	public void setPlateTemplateId(BigDecimal plateTemplateId) {
		this.plateTemplateId = plateTemplateId;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OligoTemplateViewId))
			return false;
		OligoTemplateViewId castOther = (OligoTemplateViewId) other;

		return ((this.getPlateTemplateId() == castOther.getPlateTemplateId()) || (this
				.getPlateTemplateId() != null
				&& castOther.getPlateTemplateId() != null && this
				.getPlateTemplateId().equals(castOther.getPlateTemplateId())))
				&& ((this.getTemplateName() == castOther.getTemplateName()) || (this
						.getTemplateName() != null
						&& castOther.getTemplateName() != null && this
						.getTemplateName().equals(castOther.getTemplateName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPlateTemplateId() == null ? 0 : this.getPlateTemplateId()
						.hashCode());
		result = 37
				* result
				+ (getTemplateName() == null ? 0 : this.getTemplateName()
						.hashCode());
		return result;
	}

}