package com.journaldev.spring.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeList;
import com.journaldev.spring.DAO.EmployeeDAO;
import com.journaldev.spring.DAO.EmployeeDAOimpl;

public interface EmployeeService{

	public Employee getemp();
	public EmployeeList getallemp();
	public Employee getbyid(int id);
	public String delbyid(int id);

}
