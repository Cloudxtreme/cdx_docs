package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * WordreportParam generated by hbm2java
 */
public class WordreportParam implements java.io.Serializable {

	private BigDecimal wordreportParamId;
	private Wordreport wordreport;
	private Subsidiary subsidiary;
	private String paramtype;
	private String paramValue;

	public WordreportParam() {
	}

	public WordreportParam(BigDecimal wordreportParamId, Wordreport wordreport) {
		this.wordreportParamId = wordreportParamId;
		this.wordreport = wordreport;
	}

	public WordreportParam(BigDecimal wordreportParamId, Wordreport wordreport,
			Subsidiary subsidiary, String paramtype, String paramValue) {
		this.wordreportParamId = wordreportParamId;
		this.wordreport = wordreport;
		this.subsidiary = subsidiary;
		this.paramtype = paramtype;
		this.paramValue = paramValue;
	}

	public BigDecimal getWordreportParamId() {
		return this.wordreportParamId;
	}

	public void setWordreportParamId(BigDecimal wordreportParamId) {
		this.wordreportParamId = wordreportParamId;
	}

	public Wordreport getWordreport() {
		return this.wordreport;
	}

	public void setWordreport(Wordreport wordreport) {
		this.wordreport = wordreport;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getParamtype() {
		return this.paramtype;
	}

	public void setParamtype(String paramtype) {
		this.paramtype = paramtype;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

}