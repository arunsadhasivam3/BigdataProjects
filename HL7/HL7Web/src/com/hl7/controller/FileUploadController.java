package com.hl7.controller;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hl7.domain.Mainroot;
import com.hl7.domain.entity.PersonName;
import com.hl7.service.PatientService;
import com.hl7.util.HL7ParserUtils;

@Controller
@MultipartConfig
public class FileUploadController {

	  private static final HL7ParserUtils parserutils = HL7ParserUtils.getInstance(); 
	  
	 @Autowired
	 PatientService patientService;
	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/hl7UploadServlet.htm", method = RequestMethod.POST)
	public @ResponseBody  ModelAndView uploadMultipleFileHandler(@RequestParam("file") MultipartFile file) {
		String patient = "";
		String message= "";
		ModelAndView view = new ModelAndView();
		//view.setViewName("/savePatientDetails");
		view.setViewName("/jsps/HL7Upload.jsp");
		
		Mainroot root = null;
		// Create path components to save the file
		if(file==null){
			return view;
		}
		int loadstatus=1;		
		try {
			try {
				 root = parserutils.unMarshall(file.getInputStream());
				 PersonName name = root.getDemographicEntity().getPatient().getPerson().getPersonName();
				 patient = name.getFirstName() + name.getMiddleName() + name.getLastName();
				 view.addObject("root", root);
			} catch (Exception e) {
				message = patient+ "<font color='red'>Hl7 Patient - " + patient +" uploading Failed</font>";
				loadstatus = 0;
			}
		} catch (Exception e) {
			message ="<font color='green'>Hl7  File Parsing Failed...</font>";
		}
		int resut = patientService.insert(root);
		if(resut == 0){
			message ="<font color='red'>Hl7 Patient uploading in DB Failed...</font>";
		}

		 

		message ="<font color='green'>Hl7 Patient -" + patient +" uploaded in DB Sucessfully...</font>";
		view.addObject("message", message);
		view.addObject("loadstatus", loadstatus);
		//RequestDispatcher rd = request.getRequestDispatcher("/savePatientDetails");
		
		return view;
	}
	
}
