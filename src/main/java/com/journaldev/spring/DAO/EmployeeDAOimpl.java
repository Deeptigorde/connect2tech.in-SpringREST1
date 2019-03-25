package com.journaldev.spring.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeList;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
	@Autowired
	SessionFactory sf;
	
	@Override
	public Employee getEmp() {
		Session s = sf.openSession();
		Employee emp = (Employee)s.get(Employee.class, 3l);
		return emp;
	}

	
	@Override
	public  EmployeeList getEmployeeList() {
		Query q=sf.openSession().createQuery("From Employee");
		List<Employee>list=q.list();
		
		EmployeeList emplist=new EmployeeList();
		
		
		emplist.setList(list);
		
		return emplist;
	}


	@Override
	public Employee getbyID(int id) {
		Session s = sf.openSession();
		Employee emp = (Employee)s.get(Employee.class, new Long(id));
		return emp;
		
	}


	@Override
	public String deletbyid(int id) {
		Session s = sf.openSession();
		
		Employee emp = (Employee)s.get(Employee.class, new Long(id));
		s.delete(emp);
		s.beginTransaction().commit();
		return "deleted";
	}
	

}
