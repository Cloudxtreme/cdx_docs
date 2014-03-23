package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * GenotypeVariantEntryR generated by hbm2java
 */
public class GenotypeVariantEntryR implements java.io.Serializable {

	private GenotypeVariantEntryRId id;
	private BigDecimal databaseId;

	public GenotypeVariantEntryR() {
	}

	public GenotypeVariantEntryR(GenotypeVariantEntryRId id) {
		this.id = id;
	}

	public GenotypeVariantEntryR(GenotypeVariantEntryRId id,
			BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public GenotypeVariantEntryRId getId() {
		return this.id;
	}

	public void setId(GenotypeVariantEntryRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
