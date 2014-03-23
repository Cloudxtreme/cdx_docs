package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * SampleSearchViewId generated by hbm2java
 */
public class SampleSearchViewId implements java.io.Serializable {

	private String sampleTubeId;
	private String accessionNumber;
	private String sourceType;
	private String studyNumber;
	private String location;
	private String freezer;
	private BigDecimal volume;
	private BigDecimal concentration;
	private String sampleStatus;
	private String sampleCondition;
	private String proceedFurther;
	private String proceedDetails;
	private Character lastCol;
	private Character consentDna;
	private Character consentStorage;
	private Character centralLab;
	private String dateCollected;
	private Boolean finalStorageTube;
	private Date datePurified;
	private String clientSampleTubeId;
	private Date dateCreated;
	private Boolean destroyed;
	private BigDecimal sampleId;
	private BigDecimal accessionId;
	private BigDecimal studyProtocolId;
	private String containerId;

	public SampleSearchViewId() {
	}

	public SampleSearchViewId(String accessionNumber, BigDecimal sampleId,
			BigDecimal accessionId, BigDecimal studyProtocolId) {
		this.accessionNumber = accessionNumber;
		this.sampleId = sampleId;
		this.accessionId = accessionId;
		this.studyProtocolId = studyProtocolId;
	}

	public SampleSearchViewId(String sampleTubeId, String accessionNumber,
			String sourceType, String studyNumber, String location,
			String freezer, BigDecimal volume, BigDecimal concentration,
			String sampleStatus, String sampleCondition, String proceedFurther,
			String proceedDetails, Character lastCol, Character consentDna,
			Character consentStorage, Character centralLab,
			String dateCollected, Boolean finalStorageTube, Date datePurified,
			String clientSampleTubeId, Date dateCreated, Boolean destroyed,
			BigDecimal sampleId, BigDecimal accessionId,
			BigDecimal studyProtocolId, String containerId) {
		this.sampleTubeId = sampleTubeId;
		this.accessionNumber = accessionNumber;
		this.sourceType = sourceType;
		this.studyNumber = studyNumber;
		this.location = location;
		this.freezer = freezer;
		this.volume = volume;
		this.concentration = concentration;
		this.sampleStatus = sampleStatus;
		this.sampleCondition = sampleCondition;
		this.proceedFurther = proceedFurther;
		this.proceedDetails = proceedDetails;
		this.lastCol = lastCol;
		this.consentDna = consentDna;
		this.consentStorage = consentStorage;
		this.centralLab = centralLab;
		this.dateCollected = dateCollected;
		this.finalStorageTube = finalStorageTube;
		this.datePurified = datePurified;
		this.clientSampleTubeId = clientSampleTubeId;
		this.dateCreated = dateCreated;
		this.destroyed = destroyed;
		this.sampleId = sampleId;
		this.accessionId = accessionId;
		this.studyProtocolId = studyProtocolId;
		this.containerId = containerId;
	}

	public String getSampleTubeId() {
		return this.sampleTubeId;
	}

	public void setSampleTubeId(String sampleTubeId) {
		this.sampleTubeId = sampleTubeId;
	}

	public String getAccessionNumber() {
		return this.accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getStudyNumber() {
		return this.studyNumber;
	}

	public void setStudyNumber(String studyNumber) {
		this.studyNumber = studyNumber;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFreezer() {
		return this.freezer;
	}

	public void setFreezer(String freezer) {
		this.freezer = freezer;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getConcentration() {
		return this.concentration;
	}

	public void setConcentration(BigDecimal concentration) {
		this.concentration = concentration;
	}

	public String getSampleStatus() {
		return this.sampleStatus;
	}

	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}

	public String getSampleCondition() {
		return this.sampleCondition;
	}

	public void setSampleCondition(String sampleCondition) {
		this.sampleCondition = sampleCondition;
	}

	public String getProceedFurther() {
		return this.proceedFurther;
	}

	public void setProceedFurther(String proceedFurther) {
		this.proceedFurther = proceedFurther;
	}

	public String getProceedDetails() {
		return this.proceedDetails;
	}

	public void setProceedDetails(String proceedDetails) {
		this.proceedDetails = proceedDetails;
	}

	public Character getLastCol() {
		return this.lastCol;
	}

	public void setLastCol(Character lastCol) {
		this.lastCol = lastCol;
	}

	public Character getConsentDna() {
		return this.consentDna;
	}

	public void setConsentDna(Character consentDna) {
		this.consentDna = consentDna;
	}

	public Character getConsentStorage() {
		return this.consentStorage;
	}

	public void setConsentStorage(Character consentStorage) {
		this.consentStorage = consentStorage;
	}

	public Character getCentralLab() {
		return this.centralLab;
	}

	public void setCentralLab(Character centralLab) {
		this.centralLab = centralLab;
	}

	public String getDateCollected() {
		return this.dateCollected;
	}

	public void setDateCollected(String dateCollected) {
		this.dateCollected = dateCollected;
	}

	public Boolean getFinalStorageTube() {
		return this.finalStorageTube;
	}

	public void setFinalStorageTube(Boolean finalStorageTube) {
		this.finalStorageTube = finalStorageTube;
	}

	public Date getDatePurified() {
		return this.datePurified;
	}

	public void setDatePurified(Date datePurified) {
		this.datePurified = datePurified;
	}

	public String getClientSampleTubeId() {
		return this.clientSampleTubeId;
	}

	public void setClientSampleTubeId(String clientSampleTubeId) {
		this.clientSampleTubeId = clientSampleTubeId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Boolean getDestroyed() {
		return this.destroyed;
	}

	public void setDestroyed(Boolean destroyed) {
		this.destroyed = destroyed;
	}

	public BigDecimal getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(BigDecimal sampleId) {
		this.sampleId = sampleId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SampleSearchViewId))
			return false;
		SampleSearchViewId castOther = (SampleSearchViewId) other;

		return ((this.getSampleTubeId() == castOther.getSampleTubeId()) || (this
				.getSampleTubeId() != null
				&& castOther.getSampleTubeId() != null && this
				.getSampleTubeId().equals(castOther.getSampleTubeId())))
				&& ((this.getAccessionNumber() == castOther
						.getAccessionNumber()) || (this.getAccessionNumber() != null
						&& castOther.getAccessionNumber() != null && this
						.getAccessionNumber().equals(
								castOther.getAccessionNumber())))
				&& ((this.getSourceType() == castOther.getSourceType()) || (this
						.getSourceType() != null
						&& castOther.getSourceType() != null && this
						.getSourceType().equals(castOther.getSourceType())))
				&& ((this.getStudyNumber() == castOther.getStudyNumber()) || (this
						.getStudyNumber() != null
						&& castOther.getStudyNumber() != null && this
						.getStudyNumber().equals(castOther.getStudyNumber())))
				&& ((this.getLocation() == castOther.getLocation()) || (this
						.getLocation() != null
						&& castOther.getLocation() != null && this
						.getLocation().equals(castOther.getLocation())))
				&& ((this.getFreezer() == castOther.getFreezer()) || (this
						.getFreezer() != null && castOther.getFreezer() != null && this
						.getFreezer().equals(castOther.getFreezer())))
				&& ((this.getVolume() == castOther.getVolume()) || (this
						.getVolume() != null && castOther.getVolume() != null && this
						.getVolume().equals(castOther.getVolume())))
				&& ((this.getConcentration() == castOther.getConcentration()) || (this
						.getConcentration() != null
						&& castOther.getConcentration() != null && this
						.getConcentration()
						.equals(castOther.getConcentration())))
				&& ((this.getSampleStatus() == castOther.getSampleStatus()) || (this
						.getSampleStatus() != null
						&& castOther.getSampleStatus() != null && this
						.getSampleStatus().equals(castOther.getSampleStatus())))
				&& ((this.getSampleCondition() == castOther
						.getSampleCondition()) || (this.getSampleCondition() != null
						&& castOther.getSampleCondition() != null && this
						.getSampleCondition().equals(
								castOther.getSampleCondition())))
				&& ((this.getProceedFurther() == castOther.getProceedFurther()) || (this
						.getProceedFurther() != null
						&& castOther.getProceedFurther() != null && this
						.getProceedFurther().equals(
								castOther.getProceedFurther())))
				&& ((this.getProceedDetails() == castOther.getProceedDetails()) || (this
						.getProceedDetails() != null
						&& castOther.getProceedDetails() != null && this
						.getProceedDetails().equals(
								castOther.getProceedDetails())))
				&& ((this.getLastCol() == castOther.getLastCol()) || (this
						.getLastCol() != null && castOther.getLastCol() != null && this
						.getLastCol().equals(castOther.getLastCol())))
				&& ((this.getConsentDna() == castOther.getConsentDna()) || (this
						.getConsentDna() != null
						&& castOther.getConsentDna() != null && this
						.getConsentDna().equals(castOther.getConsentDna())))
				&& ((this.getConsentStorage() == castOther.getConsentStorage()) || (this
						.getConsentStorage() != null
						&& castOther.getConsentStorage() != null && this
						.getConsentStorage().equals(
								castOther.getConsentStorage())))
				&& ((this.getCentralLab() == castOther.getCentralLab()) || (this
						.getCentralLab() != null
						&& castOther.getCentralLab() != null && this
						.getCentralLab().equals(castOther.getCentralLab())))
				&& ((this.getDateCollected() == castOther.getDateCollected()) || (this
						.getDateCollected() != null
						&& castOther.getDateCollected() != null && this
						.getDateCollected()
						.equals(castOther.getDateCollected())))
				&& ((this.getFinalStorageTube() == castOther
						.getFinalStorageTube()) || (this.getFinalStorageTube() != null
						&& castOther.getFinalStorageTube() != null && this
						.getFinalStorageTube().equals(
								castOther.getFinalStorageTube())))
				&& ((this.getDatePurified() == castOther.getDatePurified()) || (this
						.getDatePurified() != null
						&& castOther.getDatePurified() != null && this
						.getDatePurified().equals(castOther.getDatePurified())))
				&& ((this.getClientSampleTubeId() == castOther
						.getClientSampleTubeId()) || (this
						.getClientSampleTubeId() != null
						&& castOther.getClientSampleTubeId() != null && this
						.getClientSampleTubeId().equals(
								castOther.getClientSampleTubeId())))
				&& ((this.getDateCreated() == castOther.getDateCreated()) || (this
						.getDateCreated() != null
						&& castOther.getDateCreated() != null && this
						.getDateCreated().equals(castOther.getDateCreated())))
				&& ((this.getDestroyed() == castOther.getDestroyed()) || (this
						.getDestroyed() != null
						&& castOther.getDestroyed() != null && this
						.getDestroyed().equals(castOther.getDestroyed())))
				&& ((this.getSampleId() == castOther.getSampleId()) || (this
						.getSampleId() != null
						&& castOther.getSampleId() != null && this
						.getSampleId().equals(castOther.getSampleId())))
				&& ((this.getAccessionId() == castOther.getAccessionId()) || (this
						.getAccessionId() != null
						&& castOther.getAccessionId() != null && this
						.getAccessionId().equals(castOther.getAccessionId())))
				&& ((this.getStudyProtocolId() == castOther
						.getStudyProtocolId()) || (this.getStudyProtocolId() != null
						&& castOther.getStudyProtocolId() != null && this
						.getStudyProtocolId().equals(
								castOther.getStudyProtocolId())))
				&& ((this.getContainerId() == castOther.getContainerId()) || (this
						.getContainerId() != null
						&& castOther.getContainerId() != null && this
						.getContainerId().equals(castOther.getContainerId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSampleTubeId() == null ? 0 : this.getSampleTubeId()
						.hashCode());
		result = 37
				* result
				+ (getAccessionNumber() == null ? 0 : this.getAccessionNumber()
						.hashCode());
		result = 37
				* result
				+ (getSourceType() == null ? 0 : this.getSourceType()
						.hashCode());
		result = 37
				* result
				+ (getStudyNumber() == null ? 0 : this.getStudyNumber()
						.hashCode());
		result = 37 * result
				+ (getLocation() == null ? 0 : this.getLocation().hashCode());
		result = 37 * result
				+ (getFreezer() == null ? 0 : this.getFreezer().hashCode());
		result = 37 * result
				+ (getVolume() == null ? 0 : this.getVolume().hashCode());
		result = 37
				* result
				+ (getConcentration() == null ? 0 : this.getConcentration()
						.hashCode());
		result = 37
				* result
				+ (getSampleStatus() == null ? 0 : this.getSampleStatus()
						.hashCode());
		result = 37
				* result
				+ (getSampleCondition() == null ? 0 : this.getSampleCondition()
						.hashCode());
		result = 37
				* result
				+ (getProceedFurther() == null ? 0 : this.getProceedFurther()
						.hashCode());
		result = 37
				* result
				+ (getProceedDetails() == null ? 0 : this.getProceedDetails()
						.hashCode());
		result = 37 * result
				+ (getLastCol() == null ? 0 : this.getLastCol().hashCode());
		result = 37
				* result
				+ (getConsentDna() == null ? 0 : this.getConsentDna()
						.hashCode());
		result = 37
				* result
				+ (getConsentStorage() == null ? 0 : this.getConsentStorage()
						.hashCode());
		result = 37
				* result
				+ (getCentralLab() == null ? 0 : this.getCentralLab()
						.hashCode());
		result = 37
				* result
				+ (getDateCollected() == null ? 0 : this.getDateCollected()
						.hashCode());
		result = 37
				* result
				+ (getFinalStorageTube() == null ? 0 : this
						.getFinalStorageTube().hashCode());
		result = 37
				* result
				+ (getDatePurified() == null ? 0 : this.getDatePurified()
						.hashCode());
		result = 37
				* result
				+ (getClientSampleTubeId() == null ? 0 : this
						.getClientSampleTubeId().hashCode());
		result = 37
				* result
				+ (getDateCreated() == null ? 0 : this.getDateCreated()
						.hashCode());
		result = 37 * result
				+ (getDestroyed() == null ? 0 : this.getDestroyed().hashCode());
		result = 37 * result
				+ (getSampleId() == null ? 0 : this.getSampleId().hashCode());
		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		result = 37
				* result
				+ (getStudyProtocolId() == null ? 0 : this.getStudyProtocolId()
						.hashCode());
		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		return result;
	}

}