package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * ParentMenuR generated by hbm2java
 */
public class ParentMenuR implements java.io.Serializable {

	private ParentMenuRId id;
	private BigDecimal databaseId;

	public ParentMenuR() {
	}

	public ParentMenuR(ParentMenuRId id) {
		this.id = id;
	}

	public ParentMenuR(ParentMenuRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public ParentMenuRId getId() {
		return this.id;
	}

	public void setId(ParentMenuRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
