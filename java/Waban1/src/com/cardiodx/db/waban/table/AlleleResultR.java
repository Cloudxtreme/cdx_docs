package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * AlleleResultR generated by hbm2java
 */
public class AlleleResultR implements java.io.Serializable {

	private AlleleResultRId id;
	private BigDecimal databaseId;

	public AlleleResultR() {
	}

	public AlleleResultR(AlleleResultRId id) {
		this.id = id;
	}

	public AlleleResultR(AlleleResultRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public AlleleResultRId getId() {
		return this.id;
	}

	public void setId(AlleleResultRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}