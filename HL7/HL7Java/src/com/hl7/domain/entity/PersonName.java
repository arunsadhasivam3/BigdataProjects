package com.hl7.domain.entity;

import com.hl7.domain.entity.types.Name;

public class PersonName extends Name {

//	<value name="MiddleName" field="middleName" />

private String middleName;

/**
 * @return the middleName
 */
public String getMiddleName() {
	return middleName;
}

/**
 * @param middleName the middleName to set
 */
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
}
