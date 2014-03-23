package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * EmailQueue generated by hbm2java
 */
public class EmailQueue implements java.io.Serializable {

	private BigDecimal emailQueueId;
	private Subsidiary subsidiary;
	private String emailTo;
	private String emailFrom;
	private String emailSubject;
	private String mailContent;
	private String status;
	private Date dateQueued;
	private Date dateSent;
	private BigDecimal noOfAttempts;
	private String lastErrStr;

	public EmailQueue() {
	}

	public EmailQueue(BigDecimal emailQueueId) {
		this.emailQueueId = emailQueueId;
	}

	public EmailQueue(BigDecimal emailQueueId, Subsidiary subsidiary,
			String emailTo, String emailFrom, String emailSubject,
			String mailContent, String status, Date dateQueued, Date dateSent,
			BigDecimal noOfAttempts, String lastErrStr) {
		this.emailQueueId = emailQueueId;
		this.subsidiary = subsidiary;
		this.emailTo = emailTo;
		this.emailFrom = emailFrom;
		this.emailSubject = emailSubject;
		this.mailContent = mailContent;
		this.status = status;
		this.dateQueued = dateQueued;
		this.dateSent = dateSent;
		this.noOfAttempts = noOfAttempts;
		this.lastErrStr = lastErrStr;
	}

	public BigDecimal getEmailQueueId() {
		return this.emailQueueId;
	}

	public void setEmailQueueId(BigDecimal emailQueueId) {
		this.emailQueueId = emailQueueId;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getEmailTo() {
		return this.emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getEmailFrom() {
		return this.emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailSubject() {
		return this.emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getMailContent() {
		return this.mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateQueued() {
		return this.dateQueued;
	}

	public void setDateQueued(Date dateQueued) {
		this.dateQueued = dateQueued;
	}

	public Date getDateSent() {
		return this.dateSent;
	}

	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}

	public BigDecimal getNoOfAttempts() {
		return this.noOfAttempts;
	}

	public void setNoOfAttempts(BigDecimal noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public String getLastErrStr() {
		return this.lastErrStr;
	}

	public void setLastErrStr(String lastErrStr) {
		this.lastErrStr = lastErrStr;
	}

}
