package com.hl7.domain.entity;

public class PersonPhoneNumber {
//	<value name="NumberTypeId" field="numberTypeId" />
//	<value name="Number" field="number" />

private String numberTypeId;
private String number;
/**
 * @return the numberTypeId
 */
public String getNumberTypeId() {
	return numberTypeId;
}
/**
 * @param numberTypeId the numberTypeId to set
 */
public void setNumberTypeId(String numberTypeId) {
	this.numberTypeId = numberTypeId;
}
/**
 * @return the number
 */
public String getNumber() {
	return number;
}
/**
 * @param number the number to set
 */
public void setNumber(String number) {
	this.number = number;
}
}
