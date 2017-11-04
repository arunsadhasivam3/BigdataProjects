package com.hl7.domain.entity;


public class Patient {

	private Person person;

	private Account account;
	private String accountReceivableTypeId;
	private String preferredCommunication;
	private String preferredLanguage;
	private String maritalStatus;
	private String ethnicityCode;
	private String patientClass;
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	/**
	 * @return the accountReceivableTypeId
	 */
	public String getAccountReceivableTypeId() {
		return accountReceivableTypeId;
	}
	/**
	 * @param accountReceivableTypeId the accountReceivableTypeId to set
	 */
	public void setAccountReceivableTypeId(String accountReceivableTypeId) {
		this.accountReceivableTypeId = accountReceivableTypeId;
	}
	/**
	 * @return the preferredCommunication
	 */
	public String getPreferredCommunication() {
		return preferredCommunication;
	}
	/**
	 * @param preferredCommunication the preferredCommunication to set
	 */
	public void setPreferredCommunication(String preferredCommunication) {
		this.preferredCommunication = preferredCommunication;
	}
	/**
	 * @return the maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	/**
	 * @return the ethnicityCode
	 */
	public String getEthnicityCode() {
		return ethnicityCode;
	}
	/**
	 * @param ethnicityCode the ethnicityCode to set
	 */
	public void setEthnicityCode(String ethnicityCode) {
		this.ethnicityCode = ethnicityCode;
	}
	/**
	 * @return the patientClass
	 */
	public String getPatientClass() {
		return patientClass;
	}
	/**
	 * @param patientClass the patientClass to set
	 */
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}
	/**
	 * @return the preferredLanguage
	 */
	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	/**
	 * @param preferredLanguage the preferredLanguage to set
	 */
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	
}
