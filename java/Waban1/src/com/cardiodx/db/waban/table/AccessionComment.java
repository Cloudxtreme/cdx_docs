package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

/**
 * AccessionComment generated by hbm2java
 */
public class AccessionComment implements java.io.Serializable {

	private AccessionCommentId id;
	private Accession accession;
	private Subsidiary subsidiary;
	private String comments;

	public AccessionComment() {
	}

	public AccessionComment(AccessionCommentId id, Accession accession) {
		this.id = id;
		this.accession = accession;
	}

	public AccessionComment(AccessionCommentId id, Accession accession,
			Subsidiary subsidiary, String comments) {
		this.id = id;
		this.accession = accession;
		this.subsidiary = subsidiary;
		this.comments = comments;
	}

	public AccessionCommentId getId() {
		return this.id;
	}

	public void setId(AccessionCommentId id) {
		this.id = id;
	}

	public Accession getAccession() {
		return this.accession;
	}

	public void setAccession(Accession accession) {
		this.accession = accession;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}