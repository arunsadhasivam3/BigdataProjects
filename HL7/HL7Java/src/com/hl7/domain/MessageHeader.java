package com.hl7.domain;

public class MessageHeader {

//	<value name="ClientId" field="clientId" />
//	<value name="SendingApplication" field="sendingApplication" />
//	<value name="SendingFacility" field="sendingFacility" />
//	<value name="ReceivingApplication" field="receivingApplication" />
//	<value name="ReceivingFacility" field="receivingFacility" />
//	<structure field="MessageType"/>
//	<value name="MessageControlId" field="messageControlId" />
//	<value name="ProcessingId" field="processingId" />
//	<value name="VersionId" field="versionId" />
//	<value name="DateTimeofMessage" field="dateTimeofMessage" />
//	<value name="PmsAccountType" field="pmsAccountType" />
//	<value name="InterfaceType" field="interfaceType" />
//	<value name="Direction" field="direction" />
	
private String clientId;
private String sendingApplication;
private String sendingFacility;
private String receivingApplication;
private String receivingFacility;
private MessageType  messageType;
private String messageControlId;
private String processingId;
private String versionId;
private String dateTimeofMessage;
private String pmsAccountType;
private String interfaceType;
private String direction;
/**
 * @return the clientId
 */
public String getClientId() {
	return clientId;
}
/**
 * @param clientId the clientId to set
 */
public void setClientId(String clientId) {
	this.clientId = clientId;
}
/**
 * @return the sendingApplication
 */
public String getSendingApplication() {
	return sendingApplication;
}
/**
 * @param sendingApplication the sendingApplication to set
 */
public void setSendingApplication(String sendingApplication) {
	this.sendingApplication = sendingApplication;
}
/**
 * @return the sendingFacility
 */
public String getSendingFacility() {
	return sendingFacility;
}
/**
 * @param sendingFacility the sendingFacility to set
 */
public void setSendingFacility(String sendingFacility) {
	this.sendingFacility = sendingFacility;
}
/**
 * @return the receivingApplication
 */
public String getReceivingApplication() {
	return receivingApplication;
}
/**
 * @param receivingApplication the receivingApplication to set
 */
public void setReceivingApplication(String receivingApplication) {
	this.receivingApplication = receivingApplication;
}
/**
 * @return the receivingFacility
 */
public String getReceivingFacility() {
	return receivingFacility;
}
/**
 * @param receivingFacility the receivingFacility to set
 */
public void setReceivingFacility(String receivingFacility) {
	this.receivingFacility = receivingFacility;
}
/**
 * @return the messageType
 */
public MessageType getMessageType() {
	return messageType;
}
/**
 * @param messageType the messageType to set
 */
public void setMessageType(MessageType messageType) {
	this.messageType = messageType;
}
/**
 * @return the messageControlId
 */
public String getMessageControlId() {
	return messageControlId;
}
/**
 * @param messageControlId the messageControlId to set
 */
public void setMessageControlId(String messageControlId) {
	this.messageControlId = messageControlId;
}
/**
 * @return the processingId
 */
public String getProcessingId() {
	return processingId;
}
/**
 * @param processingId the processingId to set
 */
public void setProcessingId(String processingId) {
	this.processingId = processingId;
}
/**
 * @return the versionId
 */
public String getVersionId() {
	return versionId;
}
/**
 * @param versionId the versionId to set
 */
public void setVersionId(String versionId) {
	this.versionId = versionId;
}
/**
 * @return the dateTimeofMessage
 */
public String getDateTimeofMessage() {
	return dateTimeofMessage;
}
/**
 * @param dateTimeofMessage the dateTimeofMessage to set
 */
public void setDateTimeofMessage(String dateTimeofMessage) {
	this.dateTimeofMessage = dateTimeofMessage;
}
/**
 * @return the pmsAccountType
 */
public String getPmsAccountType() {
	return pmsAccountType;
}
/**
 * @param pmsAccountType the pmsAccountType to set
 */
public void setPmsAccountType(String pmsAccountType) {
	this.pmsAccountType = pmsAccountType;
}
/**
 * @return the interfaceType
 */
public String getInterfaceType() {
	return interfaceType;
}
/**
 * @param interfaceType the interfaceType to set
 */
public void setInterfaceType(String interfaceType) {
	this.interfaceType = interfaceType;
}
/**
 * @return the direction
 */
public String getDirection() {
	return direction;
}
/**
 * @param direction the direction to set
 */
public void setDirection(String direction) {
	this.direction = direction;
}

	
}
