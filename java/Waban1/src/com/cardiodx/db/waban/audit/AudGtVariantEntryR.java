package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * AudGtVariantEntryR generated by hbm2java
 */
public class AudGtVariantEntryR implements java.io.Serializable {

	private AudGtVariantEntryRId id;
	private BigDecimal databaseId;

	public AudGtVariantEntryR() {
	}

	public AudGtVariantEntryR(AudGtVariantEntryRId id) {
		this.id = id;
	}

	public AudGtVariantEntryR(AudGtVariantEntryRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public AudGtVariantEntryRId getId() {
		return this.id;
	}

	public void setId(AudGtVariantEntryRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}