package com.hl7.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hl7.domain.Mainroot;
import com.hl7.service.PatientService;

/**
 * To get the Patient details.
 * @author arunkumar sadhasivam
 *
 */
@Controller
public class PatientController {
	
	
	@Autowired
	PatientService patientService;
	public PatientController(){
		System.out.println("PatientController.PatientController()");
	}
	 

	/**
	 * To save patient Details.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/savePatientDetails")
	public ModelAndView savePatient(Model model,HttpServletRequest req) {
		System.out.println("TestController.showPatient()111111111");
		Mainroot root= (Mainroot)req.getAttribute("root");
		int resut = patientService.insert(root);
		String message ="Uploaded Sucessfully...";
		
		if(resut == 0){
			message ="HL7 insertion Failed...";
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", message);
		mv.setViewName("/main.jsp");
		
		return mv;
	}
	
	/**
	 * To get the Patient details.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/getPatientDetails")
	public ModelAndView getPatient(Model model,HttpServletRequest req) {
		List<Mainroot> patientList = patientService.getPatientDetails();

		ModelAndView mv = new ModelAndView();
		mv.addObject("status", 1);
		mv.addObject("patientList", patientList);
		mv.setViewName("/jsps/HL7PatientDetails.jsp");
		
		return mv;
	}

	
	/**
	 * To get the Patient Insurance details.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/getPatientInsuranceDetails")
	public ModelAndView getInsuranceDetails(Model model,HttpServletRequest req) {
		List<Mainroot> patientList = patientService.getPatientDetails();

		ModelAndView mv = new ModelAndView();
		mv.addObject("status", 1);
		mv.addObject("patientList", patientList);
		mv.setViewName("/jsps/HL7InsuranceDetails.jsp");
		
		return mv;
	}
	
	
	/**
	 * To get the Patient Diagnosis details.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/getPatientDiagnosisDetails")
	public ModelAndView getDiagnosisDetails(Model model,HttpServletRequest req) {
		List<Mainroot> patientList = patientService.getPatientDetails();

		ModelAndView mv = new ModelAndView();
		mv.addObject("status", 1);
		mv.addObject("patientList", patientList);
		mv.setViewName("/jsps/HL7DiagnosisDetails.jsp");
		
		return mv;
	}
	
	
	/**
	 * To get the Patient Internal (DB saved file ) details.
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/getClientInfo")
	public ModelAndView getClientInfo(Model model,HttpServletRequest req) {
		List<Mainroot> patientList = patientService.getPatientDetails();

		ModelAndView mv = new ModelAndView();
		mv.addObject("status", 1);
		mv.addObject("patientList", patientList);
		mv.setViewName("/jsps/PatientClientInfo.jsp");
		
		return mv;
	}
	
}
