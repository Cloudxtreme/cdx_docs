package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * StudyProtocolR generated by hbm2java
 */
public class StudyProtocolR implements java.io.Serializable {

	private StudyProtocolRId id;
	private BigDecimal databaseId;

	public StudyProtocolR() {
	}

	public StudyProtocolR(StudyProtocolRId id) {
		this.id = id;
	}

	public StudyProtocolR(StudyProtocolRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public StudyProtocolRId getId() {
		return this.id;
	}

	public void setId(StudyProtocolRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
