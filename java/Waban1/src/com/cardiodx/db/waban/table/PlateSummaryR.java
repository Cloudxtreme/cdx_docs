package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * PlateSummaryR generated by hbm2java
 */
public class PlateSummaryR implements java.io.Serializable {

	private PlateSummaryRId id;
	private BigDecimal databaseId;

	public PlateSummaryR() {
	}

	public PlateSummaryR(PlateSummaryRId id) {
		this.id = id;
	}

	public PlateSummaryR(PlateSummaryRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public PlateSummaryRId getId() {
		return this.id;
	}

	public void setId(PlateSummaryRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
