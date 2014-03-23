package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * OligoDesignR generated by hbm2java
 */
public class OligoDesignR implements java.io.Serializable {

	private OligoDesignRId id;
	private BigDecimal databaseId;

	public OligoDesignR() {
	}

	public OligoDesignR(OligoDesignRId id) {
		this.id = id;
	}

	public OligoDesignR(OligoDesignRId id, BigDecimal databaseId) {
		this.id = id;
		this.databaseId = databaseId;
	}

	public OligoDesignRId getId() {
		return this.id;
	}

	public void setId(OligoDesignRId id) {
		this.id = id;
	}

	public BigDecimal getDatabaseId() {
		return this.databaseId;
	}

	public void setDatabaseId(BigDecimal databaseId) {
		this.databaseId = databaseId;
	}

}
