package com.hl7.domain;

import com.hl7.domain.diagnosis.Diagnosis;
import com.hl7.domain.entity.DemographicEntity;
import com.hl7.domain.insurance.IN;

public class Mainroot {

	private ClientInformation clientInformation;
	private MessageHeader messageHeader;
	private DemographicEntity demographicEntity;
	private IN in;
	private Diagnosis diagnosis;
	/**
	 * @return the clientInformation
	 */
	public ClientInformation getClientInformation() {
		return clientInformation;
	}
	/**
	 * @param clientInformation the clientInformation to set
	 */
	public void setClientInformation(ClientInformation clientInformation) {
		this.clientInformation = clientInformation;
	}
	/**
	 * @return the messageHeader
	 */
	public MessageHeader getMessageHeader() {
		return messageHeader;
	}
	/**
	 * @param messageHeader the messageHeader to set
	 */
	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}
	/**
	 * @return the demographicEntity
	 */
	public DemographicEntity getDemographicEntity() {
		return demographicEntity;
	}
	/**
	 * @param demographicEntity the demographicEntity to set
	 */
	public void setDemographicEntity(DemographicEntity demographicEntity) {
		this.demographicEntity = demographicEntity;
	}
	/**
	 * @return the in
	 */
	public IN getIn() {
		return in;
	}
	/**
	 * @param in the in to set
	 */
	public void setIn(IN in) {
		this.in = in;
	}
	/**
	 * @return the diagnosis
	 */
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}
	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}
}
