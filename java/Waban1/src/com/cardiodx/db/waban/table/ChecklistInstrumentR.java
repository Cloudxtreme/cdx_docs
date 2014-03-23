package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * ChecklistInstrumentR generated by hbm2java
 */
public class ChecklistInstrumentR implements java.io.Serializable {

	private ChecklistInstrumentRId id;
	private BigDecimal databaseId;

	public ChecklistInstrumentR() {
	}

	public ChecklistInstrumentR(ChecklistInstrumentRId id) {
		this.id = id;
	}

	public ChecklistInstrumentR(ChecklistInstrumentRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public ChecklistInstrumentRId getId() {
		return this.id;
	}

	public void setId(ChecklistInstrumentRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
