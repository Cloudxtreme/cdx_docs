package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * VariableTypeR generated by hbm2java
 */
public class VariableTypeR implements java.io.Serializable {

	private VariableTypeRId id;
	private BigDecimal databaseId;

	public VariableTypeR() {
	}

	public VariableTypeR(VariableTypeRId id) {
		this.id = id;
	}

	public VariableTypeR(VariableTypeRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public VariableTypeRId getId() {
		return this.id;
	}

	public void setId(VariableTypeRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
