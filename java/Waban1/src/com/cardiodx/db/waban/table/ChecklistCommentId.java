package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ChecklistCommentId generated by hbm2java
 */
public class ChecklistCommentId implements java.io.Serializable {

	private BigDecimal checklistContentId;
	private String createdBy;
	private Date dateCreated;

	public ChecklistCommentId() {
	}

	public ChecklistCommentId(BigDecimal checklistContentId, String createdBy,
			Date dateCreated) {
		this.checklistContentId = checklistContentId;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public BigDecimal getChecklistContentId() {
		return this.checklistContentId;
	}

	public void setChecklistContentId(BigDecimal checklistContentId) {
		this.checklistContentId = checklistContentId;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ChecklistCommentId))
			return false;
		ChecklistCommentId castOther = (ChecklistCommentId) other;

		return ((this.getChecklistContentId() == castOther
				.getChecklistContentId()) || (this.getChecklistContentId() != null
				&& castOther.getChecklistContentId() != null && this
				.getChecklistContentId().equals(
						castOther.getChecklistContentId())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getChecklistContentId() == null ? 0 : this
						.getChecklistContentId().hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		return result;
	}

}