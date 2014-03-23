package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * AuditTableR generated by hbm2java
 */
public class AuditTableR implements java.io.Serializable {

	private AuditTableRId id;
	private BigDecimal databaseId;

	public AuditTableR() {
	}

	public AuditTableR(AuditTableRId id) {
		this.id = id;
	}

	public AuditTableR(AuditTableRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public AuditTableRId getId() {
		return this.id;
	}

	public void setId(AuditTableRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}