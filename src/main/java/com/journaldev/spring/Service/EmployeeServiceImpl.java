package com.journaldev.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeList;
import com.journaldev.spring.DAO.EmployeeDAO;
import com.journaldev.spring.DAO.EmployeeDAOimpl;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	EmployeeDAO dao;

	public Employee getemp()
	{
		Employee e=dao.getEmp();
		return e;
		
	}
	
	public EmployeeList getallemp()
	{
		EmployeeList e1=dao.getEmployeeList();
		return e1;
	
		
	}

	@Override
	public Employee getbyid(int id) {
		Employee e=dao.getbyID(id);
		return e;
	}

	@Override
	public String delbyid(int id) {
		dao.deletbyid(id);
		return "deleted";
	}

}
