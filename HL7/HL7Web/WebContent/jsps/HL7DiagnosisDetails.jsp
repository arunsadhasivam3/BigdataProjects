
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
		<td>Diagnosis Id</td>
		<td>Diagnosis Code Method</td>
		<td>Diagnosis Code</td>
		<td>DiognosisDescription</td>
	</tr>
		<c:forEach items="${patientList}" var="patient">
			<tr>
				<td class="tdData">${patient.demographicEntity.patient.person.personTypeId}</td>
			    <td class="tdData">${patient.demographicEntity.patient.person.personName.firstName}
				${patient.demographicEntity.patient.person.personName.middleName}
				${patient.demographicEntity.patient.person.personName.lastName}</td>
				<td class="tdData">${patient.diagnosis.setId}</td>
				<td class="tdData">${patient.diagnosis.diognosisCodeMethod}</td>
				<td class="tdData">${patient.diagnosis.diognosisCode}</td>
				<td class="tdData">${patient.diagnosis.diognosisDescription}</td>
			</tr>
		</c:forEach>
</table>

