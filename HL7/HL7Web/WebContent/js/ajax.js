 
 
 var xmlhttp =null;
 
 function getxmlRequest(){
	   try{
		   xmlhttp = new XMLHttpRequest();
	   }catch (e){
	      try{
	    	  xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	      }catch (e) {
	         
	         try{
	        	 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	         }catch (e){
	         
	            // Something went wrong
	            alert("Your browser broke!");
	            return false;
	         }
	      }
	   }
	   
	   return xmlhttp;
 }  
 
 
 function renderResponse(url){
	 xmlhttp = getxmlRequest();
	 xmlhttp.onreadystatechange = statechanged;
	 xmlhttp.open('GET', url);
	 xmlhttp.send(null);
	 
 }
 
 
 

 
 function statechanged() { 
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		document.getElementById("content").innerHTML = xmlhttp.responseText;
	}
}
  
 function render(val){
	 var context = document.getElementById('context').value;
	 var url =''; 
     if(val ==1 ){
    	 url = context+'/jsps/HL7upload.jsp';
    	 renderResponse(url);
     }else if (val==2){
    	 url =context +'/getPatientDetails.htm';	 
    	 renderResponse(url);
     }else if (val==3){
    	 url =context +'/getPatientInsuranceDetails.htm';	 
    	 renderResponse(url);
     }else if (val==4){
    	 url =context +'/getPatientDiagnosisDetails.htm';	 
    	 renderResponse(url);
     }else if(val==5){ 
    	 url =context +'/getClientInfo.htm';	 
    	 renderResponse(url);
     }else if(val==6){ 
    	 url =context +'/jsps/HL7upload.jsp';
    	 var param= document.getElementById('status').value;
    	 var message= document.getElementById('message').value;
    	 param=param+'&load='+ document.getElementById('load').value;;
    	 renderResponse(url+'?status='+param +'&message='+message);
    	 //renderResponse(context+'/savePatient');
    	  
     }else {
    	 url =context +'/jsps/error.jsp';	 
    	 renderResponse(url);
     }
	 
 } 
 