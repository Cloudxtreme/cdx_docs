package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TestingFacility generated by hbm2java
 */
public class TestingFacility implements java.io.Serializable {

	private BigDecimal testingFacilityId;
	private Subsidiary subsidiary;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String phone;
	private String fax;
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private Set<Freezer> freezers = new HashSet<Freezer>(0);
	private Set<Instrument> instruments = new HashSet<Instrument>(0);

	public TestingFacility() {
	}

	public TestingFacility(BigDecimal testingFacilityId) {
		this.testingFacilityId = testingFacilityId;
	}

	public TestingFacility(BigDecimal testingFacilityId, Subsidiary subsidiary,
			String name, String address1, String address2, String city,
			String state, String zipCode, String country, String phone,
			String fax, String createdBy, Date dateCreated, String modifiedBy,
			Date dateModified, Set<Freezer> freezers,
			Set<Instrument> instruments) {
		this.testingFacilityId = testingFacilityId;
		this.subsidiary = subsidiary;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.freezers = freezers;
		this.instruments = instruments;
	}

	public BigDecimal getTestingFacilityId() {
		return this.testingFacilityId;
	}

	public void setTestingFacilityId(BigDecimal testingFacilityId) {
		this.testingFacilityId = testingFacilityId;
	}

	public Subsidiary getSubsidiary() {
		return this.subsidiary;
	}

	public void setSubsidiary(Subsidiary subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<Freezer> getFreezers() {
		return this.freezers;
	}

	public void setFreezers(Set<Freezer> freezers) {
		this.freezers = freezers;
	}

	public Set<Instrument> getInstruments() {
		return this.instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

}