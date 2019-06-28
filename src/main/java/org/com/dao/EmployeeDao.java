package org.com.dao;

import java.util.List;

import org.com.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployee();
	public void InsertEmp(Employee emp);
	public List<Employee> getEmp(String eid);
	public void UpdateEmp(Employee emp);
	public void DelEmp(int nbr);

}
