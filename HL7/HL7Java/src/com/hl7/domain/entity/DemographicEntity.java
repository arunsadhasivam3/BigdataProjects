package com.hl7.domain.entity;

public class DemographicEntity {
private Patient patient;
private Provider provider;

/**
 * @return the patient
 */
public Patient getPatient() {
	return patient;
}

/**
 * @param patient the patient to set
 */
public void setPatient(Patient patient) {
	this.patient = patient;
}

/**
 * @return the provider
 */
public Provider getProvider() {
	return provider;
}

/**
 * @param provider the provider to set
 */
public void setProvider(Provider provider) {
	this.provider = provider;
}
}
