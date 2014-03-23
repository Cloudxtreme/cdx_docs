package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * OrganizationR generated by hbm2java
 */
public class OrganizationR implements java.io.Serializable {

	private OrganizationRId id;
	private BigDecimal databaseId;

	public OrganizationR() {
	}

	public OrganizationR(OrganizationRId id) {
		this.id = id;
	}

	public OrganizationR(OrganizationRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public OrganizationRId getId() {
		return this.id;
	}

	public void setId(OrganizationRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
