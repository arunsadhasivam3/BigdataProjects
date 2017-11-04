package com.hl7.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.hl7.config.Employee;

/**
 * 
 * Class Responsible for Abstracting dao operations
 * 
 * @version 1.0
 *
 */

public class AbstractDAO implements InitializingBean, DisposableBean {

	public MongoTemplate mongoTemplate;
	public Employee employee;
	public AbstractDAO() {
		super();
	}



	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate
	 *            the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//Assert.notNull(this.jdbcTemplate, "JDBC must be provided");
		
	
	}

	public void destroy() throws Exception {
		//Assert.notNull(this.mongoTemplate, "DataSource must be provided");
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
