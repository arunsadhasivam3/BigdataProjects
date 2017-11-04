package com.hl7.domain.entity;

import com.hl7.domain.entity.Person;

public class Provider {
// 	<structure field="ProviderAccount"/>
private ProviderAccount providerAccount;
public Person person;

/**
 * @return the providerAccount
 */
public ProviderAccount getProviderAccount() {
	return providerAccount;
}

/**
 * @param providerAccount the providerAccount to set
 */
public void setProviderAccount(ProviderAccount providerAccount) {
	this.providerAccount = providerAccount;
}
 
}
