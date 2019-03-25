package com.journaldev.spring.DAO;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeList;


public interface EmployeeDAO {

	public Employee getEmp();
	public EmployeeList getEmployeeList();
	public Employee getbyID(int id);
	public String deletbyid(int id);
}
