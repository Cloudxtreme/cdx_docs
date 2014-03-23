package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * RequestItem generated by hbm2java
 */
public class RequestItem implements java.io.Serializable {

	private RequestItemId id;
	private Subsidiary subsidiary;
	private BigDecimal accessionId;
	private String itemStatus;

	public RequestItem() {
	}

	public RequestItem(RequestItemId id) {
		this.id = id;
	}

	public RequestItem(RequestItemId id, Subsidiary subsidiary,
			BigDecimal accessionId, String itemStatus) {
		this.id = id;
		this.subsidiary = subsidiary;
		this.accessionId = accessionId;
		this.itemStatus = itemStatus;
	}

	public RequestItemId getId() {
		return this.id;
	}

	public void setId(RequestItemId id) {
		this.id = id;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public String getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

}
