package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * EventSubscription generated by hbm2java
 */
public class EventSubscription implements java.io.Serializable {

	private BigDecimal eventSubscriptionId;
	private EventHandler eventHandler;
	private StudyProtocol studyProtocol;
	private Subsidiary subsidiary;
	private Event event;
	private Boolean warning;
	private Boolean locked;
	private BigDecimal priority;
	private String createdBy;
	private Date dateCreated;

	public EventSubscription() {
	}

	public EventSubscription(BigDecimal eventSubscriptionId,
			EventHandler eventHandler, Event event) {
		this.eventSubscriptionId = eventSubscriptionId;
		this.eventHandler = eventHandler;
		this.event = event;
	}

	public EventSubscription(BigDecimal eventSubscriptionId,
			EventHandler eventHandler, StudyProtocol studyProtocol,
			Subsidiary subsidiary, Event event, Boolean warning,
			Boolean locked, BigDecimal priority, String createdBy,
			Date dateCreated) {
		this.eventSubscriptionId = eventSubscriptionId;
		this.eventHandler = eventHandler;
		this.studyProtocol = studyProtocol;
		this.subsidiary = subsidiary;
		this.event = event;
		this.warning = warning;
		this.locked = locked;
		this.priority = priority;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public BigDecimal getEventSubscriptionId() {
		return this.eventSubscriptionId;
	}

	public void setEventSubscriptionId(BigDecimal eventSubscriptionId) {
		this.eventSubscriptionId = eventSubscriptionId;
	}

	public EventHandler getEventHandler() {
		return this.eventHandler;
	}

	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}

	public StudyProtocol getStudyProtocol() {
		return this.studyProtocol;
	}

	public void setStudyProtocol(StudyProtocol studyProtocol) {
		this.studyProtocol = studyProtocol;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Boolean getWarning() {
		return this.warning;
	}

	public void setWarning(Boolean warning) {
		this.warning = warning;
	}

	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public BigDecimal getPriority() {
		return this.priority;
	}

	public void setPriority(BigDecimal priority) {
		this.priority = priority;
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
