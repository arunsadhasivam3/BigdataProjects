 <form method="POST"  name="frmUpload" id="frmUpload" 
   action="<%=request.getContextPath() %>/hl7UploadServlet" enctype="multipart/form-data"  >
  
	<table style="width: 100%;">
		<tr>
			<td colspan="2" align="center"><span>Input:</span> 
				<input	type="text" id="path"> <input type="file" id="file" name="file" value="">
			</td>
		</tr>

		<tr>
			<td colspan="3" align="center"><input type="submit" id="btnUpload" value="Upload"></td>
				 
		</tr>
		<%!String status = null;%>
						<%status = request.getParameter("status"); %>
		<%if(status!=null && !status.equals("")){ %>				
		<tr>
			<td valign="top" align="center">
				<table>
				
					<tr>
						<td align="center"><img src="/HL7Web/images/info.png" style="width: 30px;"></img> <span
							style="border: solid 1px thin; vertical-align: top;"></span>
						</td>
						<td><%=request.getParameter("status")%></td>
					</tr>
				</table>
			</td>
		</tr> 
		<%} %>
	</table>
	
	<input type="hidden" value="0" id="upload" name="upload"/>
</form>
