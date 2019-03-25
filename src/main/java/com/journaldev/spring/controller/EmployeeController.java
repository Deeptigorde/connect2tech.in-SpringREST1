package com.journaldev.spring.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.Employee2;
import com.c2t.annotation.basic.EmployeeList;
import com.journaldev.spring.Service.EmployeeService;


@Controller
public class EmployeeController {
    @Autowired
	SessionFactory sf;
    
    @Autowired
    EmployeeService service;
	
    Map<Integer,Employee> empData=new HashMap<Integer, Employee>();
	
	@RequestMapping(value="/rest/emp/dummy",method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee()
	{
		
//		Session s = sf.openSession();
//		Employee emp = (Employee)s.get(Employee.class, 1l);
//		
//		
//		System.out.println("----------------------------------");
//		System.out.println(emp);
//		
//		System.out.println(emp.getId());
		
//		return emp;
		Employee emp =service.getemp();
		return emp;
		
	}
	
	@RequestMapping(value="/rest/emp/dummy/list",method = RequestMethod.GET)
	public @ResponseBody EmployeeList getEmployee()
	{
//		Query q=sf.openSession().createQuery("From Employee");
//		List<Employee>list=q.list();
//		
//		EmployeeList emplist=new EmployeeList();
//		
//		
//		emplist.setList(list);
//		
//		
//		return emplist;
		return service.getallemp();
		
	}
	@RequestMapping(value="/rest/emp/{id}",method = RequestMethod.GET)
	public @ResponseBody Employee getemp(@PathVariable ("id") int empid)
	{
//		Session s = sf.openSession();
//		Employee emp = (Employee)s.get(Employee.class, new Long(empid));
//		
//		
//		System.out.println("----------------------------------");
//		System.out.println(emp);
//		
//		System.out.println(emp.getId());
//		
		return service.getbyid(empid);
		
		}
	@RequestMapping(value="/rest/emp/delete/{id}",method = RequestMethod.GET)
	public @ResponseBody String deletemp(@PathVariable ("id") int empid)
	{
//		Session s = sf.openSession();
//		
//		Employee emp = (Employee)s.get(Employee.class, new Long(empid));
//		s.delete(emp);
//		s.beginTransaction().commit();
//		return "deleted";
		service.delbyid(empid);
		return "deleted successfully";
	
}
	@RequestMapping(value="/rest/emp/dummy/insert",method = RequestMethod.GET)
	public @ResponseBody Employee insertEmployee()
	{
		Employee e=new Employee();
		e.setFirstname("hello");
		e.setLastname("dear..");
		e.setBirthDate(new Date(1982/3/4));
		e.setCellphone("12345");
		e.setId(2l);
		
		Employee2 e2=new Employee2();
		e2.setFirstname("hello2");
		e2.setLastname("dear..2");
		e2.setBirthDate(new Date(1982/3/4));
		e2.setCellphone("12345888");
		e2.setId(2l);
		
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(e);
		session.save(e2);
		session.getTransaction().commit();
		return e;
	}
	
	
}