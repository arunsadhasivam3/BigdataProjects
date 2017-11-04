package com.hl7.domain.diagnosis;

public class Diagnosis {

/*<Diagnosis>
	<SetID>1</SetID>
	<DiognosisCodeMethod>ICD</DiognosisCodeMethod>
	<DiognosisCode>786.50</DiognosisCode>
	<DiognosisDescription>Unspecified Chest Pain</DiognosisDescription>
</Diagnosis>	
*/	
	
	private String setId;
	private String diognosisCodeMethod;
	private String diognosisCode;
	private String diognosisDescription;
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
	 * @return the diognosisCodeMethod
	 */
	public String getDiognosisCodeMethod() {
		return diognosisCodeMethod;
	}
	/**
	 * @param diognosisCodeMethod the diognosisCodeMethod to set
	 */
	public void setDiognosisCodeMethod(String diognosisCodeMethod) {
		this.diognosisCodeMethod = diognosisCodeMethod;
	}
	/**
	 * @return the diognosisCode
	 */
	public String getDiognosisCode() {
		return diognosisCode;
	}
	/**
	 * @param diognosisCode the diognosisCode to set
	 */
	public void setDiognosisCode(String diognosisCode) {
		this.diognosisCode = diognosisCode;
	}
	/**
	 * @return the diognosisDescription
	 */
	public String getDiognosisDescription() {
		return diognosisDescription;
	}
	/**
	 * @param diognosisDescription the diognosisDescription to set
	 */
	public void setDiognosisDescription(String diognosisDescription) {
		this.diognosisDescription = diognosisDescription;
	}
}
