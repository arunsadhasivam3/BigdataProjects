package com.hl7.domain.insurance;

import com.hl7.domain.entity.Person;

public class Insurance {
	
	/*<SetId>1</SetId>
	<InsurancePolicyId>1</InsurancePolicyId>
	<InsuranceCompanyCode>Aetna</InsuranceCompanyCode>
	<InsuranceCompanyName>Aetna</InsuranceCompanyName>
	<InsuranceCompanyAddress />
	<PlanType>P</PlanType>
	<Person>
		<PersonTypeId>20</PersonTypeId>
		<PersonName>
			<LastName>Me</LastName>
			<FirstName>You</FirstName>
			<MiddleName>Y</MiddleName>
		</PersonName>
	</Person>
	<RelationshiptoPatient>Self</RelationshiptoPatient>
	<DateofBirth>19840630</DateofBirth>
	<PolicyNumber>12344</PolicyNumber>
	<Sex>M</Sex>*/

	
	private String setId;
	private String insurancePolicyId;
	private String insuranceCompanyCode;
	private String insuranceCompanyName;
	private String insuranceCompanyAddress;
	private String planType;
	private Person person;
	private String relationshiptoPatient;
	private String dateOfBirth;
	private String policyNumber;
	private String sex;
	/**
	 * @return the setId
	 */
	public String getSetId() {
		return setId;
	}
	/**
	 * @param setId the setId to set
	 */
	public void setSetId(String setId) {
		this.setId = setId;
	}
	/**
	 * @return the insurancePolicyId
	 */
	public String getInsurancePolicyId() {
		return insurancePolicyId;
	}
	/**
	 * @param insurancePolicyId the insurancePolicyId to set
	 */
	public void setInsurancePolicyId(String insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}
	/**
	 * @return the insuranceCompanyCode
	 */
	public String getInsuranceCompanyCode() {
		return insuranceCompanyCode;
	}
	/**
	 * @param insuranceCompanyCode the insuranceCompanyCode to set
	 */
	public void setInsuranceCompanyCode(String insuranceCompanyCode) {
		this.insuranceCompanyCode = insuranceCompanyCode;
	}
	/**
	 * @return the insuranceCompanyName
	 */
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	/**
	 * @param insuranceCompanyName the insuranceCompanyName to set
	 */
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	/**
	 * @return the insuranceCompanyAddress
	 */
	public String getInsuranceCompanyAddress() {
		return insuranceCompanyAddress;
	}
	/**
	 * @param insuranceCompanyAddress the insuranceCompanyAddress to set
	 */
	public void setInsuranceCompanyAddress(String insuranceCompanyAddress) {
		this.insuranceCompanyAddress = insuranceCompanyAddress;
	}
	/**
	 * @return the planType
	 */
	public String getPlanType() {
		return planType;
	}
	/**
	 * @param planType the planType to set
	 */
	public void setPlanType(String planType) {
		this.planType = planType;
	}
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
	 * @return the relationshiptoPatient
	 */
	public String getRelationshiptoPatient() {
		return relationshiptoPatient;
	}
	/**
	 * @param relationshiptoPatient the relationshiptoPatient to set
	 */
	public void setRelationshiptoPatient(String relationshiptoPatient) {
		this.relationshiptoPatient = relationshiptoPatient;
	}
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
	 * @return the policyNumber
	 */
	public String getPolicyNumber() {
		return policyNumber;
	}
	/**
	 * @param policyNumber the policyNumber to set
	 */
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
}
