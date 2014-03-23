package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * AttributeLevel generated by hbm2java
 */
public class AttributeLevel implements java.io.Serializable {

	private String attributeLevelId;
	private String attributeName;
	private BigDecimal numberInSequence;
	private Set<ProtocolDefinedVariable> protocolDefinedVariables = new HashSet<ProtocolDefinedVariable>(
			0);

	public AttributeLevel() {
	}

	public AttributeLevel(String attributeLevelId, String attributeName) {
		this.attributeLevelId = attributeLevelId;
		this.attributeName = attributeName;
	}

	public AttributeLevel(String attributeLevelId, String attributeName,
			BigDecimal numberInSequence,
			Set<ProtocolDefinedVariable> protocolDefinedVariables) {
		this.attributeLevelId = attributeLevelId;
		this.attributeName = attributeName;
		this.numberInSequence = numberInSequence;
		this.protocolDefinedVariables = protocolDefinedVariables;
	}

	public String getAttributeLevelId() {
		return this.attributeLevelId;
	}

	public void setAttributeLevelId(String attributeLevelId) {
		this.attributeLevelId = attributeLevelId;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public BigDecimal getNumberInSequence() {
		return this.numberInSequence;
	}

	public void setNumberInSequence(BigDecimal numberInSequence) {
		this.numberInSequence = numberInSequence;
	}

	public Set<ProtocolDefinedVariable> getProtocolDefinedVariables() {
		return this.protocolDefinedVariables;
	}

	public void setProtocolDefinedVariables(
			Set<ProtocolDefinedVariable> protocolDefinedVariables) {
		this.protocolDefinedVariables = protocolDefinedVariables;
	}

}