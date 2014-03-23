package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:32:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * AudSampleVariableFldR generated by hbm2java
 */
public class AudSampleVariableFldR implements java.io.Serializable {

	private AudSampleVariableFldRId id;
	private BigDecimal databaseId;

	public AudSampleVariableFldR() {
	}

	public AudSampleVariableFldR(AudSampleVariableFldRId id) {
		this.id = id;
	}

	public AudSampleVariableFldR(AudSampleVariableFldRId id,
			BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public AudSampleVariableFldRId getId() {
		return this.id;
	}

	public void setId(AudSampleVariableFldRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
