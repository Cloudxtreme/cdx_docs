package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * PatientR generated by hbm2java
 */
public class PatientR implements java.io.Serializable {

	private PatientRId id;
	private BigDecimal databaseId;

	public PatientR() {
	}

	public PatientR(PatientRId id) {
		this.id = id;
	}

	public PatientR(PatientRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public PatientRId getId() {
		return this.id;
	}

	public void setId(PatientRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
