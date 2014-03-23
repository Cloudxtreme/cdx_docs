package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SpecimenRequestR generated by hbm2java
 */
public class SpecimenRequestR implements java.io.Serializable {

	private SpecimenRequestRId id;
	private BigDecimal databaseId;

	public SpecimenRequestR() {
	}

	public SpecimenRequestR(SpecimenRequestRId id) {
		this.id = id;
	}

	public SpecimenRequestR(SpecimenRequestRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public SpecimenRequestRId getId() {
		return this.id;
	}

	public void setId(SpecimenRequestRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}