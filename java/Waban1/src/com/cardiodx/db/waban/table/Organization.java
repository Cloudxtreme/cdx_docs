package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Organization generated by hbm2java
 */
public class Organization implements java.io.Serializable {

	private BigDecimal organizationId;
	private String company;
	private String organizationType;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String contact;
	private String email;
	private String phone;
	private String fax;
	private String comments;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private Set<ShipmentSample> shipmentSamples = new HashSet<ShipmentSample>(0);
	private Set<CaseVariableFldTable> caseVariableFldTables = new HashSet<CaseVariableFldTable>(
			0);
	private Set<AccessionVariableFldTable> accessionVariableFldTables = new HashSet<AccessionVariableFldTable>(
			0);
	private Set<TestAttributeFld> testAttributeFlds = new HashSet<TestAttributeFld>(
			0);
	private Set<StudyVariableFld> studyVariableFlds = new HashSet<StudyVariableFld>(
			0);
	private Set<Contact> contacts = new HashSet<Contact>(0);
	private Set<OutboundRequest> outboundRequests = new HashSet<OutboundRequest>(
			0);
	private Set<Instrument> instruments = new HashSet<Instrument>(0);
	private Set<SpecimenShipmentAirbill> specimenShipmentAirbills = new HashSet<SpecimenShipmentAirbill>(
			0);
	private Set<SampleReception> sampleReceptions = new HashSet<SampleReception>(
			0);
	private Set<GenotypingVendorAssayMap> genotypingVendorAssayMaps = new HashSet<GenotypingVendorAssayMap>(
			0);
	private Set<Reagent> reagents = new HashSet<Reagent>(0);
	private Set<ShipmentReceipt> shipmentReceipts = new HashSet<ShipmentReceipt>(
			0);
	private Set<PatientVariableFld> patientVariableFlds = new HashSet<PatientVariableFld>(
			0);
	private Set<SpecimenShipment> specimenShipments = new HashSet<SpecimenShipment>(
			0);
	private Set<GenotypingVendorProject> genotypingVendorProjects = new HashSet<GenotypingVendorProject>(
			0);
	private Set<DnaDestructionVendor> dnaDestructionVendors = new HashSet<DnaDestructionVendor>(
			0);
	private Set<RoiAttributeFld> roiAttributeFlds = new HashSet<RoiAttributeFld>(
			0);
	private Set<ShipmentAirbill> shipmentAirbills = new HashSet<ShipmentAirbill>(
			0);
	private Set<TestVariableFld> testVariableFlds = new HashSet<TestVariableFld>(
			0);
	private Set<SampleVariableFldTbl> sampleVariableFldTbls = new HashSet<SampleVariableFldTbl>(
			0);
	private Set<OrganizationVariableFld> organizationVariableFlds = new HashSet<OrganizationVariableFld>(
			0);

	public Organization() {
	}

	public Organization(BigDecimal organizationId, String company) {
		this.organizationId = organizationId;
		this.company = company;
	}

	public Organization(BigDecimal organizationId, String company,
			String organizationType, String address1, String address2,
			String city, String state, String zipCode, String country,
			String contact, String email, String phone, String fax,
			String comments, String createdBy, Date dateCreated,
			String modifiedBy, Date dateModified,
			Set<ShipmentSample> shipmentSamples,
			Set<CaseVariableFldTable> caseVariableFldTables,
			Set<AccessionVariableFldTable> accessionVariableFldTables,
			Set<TestAttributeFld> testAttributeFlds,
			Set<StudyVariableFld> studyVariableFlds, Set<Contact> contacts,
			Set<OutboundRequest> outboundRequests, Set<Instrument> instruments,
			Set<SpecimenShipmentAirbill> specimenShipmentAirbills,
			Set<SampleReception> sampleReceptions,
			Set<GenotypingVendorAssayMap> genotypingVendorAssayMaps,
			Set<Reagent> reagents, Set<ShipmentReceipt> shipmentReceipts,
			Set<PatientVariableFld> patientVariableFlds,
			Set<SpecimenShipment> specimenShipments,
			Set<GenotypingVendorProject> genotypingVendorProjects,
			Set<DnaDestructionVendor> dnaDestructionVendors,
			Set<RoiAttributeFld> roiAttributeFlds,
			Set<ShipmentAirbill> shipmentAirbills,
			Set<TestVariableFld> testVariableFlds,
			Set<SampleVariableFldTbl> sampleVariableFldTbls,
			Set<OrganizationVariableFld> organizationVariableFlds) {
		this.organizationId = organizationId;
		this.company = company;
		this.organizationType = organizationType;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.contact = contact;
		this.email = email;
		this.phone = phone;
		this.fax = fax;
		this.comments = comments;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.shipmentSamples = shipmentSamples;
		this.caseVariableFldTables = caseVariableFldTables;
		this.accessionVariableFldTables = accessionVariableFldTables;
		this.testAttributeFlds = testAttributeFlds;
		this.studyVariableFlds = studyVariableFlds;
		this.contacts = contacts;
		this.outboundRequests = outboundRequests;
		this.instruments = instruments;
		this.specimenShipmentAirbills = specimenShipmentAirbills;
		this.sampleReceptions = sampleReceptions;
		this.genotypingVendorAssayMaps = genotypingVendorAssayMaps;
		this.reagents = reagents;
		this.shipmentReceipts = shipmentReceipts;
		this.patientVariableFlds = patientVariableFlds;
		this.specimenShipments = specimenShipments;
		this.genotypingVendorProjects = genotypingVendorProjects;
		this.dnaDestructionVendors = dnaDestructionVendors;
		this.roiAttributeFlds = roiAttributeFlds;
		this.shipmentAirbills = shipmentAirbills;
		this.testVariableFlds = testVariableFlds;
		this.sampleVariableFldTbls = sampleVariableFldTbls;
		this.organizationVariableFlds = organizationVariableFlds;
	}

	public BigDecimal getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(BigDecimal organizationId) {
		this.organizationId = organizationId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getOrganizationType() {
		return this.organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public Set<ShipmentSample> getShipmentSamples() {
		return this.shipmentSamples;
	}

	public void setShipmentSamples(Set<ShipmentSample> shipmentSamples) {
		this.shipmentSamples = shipmentSamples;
	}

	public Set<CaseVariableFldTable> getCaseVariableFldTables() {
		return this.caseVariableFldTables;
	}

	public void setCaseVariableFldTables(
			Set<CaseVariableFldTable> caseVariableFldTables) {
		this.caseVariableFldTables = caseVariableFldTables;
	}

	public Set<AccessionVariableFldTable> getAccessionVariableFldTables() {
		return this.accessionVariableFldTables;
	}

	public void setAccessionVariableFldTables(
			Set<AccessionVariableFldTable> accessionVariableFldTables) {
		this.accessionVariableFldTables = accessionVariableFldTables;
	}

	public Set<TestAttributeFld> getTestAttributeFlds() {
		return this.testAttributeFlds;
	}

	public void setTestAttributeFlds(Set<TestAttributeFld> testAttributeFlds) {
		this.testAttributeFlds = testAttributeFlds;
	}

	public Set<StudyVariableFld> getStudyVariableFlds() {
		return this.studyVariableFlds;
	}

	public void setStudyVariableFlds(Set<StudyVariableFld> studyVariableFlds) {
		this.studyVariableFlds = studyVariableFlds;
	}

	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<OutboundRequest> getOutboundRequests() {
		return this.outboundRequests;
	}

	public void setOutboundRequests(Set<OutboundRequest> outboundRequests) {
		this.outboundRequests = outboundRequests;
	}

	public Set<Instrument> getInstruments() {
		return this.instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Set<SpecimenShipmentAirbill> getSpecimenShipmentAirbills() {
		return this.specimenShipmentAirbills;
	}

	public void setSpecimenShipmentAirbills(
			Set<SpecimenShipmentAirbill> specimenShipmentAirbills) {
		this.specimenShipmentAirbills = specimenShipmentAirbills;
	}

	public Set<SampleReception> getSampleReceptions() {
		return this.sampleReceptions;
	}

	public void setSampleReceptions(Set<SampleReception> sampleReceptions) {
		this.sampleReceptions = sampleReceptions;
	}

	public Set<GenotypingVendorAssayMap> getGenotypingVendorAssayMaps() {
		return this.genotypingVendorAssayMaps;
	}

	public void setGenotypingVendorAssayMaps(
			Set<GenotypingVendorAssayMap> genotypingVendorAssayMaps) {
		this.genotypingVendorAssayMaps = genotypingVendorAssayMaps;
	}

	public Set<Reagent> getReagents() {
		return this.reagents;
	}

	public void setReagents(Set<Reagent> reagents) {
		this.reagents = reagents;
	}

	public Set<ShipmentReceipt> getShipmentReceipts() {
		return this.shipmentReceipts;
	}

	public void setShipmentReceipts(Set<ShipmentReceipt> shipmentReceipts) {
		this.shipmentReceipts = shipmentReceipts;
	}

	public Set<PatientVariableFld> getPatientVariableFlds() {
		return this.patientVariableFlds;
	}

	public void setPatientVariableFlds(
			Set<PatientVariableFld> patientVariableFlds) {
		this.patientVariableFlds = patientVariableFlds;
	}

	public Set<SpecimenShipment> getSpecimenShipments() {
		return this.specimenShipments;
	}

	public void setSpecimenShipments(Set<SpecimenShipment> specimenShipments) {
		this.specimenShipments = specimenShipments;
	}

	public Set<GenotypingVendorProject> getGenotypingVendorProjects() {
		return this.genotypingVendorProjects;
	}

	public void setGenotypingVendorProjects(
			Set<GenotypingVendorProject> genotypingVendorProjects) {
		this.genotypingVendorProjects = genotypingVendorProjects;
	}

	public Set<DnaDestructionVendor> getDnaDestructionVendors() {
		return this.dnaDestructionVendors;
	}

	public void setDnaDestructionVendors(
			Set<DnaDestructionVendor> dnaDestructionVendors) {
		this.dnaDestructionVendors = dnaDestructionVendors;
	}

	public Set<RoiAttributeFld> getRoiAttributeFlds() {
		return this.roiAttributeFlds;
	}

	public void setRoiAttributeFlds(Set<RoiAttributeFld> roiAttributeFlds) {
		this.roiAttributeFlds = roiAttributeFlds;
	}

	public Set<ShipmentAirbill> getShipmentAirbills() {
		return this.shipmentAirbills;
	}

	public void setShipmentAirbills(Set<ShipmentAirbill> shipmentAirbills) {
		this.shipmentAirbills = shipmentAirbills;
	}

	public Set<TestVariableFld> getTestVariableFlds() {
		return this.testVariableFlds;
	}

	public void setTestVariableFlds(Set<TestVariableFld> testVariableFlds) {
		this.testVariableFlds = testVariableFlds;
	}

	public Set<SampleVariableFldTbl> getSampleVariableFldTbls() {
		return this.sampleVariableFldTbls;
	}

	public void setSampleVariableFldTbls(
			Set<SampleVariableFldTbl> sampleVariableFldTbls) {
		this.sampleVariableFldTbls = sampleVariableFldTbls;
	}

	public Set<OrganizationVariableFld> getOrganizationVariableFlds() {
		return this.organizationVariableFlds;
	}

	public void setOrganizationVariableFlds(
			Set<OrganizationVariableFld> organizationVariableFlds) {
		this.organizationVariableFlds = organizationVariableFlds;
	}

}