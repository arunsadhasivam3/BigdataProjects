package com.hl7.domain;

public class MessageType {

//	  <value name="Message" field="message" />
//      <value name="SubMessage" field="subMessage" />
	
	
	private String message;
	private String subMessage;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the subMessage
	 */
	public String getSubMessage() {
		return subMessage;
	}
	/**
	 * @param subMessage the subMessage to set
	 */
	public void setSubMessage(String subMessage) {
		this.subMessage = subMessage;
	}
}
