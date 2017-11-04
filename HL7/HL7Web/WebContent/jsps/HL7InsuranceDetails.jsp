
<%request.getAttribute("root"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.hl7.domain.Mainroot"%>
<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />     

<table style="width: 100%;" class="hl7table" border="1">
	<tr class="trHeader">
		<td>PersonTypeId</td>
		<td>Person Name</td>
		<td>Insurance Id</td>
		<td>InsurancePolicyId</td>
		<td>InsuranceCompanyCode</td>
		<td>InsuranceCompanyName</td>
		<td>InsuranceCompanyAddress</td>
		<td>Plan Type</td>
		<td>Person</td>
		<td>RelationshiptoPatient</td>
		<td>DateOfBirth</td>
		<td>policyNumber</td>
		<td>Sex</td>
	</tr>
		<c:forEach items="${patientList}" var="patient">
			<tr>
			<td class="tdData">${patient.demographicEntity.patient.person.personTypeId}</td>
			<td class="tdData">${patient.demographicEntity.patient.person.personName.firstName}
				${patient.demographicEntity.patient.person.personName.middleName}
				${patient.demographicEntity.patient.person.personName.lastName}</td>
			<td class="tdData">${patient.in.insurance.setId}</td>
			<td class="tdData">${patient.in.insurance.insurancePolicyId}</td>
			<td class="tdData">${patient.in.insurance.insuranceCompanyCode}</td>
			<td class="tdData">${patient.in.insurance.insuranceCompanyName}</td>
			<td class="tdData">${patient.in.insurance.insuranceCompanyAddress}</td>
			<td class="tdData">${patient.in.insurance.planType}</td>
			<td class="tdData">${patient.in.insurance.person.personTypeId}</td>
 			<td class="tdData">${patient.in.insurance.relationshiptoPatient}</td>
 			<td class="tdData">${patient.in.insurance.dateOfBirth}</td>
			<td class="tdData">${patient.in.insurance.policyNumber}</td>
			<td class="tdData">${patient.in.insurance.sex}</td> 
			</tr>
		</c:forEach>
</table>

