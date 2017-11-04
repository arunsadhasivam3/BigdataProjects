
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
		<td>DOB</td>
		<td>Gender</td>
		<td>Addresss</td>
		<td>PhoneNumber</td>
		<td>Acc. No</td>
		<td>Acc. RecId</td>
		<td>Pref. commn</td>
		<td>Pref. Language</td>
		<td>Marital Status</td>
		<td>EthnicityCode</td>
		<td>PatientClass</td>
	</tr>
		<c:forEach items="${patientList}" var="patient">
			<tr>
			<td class="tdData">${patient.demographicEntity.patient.person.personTypeId}</td>
			<td class="tdData">${patient.demographicEntity.patient.person.personName.firstName}
				${patient.demographicEntity.patient.person.personName.middleName}
				${patient.demographicEntity.patient.person.personName.lastName}</td>
				
			<td class="tdData">${patient.demographicEntity.patient.person.dateOfBirth}</td>
			<td class="tdData">${patient.demographicEntity.patient.person.gender}</td>
			<td class="tdData">${patient.demographicEntity.patient.person.personAddress.streetAddress1}<br>${patient.demographicEntity.patient.person.personAddress.city}
			
			<td>${patient.demographicEntity.patient.person.personPhoneNumber.number}</td>
			<td class="tdData">${patient.demographicEntity.patient.account.accountNumber}</td>
			<td class="tdData">${patient.demographicEntity.patient.accountReceivableTypeId}</td>
			<td class="tdData">${patient.demographicEntity.patient.preferredCommunication}</td>
			<td class="tdData">${patient.demographicEntity.patient.preferredLanguage}</td>
			<td class="tdData">${patient.demographicEntity.patient.maritalStatus}</td>
			<td class="tdData">${patient.demographicEntity.patient.ethnicityCode}</td>
			<td class="tdData">${patient.demographicEntity.patient.patientClass}</td>
				
			</tr>
		</c:forEach>
</table>

