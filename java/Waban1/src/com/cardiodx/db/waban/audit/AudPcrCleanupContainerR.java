package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * AudPcrCleanupContainerR generated by hbm2java
 */
public class AudPcrCleanupContainerR implements java.io.Serializable {

	private AudPcrCleanupContainerRId id;
	private BigDecimal databaseId;

	public AudPcrCleanupContainerR() {
	}

	public AudPcrCleanupContainerR(AudPcrCleanupContainerRId id) {
		this.id = id;
	}

	public AudPcrCleanupContainerR(AudPcrCleanupContainerRId id,
			BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public AudPcrCleanupContainerRId getId() {
		return this.id;
	}

	public void setId(AudPcrCleanupContainerRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
