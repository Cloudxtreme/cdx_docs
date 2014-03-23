package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * GelMarker generated by hbm2java
 */
public class GelMarker implements java.io.Serializable {

	private GelMarkerId id;
	private Reagent reagent;
	private Container container;
	private Subsidiary subsidiary;
	private String createdBy;
	private Date dateCreated;

	public GelMarker() {
	}

	public GelMarker(GelMarkerId id, Container container) {
		this.id = id;
		this.container = container;
	}

	public GelMarker(GelMarkerId id, Reagent reagent, Container container,
			Subsidiary subsidiary, String createdBy, Date dateCreated) {
		this.id = id;
		this.reagent = reagent;
		this.container = container;
		this.subsidiary = subsidiary;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public GelMarkerId getId() {
		return this.id;
	}

	public void setId(GelMarkerId id) {
		this.id = id;
	}

	public Reagent getReagent() {
		return this.reagent;
	}

	public void setReagent(Reagent reagent) {
		this.reagent = reagent;
	}

	public Container getContainer() {
		return this.container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
