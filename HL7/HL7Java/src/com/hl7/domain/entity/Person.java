package com.hl7.domain.entity;

public class Person extends AbstractPerson{
	/*
	<value name="DateOfBirth" field="dateOfBirth" />
	<value name="Gender" field="gender" />
	<value name="PersonAddress" field="personAddress" />
	<value name="PersonPhoneNumber" field="personPhoneNumber" />*/
	
	private String dateOfBirth;
	private String gender;
	private PersonAddress personAddress;
	private PersonPhoneNumber personPhoneNumber;
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the personAddress
	 */
	public PersonAddress getPersonAddress() {
		return personAddress;
	}
	/**
	 * @param personAddress the personAddress to set
	 */
	public void setPersonAddress(PersonAddress personAddress) {
		this.personAddress = personAddress;
	}
	/**
	 * @return the personPhoneNumber
	 */
	public PersonPhoneNumber getPersonPhoneNumber() {
		return personPhoneNumber;
	}
	/**
	 * @param personPhoneNumber the personPhoneNumber to set
	 */
	public void setPersonPhoneNumber(PersonPhoneNumber personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
	}
}
