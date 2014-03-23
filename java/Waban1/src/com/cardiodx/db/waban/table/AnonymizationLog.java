package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AnonymizationLog generated by hbm2java
 */
public class AnonymizationLog implements java.io.Serializable {

	private BigDecimal anonymizationLogId;
	private Subsidiary subsidiary;
	private String anonymizedBy;
	private Date dateAnonymized;
	private String anonymizationReason;
	private String status;
	private BigDecimal anonymizationRequestId;
	private BigDecimal signature;

	public AnonymizationLog() {
	}

	public AnonymizationLog(BigDecimal anonymizationLogId) {
		this.anonymizationLogId = anonymizationLogId;
	}

	public AnonymizationLog(BigDecimal anonymizationLogId,
			Subsidiary subsidiary, String anonymizedBy, Date dateAnonymized,
			String anonymizationReason, String status,
			BigDecimal anonymizationRequestId, BigDecimal signature) {
		this.anonymizationLogId = anonymizationLogId;
		this.subsidiary = subsidiary;
		this.anonymizedBy = anonymizedBy;
		this.dateAnonymized = dateAnonymized;
		this.anonymizationReason = anonymizationReason;
		this.status = status;
		this.anonymizationRequestId = anonymizationRequestId;
		this.signature = signature;
	}

	public BigDecimal getAnonymizationLogId() {
		return this.anonymizationLogId;
	}

	public void setAnonymizationLogId(BigDecimal anonymizationLogId) {
		this.anonymizationLogId = anonymizationLogId;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getAnonymizedBy() {
		return this.anonymizedBy;
	}

	public void setAnonymizedBy(String anonymizedBy) {
		this.anonymizedBy = anonymizedBy;
	}

	public Date getDateAnonymized() {
		return this.dateAnonymized;
	}

	public void setDateAnonymized(Date dateAnonymized) {
		this.dateAnonymized = dateAnonymized;
	}

	public String getAnonymizationReason() {
		return this.anonymizationReason;
	}

	public void setAnonymizationReason(String anonymizationReason) {
		this.anonymizationReason = anonymizationReason;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getAnonymizationRequestId() {
		return this.anonymizationRequestId;
	}

	public void setAnonymizationRequestId(BigDecimal anonymizationRequestId) {
		this.anonymizationRequestId = anonymizationRequestId;
	}

	public BigDecimal getSignature() {
		return this.signature;
	}

	public void setSignature(BigDecimal signature) {
		this.signature = signature;
	}

}
