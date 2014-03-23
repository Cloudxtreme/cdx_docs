package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SubsidiaryR generated by hbm2java
 */
public class SubsidiaryR implements java.io.Serializable {

	private SubsidiaryRId id;
	private BigDecimal databaseId;

	public SubsidiaryR() {
	}

	public SubsidiaryR(SubsidiaryRId id) {
		this.id = id;
	}

	public SubsidiaryR(SubsidiaryRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public SubsidiaryRId getId() {
		return this.id;
	}

	public void setId(SubsidiaryRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
