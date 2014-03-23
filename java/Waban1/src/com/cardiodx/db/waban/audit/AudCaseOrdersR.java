package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * AudCaseOrdersR generated by hbm2java
 */
public class AudCaseOrdersR implements java.io.Serializable {

	private AudCaseOrdersRId id;
	private BigDecimal databaseId;

	public AudCaseOrdersR() {
	}

	public AudCaseOrdersR(AudCaseOrdersRId id) {
		this.id = id;
	}

	public AudCaseOrdersR(AudCaseOrdersRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public AudCaseOrdersRId getId() {
		return this.id;
	}

	public void setId(AudCaseOrdersRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
