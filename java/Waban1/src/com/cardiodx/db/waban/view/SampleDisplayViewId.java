package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SampleDisplayViewId generated by hbm2java
 */
public class SampleDisplayViewId implements java.io.Serializable {

	private String sampleTubeId;
	private String clientSampleTubeId;
	private String sampleStatus;
	private String location;
	private String sourceType;
	private String containerId;
	private BigDecimal containerRow;
	private BigDecimal containerColumn;
	private String sampleCondition;
	private String initialVolume;
	private String dateReceived;
	private BigDecimal volume;
	private BigDecimal concentration;
	private Boolean finalStorageTube;
	private BigDecimal numberInAccSequence;
	private BigDecimal sampleId;
	private BigDecimal pendingSampleId;
	private BigDecimal accessionId;
	private String accessionNumber;
	private BigDecimal studyProtocolId;

	public SampleDisplayViewId() {
	}

	public SampleDisplayViewId(String sampleTubeId, String clientSampleTubeId,
			String sampleStatus, String location, String sourceType,
			String containerId, BigDecimal containerRow,
			BigDecimal containerColumn, String sampleCondition,
			String initialVolume, String dateReceived, BigDecimal volume,
			BigDecimal concentration, Boolean finalStorageTube,
			BigDecimal numberInAccSequence, BigDecimal sampleId,
			BigDecimal pendingSampleId, BigDecimal accessionId,
			String accessionNumber, BigDecimal studyProtocolId) {
		this.sampleTubeId = sampleTubeId;
		this.clientSampleTubeId = clientSampleTubeId;
		this.sampleStatus = sampleStatus;
		this.location = location;
		this.sourceType = sourceType;
		this.containerId = containerId;
		this.containerRow = containerRow;
		this.containerColumn = containerColumn;
		this.sampleCondition = sampleCondition;
		this.initialVolume = initialVolume;
		this.dateReceived = dateReceived;
		this.volume = volume;
		this.concentration = concentration;
		this.finalStorageTube = finalStorageTube;
		this.numberInAccSequence = numberInAccSequence;
		this.sampleId = sampleId;
		this.pendingSampleId = pendingSampleId;
		this.accessionId = accessionId;
		this.accessionNumber = accessionNumber;
		this.studyProtocolId = studyProtocolId;
	}

	public String getSampleTubeId() {
		return this.sampleTubeId;
	}

	public void setSampleTubeId(String sampleTubeId) {
		this.sampleTubeId = sampleTubeId;
	}

	public String getClientSampleTubeId() {
		return this.clientSampleTubeId;
	}

	public void setClientSampleTubeId(String clientSampleTubeId) {
		this.clientSampleTubeId = clientSampleTubeId;
	}

	public String getSampleStatus() {
		return this.sampleStatus;
	}

	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public BigDecimal getContainerRow() {
		return this.containerRow;
	}

	public void setContainerRow(BigDecimal containerRow) {
		this.containerRow = containerRow;
	}

	public BigDecimal getContainerColumn() {
		return this.containerColumn;
	}

	public void setContainerColumn(BigDecimal containerColumn) {
		this.containerColumn = containerColumn;
	}

	public String getSampleCondition() {
		return this.sampleCondition;
	}

	public void setSampleCondition(String sampleCondition) {
		this.sampleCondition = sampleCondition;
	}

	public String getInitialVolume() {
		return this.initialVolume;
	}

	public void setInitialVolume(String initialVolume) {
		this.initialVolume = initialVolume;
	}

	public String getDateReceived() {
		return this.dateReceived;
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
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

	public Boolean getFinalStorageTube() {
		return this.finalStorageTube;
	}

	public void setFinalStorageTube(Boolean finalStorageTube) {
		this.finalStorageTube = finalStorageTube;
	}

	public BigDecimal getNumberInAccSequence() {
		return this.numberInAccSequence;
	}

	public void setNumberInAccSequence(BigDecimal numberInAccSequence) {
		this.numberInAccSequence = numberInAccSequence;
	}

	public BigDecimal getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(BigDecimal sampleId) {
		this.sampleId = sampleId;
	}

	public BigDecimal getPendingSampleId() {
		return this.pendingSampleId;
	}

	public void setPendingSampleId(BigDecimal pendingSampleId) {
		this.pendingSampleId = pendingSampleId;
	}

	public BigDecimal getAccessionId() {
		return this.accessionId;
	}

	public void setAccessionId(BigDecimal accessionId) {
		this.accessionId = accessionId;
	}

	public String getAccessionNumber() {
		return this.accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public BigDecimal getStudyProtocolId() {
		return this.studyProtocolId;
	}

	public void setStudyProtocolId(BigDecimal studyProtocolId) {
		this.studyProtocolId = studyProtocolId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SampleDisplayViewId))
			return false;
		SampleDisplayViewId castOther = (SampleDisplayViewId) other;

		return ((this.getSampleTubeId() == castOther.getSampleTubeId()) || (this
				.getSampleTubeId() != null
				&& castOther.getSampleTubeId() != null && this
				.getSampleTubeId().equals(castOther.getSampleTubeId())))
				&& ((this.getClientSampleTubeId() == castOther
						.getClientSampleTubeId()) || (this
						.getClientSampleTubeId() != null
						&& castOther.getClientSampleTubeId() != null && this
						.getClientSampleTubeId().equals(
								castOther.getClientSampleTubeId())))
				&& ((this.getSampleStatus() == castOther.getSampleStatus()) || (this
						.getSampleStatus() != null
						&& castOther.getSampleStatus() != null && this
						.getSampleStatus().equals(castOther.getSampleStatus())))
				&& ((this.getLocation() == castOther.getLocation()) || (this
						.getLocation() != null
						&& castOther.getLocation() != null && this
						.getLocation().equals(castOther.getLocation())))
				&& ((this.getSourceType() == castOther.getSourceType()) || (this
						.getSourceType() != null
						&& castOther.getSourceType() != null && this
						.getSourceType().equals(castOther.getSourceType())))
				&& ((this.getContainerId() == castOther.getContainerId()) || (this
						.getContainerId() != null
						&& castOther.getContainerId() != null && this
						.getContainerId().equals(castOther.getContainerId())))
				&& ((this.getContainerRow() == castOther.getContainerRow()) || (this
						.getContainerRow() != null
						&& castOther.getContainerRow() != null && this
						.getContainerRow().equals(castOther.getContainerRow())))
				&& ((this.getContainerColumn() == castOther
						.getContainerColumn()) || (this.getContainerColumn() != null
						&& castOther.getContainerColumn() != null && this
						.getContainerColumn().equals(
								castOther.getContainerColumn())))
				&& ((this.getSampleCondition() == castOther
						.getSampleCondition()) || (this.getSampleCondition() != null
						&& castOther.getSampleCondition() != null && this
						.getSampleCondition().equals(
								castOther.getSampleCondition())))
				&& ((this.getInitialVolume() == castOther.getInitialVolume()) || (this
						.getInitialVolume() != null
						&& castOther.getInitialVolume() != null && this
						.getInitialVolume()
						.equals(castOther.getInitialVolume())))
				&& ((this.getDateReceived() == castOther.getDateReceived()) || (this
						.getDateReceived() != null
						&& castOther.getDateReceived() != null && this
						.getDateReceived().equals(castOther.getDateReceived())))
				&& ((this.getVolume() == castOther.getVolume()) || (this
						.getVolume() != null && castOther.getVolume() != null && this
						.getVolume().equals(castOther.getVolume())))
				&& ((this.getConcentration() == castOther.getConcentration()) || (this
						.getConcentration() != null
						&& castOther.getConcentration() != null && this
						.getConcentration()
						.equals(castOther.getConcentration())))
				&& ((this.getFinalStorageTube() == castOther
						.getFinalStorageTube()) || (this.getFinalStorageTube() != null
						&& castOther.getFinalStorageTube() != null && this
						.getFinalStorageTube().equals(
								castOther.getFinalStorageTube())))
				&& ((this.getNumberInAccSequence() == castOther
						.getNumberInAccSequence()) || (this
						.getNumberInAccSequence() != null
						&& castOther.getNumberInAccSequence() != null && this
						.getNumberInAccSequence().equals(
								castOther.getNumberInAccSequence())))
				&& ((this.getSampleId() == castOther.getSampleId()) || (this
						.getSampleId() != null
						&& castOther.getSampleId() != null && this
						.getSampleId().equals(castOther.getSampleId())))
				&& ((this.getPendingSampleId() == castOther
						.getPendingSampleId()) || (this.getPendingSampleId() != null
						&& castOther.getPendingSampleId() != null && this
						.getPendingSampleId().equals(
								castOther.getPendingSampleId())))
				&& ((this.getAccessionId() == castOther.getAccessionId()) || (this
						.getAccessionId() != null
						&& castOther.getAccessionId() != null && this
						.getAccessionId().equals(castOther.getAccessionId())))
				&& ((this.getAccessionNumber() == castOther
						.getAccessionNumber()) || (this.getAccessionNumber() != null
						&& castOther.getAccessionNumber() != null && this
						.getAccessionNumber().equals(
								castOther.getAccessionNumber())))
				&& ((this.getStudyProtocolId() == castOther
						.getStudyProtocolId()) || (this.getStudyProtocolId() != null
						&& castOther.getStudyProtocolId() != null && this
						.getStudyProtocolId().equals(
								castOther.getStudyProtocolId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSampleTubeId() == null ? 0 : this.getSampleTubeId()
						.hashCode());
		result = 37
				* result
				+ (getClientSampleTubeId() == null ? 0 : this
						.getClientSampleTubeId().hashCode());
		result = 37
				* result
				+ (getSampleStatus() == null ? 0 : this.getSampleStatus()
						.hashCode());
		result = 37 * result
				+ (getLocation() == null ? 0 : this.getLocation().hashCode());
		result = 37
				* result
				+ (getSourceType() == null ? 0 : this.getSourceType()
						.hashCode());
		result = 37
				* result
				+ (getContainerId() == null ? 0 : this.getContainerId()
						.hashCode());
		result = 37
				* result
				+ (getContainerRow() == null ? 0 : this.getContainerRow()
						.hashCode());
		result = 37
				* result
				+ (getContainerColumn() == null ? 0 : this.getContainerColumn()
						.hashCode());
		result = 37
				* result
				+ (getSampleCondition() == null ? 0 : this.getSampleCondition()
						.hashCode());
		result = 37
				* result
				+ (getInitialVolume() == null ? 0 : this.getInitialVolume()
						.hashCode());
		result = 37
				* result
				+ (getDateReceived() == null ? 0 : this.getDateReceived()
						.hashCode());
		result = 37 * result
				+ (getVolume() == null ? 0 : this.getVolume().hashCode());
		result = 37
				* result
				+ (getConcentration() == null ? 0 : this.getConcentration()
						.hashCode());
		result = 37
				* result
				+ (getFinalStorageTube() == null ? 0 : this
						.getFinalStorageTube().hashCode());
		result = 37
				* result
				+ (getNumberInAccSequence() == null ? 0 : this
						.getNumberInAccSequence().hashCode());
		result = 37 * result
				+ (getSampleId() == null ? 0 : this.getSampleId().hashCode());
		result = 37
				* result
				+ (getPendingSampleId() == null ? 0 : this.getPendingSampleId()
						.hashCode());
		result = 37
				* result
				+ (getAccessionId() == null ? 0 : this.getAccessionId()
						.hashCode());
		result = 37
				* result
				+ (getAccessionNumber() == null ? 0 : this.getAccessionNumber()
						.hashCode());
		result = 37
				* result
				+ (getStudyProtocolId() == null ? 0 : this.getStudyProtocolId()
						.hashCode());
		return result;
	}

}
