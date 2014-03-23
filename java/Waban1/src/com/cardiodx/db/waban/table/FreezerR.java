package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * FreezerR generated by hbm2java
 */
public class FreezerR implements java.io.Serializable {

	private FreezerRId id;
	private BigDecimal databaseId;

	public FreezerR() {
	}

	public FreezerR(FreezerRId id) {
		this.id = id;
	}

	public FreezerR(FreezerRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public FreezerRId getId() {
		return this.id;
	}

	public void setId(FreezerRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}