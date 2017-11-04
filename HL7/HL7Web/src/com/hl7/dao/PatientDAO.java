package com.hl7.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.hl7.domain.Mainroot;

/**
 * Class Responsible for CRUD operations
 * @author Arunkumar sadhasivam
 *
 */
@Repository
public class PatientDAO extends AbstractDAO {
	
	@Autowired
	MongoTemplate mongoTemplate;
	public List<Mainroot> getPatientDetails(){
		
		List<Mainroot> patientList = mongoTemplate.findAll(Mainroot.class,"Hl7_patient_details");
		if(patientList==null){
			System.out.println("result is null");
		}
		return patientList;
	}
	
	public int insert(Mainroot root){
		
		//List<Loan> loan = mongoTemplate.findAll(Loan.class,"analytics.loan_prediction_train");
		int success =1;
		try{
		mongoTemplate.insert(root,"Hl7_patient_details");
		}catch(Exception e){
			success =0;
		}
		return success;
	}
	
	
	
}
