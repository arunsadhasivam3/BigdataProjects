package com.hl7.domain;

public class ClientInformation {
	// <value name="Title" field="title"/>
	// <value name="Vendor" field="vendor"/>
	// <value name="Description" field="description"/>
	// <value name="DatabaseName" field="databaseName"/>
	// <value name="DatabaseId" field="databaseId"/>
	public String title;
	public String vendor;
	public String description;
	public String databaseName;
	public String databaseId;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @param vendor
	 *            the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @param databaseName
	 *            the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	/**
	 * @return the databaseId
	 */
	public String getDatabaseId() {
		return databaseId;
	}

	/**
	 * @param databaseId
	 *            the databaseId to set
	 */
	public void setDatabaseId(String databaseId) {
		this.databaseId = databaseId;
	}

}
