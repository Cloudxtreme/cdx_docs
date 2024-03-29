package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * MdbProteinRegionR generated by hbm2java
 */
public class MdbProteinRegionR implements java.io.Serializable {

	private MdbProteinRegionRId id;
	private BigDecimal databaseId;

	public MdbProteinRegionR() {
	}

	public MdbProteinRegionR(MdbProteinRegionRId id) {
		this.id = id;
	}

	public MdbProteinRegionR(MdbProteinRegionRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public MdbProteinRegionRId getId() {
		return this.id;
	}

	public void setId(MdbProteinRegionRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
