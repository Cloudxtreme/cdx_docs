package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * TechniqueTypeR generated by hbm2java
 */
public class TechniqueTypeR implements java.io.Serializable {

	private TechniqueTypeRId id;
	private BigDecimal databaseId;

	public TechniqueTypeR() {
	}

	public TechniqueTypeR(TechniqueTypeRId id) {
		this.id = id;
	}

	public TechniqueTypeR(TechniqueTypeRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public TechniqueTypeRId getId() {
		return this.id;
	}

	public void setId(TechniqueTypeRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
