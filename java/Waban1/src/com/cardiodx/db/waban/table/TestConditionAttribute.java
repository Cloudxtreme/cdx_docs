package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TestConditionAttribute generated by hbm2java
 */
public class TestConditionAttribute implements java.io.Serializable {

	private BigDecimal testAttributeId;
	private Subsidiary subsidiary;
	private Variable variable;
	private String techniqueType;
	private BigDecimal numberInSequence;
	private Set<TestAttributeFld> testAttributeFlds = new HashSet<TestAttributeFld>(
			0);

	public TestConditionAttribute() {
	}

	public TestConditionAttribute(BigDecimal testAttributeId) {
		this.testAttributeId = testAttributeId;
	}

	public TestConditionAttribute(BigDecimal testAttributeId,
			Subsidiary subsidiary, Variable variable, String techniqueType,
			BigDecimal numberInSequence, Set<TestAttributeFld> testAttributeFlds) {
		this.testAttributeId = testAttributeId;
		this.subsidiary = subsidiary;
		this.variable = variable;
		this.techniqueType = techniqueType;
		this.numberInSequence = numberInSequence;
		this.testAttributeFlds = testAttributeFlds;
	}

	public BigDecimal getTestAttributeId() {
		return this.testAttributeId;
	}

	public void setTestAttributeId(BigDecimal testAttributeId) {
		this.testAttributeId = testAttributeId;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public Variable getVariable() {
		return this.variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public String getTechniqueType() {
		return this.techniqueType;
	}

	public void setTechniqueType(String techniqueType) {
		this.techniqueType = techniqueType;
	}

	public BigDecimal getNumberInSequence() {
		return this.numberInSequence;
	}

	public void setNumberInSequence(BigDecimal numberInSequence) {
		this.numberInSequence = numberInSequence;
	}

	public Set<TestAttributeFld> getTestAttributeFlds() {
		return this.testAttributeFlds;
	}

	public void setTestAttributeFlds(Set<TestAttributeFld> testAttributeFlds) {
		this.testAttributeFlds = testAttributeFlds;
	}

}