
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
		<td class="tdData">Title</td>
		<td class="tdData">Vendor</td>
		<td class="tdData">Description</td>
		<td class="tdData">DatabaseName</td>
		<td class="tdData">DatabaseId</td>
	</tr>
		<c:forEach items="${patientList}" var="patient">
			<tr>
				<td class="tdData">${patient.demographicEntity.patient.person.personTypeId}</td>
				<td class="tdData">${patient.demographicEntity.patient.person.personName.firstName}
				${patient.demographicEntity.patient.person.personName.middleName}
				${patient.demographicEntity.patient.person.personName.lastName}</td>
				<td class="tdData">${patient.clientInformation.title}</td>
				<td class="tdData">${patient.clientInformation.vendor}</td>
				<td class="tdData">${patient.clientInformation.description}</td>
				<td class="tdData">${patient.clientInformation.databaseName}</td>
				<td class="tdData">${patient.clientInformation.databaseId}</td>
			</tr>
		</c:forEach>
</table>

