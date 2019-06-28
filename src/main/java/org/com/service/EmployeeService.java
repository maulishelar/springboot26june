package org.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.com.dao.EmployeeDao;
import org.com.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EmployeeService")
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	@Transactional
	public List<Employee> getAllEmployee() {
		List<Employee> allEmp=dao.getAllEmployee();
		return allEmp;
		
	}
	
	@Transactional
	public void InsertEmp(Employee emp)
	{
		dao.InsertEmp(emp);
	}
	
	@Transactional
	public void DelEmp(int nbr)
	{
		dao.DelEmp(nbr);
	}
	
	@Transactional
	public void UpdateEmp(Employee emp)
	{
		dao.UpdateEmp(emp);
	}
	
	@Transactional
	public List<Employee> SearchByID(String eid)
	{
		return dao.getEmp(eid);
		
	}

}
