package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * ChangeTableR generated by hbm2java
 */
public class ChangeTableR implements java.io.Serializable {

	private ChangeTableRId id;
	private BigDecimal databaseId;

	public ChangeTableR() {
	}

	public ChangeTableR(ChangeTableRId id) {
		this.id = id;
	}

	public ChangeTableR(ChangeTableRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public ChangeTableRId getId() {
		return this.id;
	}

	public void setId(ChangeTableRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
