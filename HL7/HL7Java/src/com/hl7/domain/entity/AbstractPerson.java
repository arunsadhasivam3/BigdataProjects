package com.hl7.domain.entity;

public class AbstractPerson {

	/*
	 * <value name="PersonTypeId" field="personTypeId" /> <structure
	 * field="PersonName"/>
	 */

	private String personTypeId;
	private PersonName personName;

	/**
	 * @return the personTypeId
	 */
	public String getPersonTypeId() {
		return personTypeId;
	}

	/**
	 * @param personTypeId
	 *            the personTypeId to set
	 */
	public void setPersonTypeId(String personTypeId) {
		this.personTypeId = personTypeId;
	}

	/**
	 * @return the personName
	 */
	public PersonName getPersonName() {
		return personName;
	}

	/**
	 * @param personName
	 *            the personName to set
	 */
	public void setPersonName(PersonName personName) {
		this.personName = personName;
	}

}
