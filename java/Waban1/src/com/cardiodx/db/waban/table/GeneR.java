package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * GeneR generated by hbm2java
 */
public class GeneR implements java.io.Serializable {

	private GeneRId id;
	private BigDecimal databaseId;

	public GeneR() {
	}

	public GeneR(GeneRId id) {
		this.id = id;
	}

	public GeneR(GeneRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public GeneRId getId() {
		return this.id;
	}

	public void setId(GeneRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
