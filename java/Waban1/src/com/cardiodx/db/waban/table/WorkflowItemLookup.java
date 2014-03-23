package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;

/**
 * WorkflowItemLookup generated by hbm2java
 */
public class WorkflowItemLookup implements java.io.Serializable {

	private String itemType;
	private Serializable itemObj;

	public WorkflowItemLookup() {
	}

	public WorkflowItemLookup(String itemType, Serializable itemObj) {
		this.itemType = itemType;
		this.itemObj = itemObj;
	}

	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Serializable getItemObj() {
		return this.itemObj;
	}

	public void setItemObj(Serializable itemObj) {
		this.itemObj = itemObj;
	}

}