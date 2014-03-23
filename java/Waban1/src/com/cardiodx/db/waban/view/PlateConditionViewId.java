package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

/**
 * PlateConditionViewId generated by hbm2java
 */
public class PlateConditionViewId implements java.io.Serializable {

	private String attributeName;
	private String attributeValue;

	public PlateConditionViewId() {
	}

	public PlateConditionViewId(String attributeName) {
		this.attributeName = attributeName;
	}

	public PlateConditionViewId(String attributeName, String attributeValue) {
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PlateConditionViewId))
			return false;
		PlateConditionViewId castOther = (PlateConditionViewId) other;

		return ((this.getAttributeName() == castOther.getAttributeName()) || (this
				.getAttributeName() != null
				&& castOther.getAttributeName() != null && this
				.getAttributeName().equals(castOther.getAttributeName())))
				&& ((this.getAttributeValue() == castOther.getAttributeValue()) || (this
						.getAttributeValue() != null
						&& castOther.getAttributeValue() != null && this
						.getAttributeValue().equals(
								castOther.getAttributeValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAttributeName() == null ? 0 : this.getAttributeName()
						.hashCode());
		result = 37
				* result
				+ (getAttributeValue() == null ? 0 : this.getAttributeValue()
						.hashCode());
		return result;
	}

}