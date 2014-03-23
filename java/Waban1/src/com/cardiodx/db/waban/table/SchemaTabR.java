package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SchemaTabR generated by hbm2java
 */
public class SchemaTabR implements java.io.Serializable {

	private SchemaTabRId id;
	private BigDecimal databaseId;

	public SchemaTabR() {
	}

	public SchemaTabR(SchemaTabRId id) {
		this.id = id;
	}

	public SchemaTabR(SchemaTabRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public SchemaTabRId getId() {
		return this.id;
	}

	public void setId(SchemaTabRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}