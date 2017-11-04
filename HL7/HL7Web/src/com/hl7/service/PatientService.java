package com.hl7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl7.dao.PatientDAO;
import com.hl7.domain.Mainroot;

@Service
public class PatientService {

	@Autowired
	PatientDAO patientDAO;
	
	public int insert(Mainroot root){
		return patientDAO.insert(root);
	}
	
	public List<Mainroot> getPatientDetails(){
		return patientDAO.getPatientDetails();
	}
}
