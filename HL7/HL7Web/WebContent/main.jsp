<%@page import="com.hl7.domain.Mainroot"%>
 
 

<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />       
</head> 

<%!Mainroot root =  null;
 %>
 <% root =(Mainroot)request.getAttribute("root");
 %>  

<%
root =(Mainroot)request.getAttribute("root"); 
request.setAttribute("root", root);
if(root!=null)
%>
 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script> 
function onload(){
	var status = document.getElementById('load').value;
	if(status!=null && typeof(status)!='undefined' && status == 1){
		render('6');
	}else{
	  render('1');
	}
	
}
 
</script> 



<body  onload="onload()">
<!-- if this form is there when submit multipart form also this main form gets submitted and go to upload page again it wont go to servlet
   <form name='frmMain'  id='frmMain' method="POST">-->   
<table  class="mainHeader" >             
		<tr> 
			<td colspan="2" valign="top"><jsp:include
					page="/layouts/header.jsp"></jsp:include></td> 
		</tr>
		<tr>
			<td valign="top">
				<table class="mainHeader">
					<tr>
						<td width="20%" id="leftPanel" valign="top" class="leftpanel">
							<jsp:include page="/jsps/leftpanel.jsp"></jsp:include>
						</td>
						<td width="80%" id="content" valign="top"></td>

					</tr>

				</table>
			</td>

		</tr>

		<tr>
			<td valign="top"> 
				<input type="hidden" value="<%=request.getContextPath() %>" id="context" />
				<input type="hidden" value="${status}" id="status" />
				<input type="hidden" value="${message}" id="message" />
				<input type="hidden" id='load' value="<%=request.getAttribute("load")%>"/>
			</td>
		</tr>
		
</table>
</form>
</body>

<html>