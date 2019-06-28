package org.com.controller;

import java.util.List;

import org.com.entity.Employee;
import org.com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(headers="Accept=application/json")
	public List<Employee> getAllEmployee(Model model)
	{
		List<Employee> allEmployee=employeeService.getAllEmployee();
		model.addAttribute("employee", new Employee());
		model.addAttribute("allEmp",allEmployee);
		return allEmployee;
		
	}
	
	@GetMapping(value="/{eid}",headers="Accept=application/json")
	public List<Employee> getEmp(@PathVariable("eid") String eid)
	{
		List<Employee> emp=employeeService.SearchByID(eid);
		return emp;
}
	
	@PutMapping(headers="Accept=application/json")
	public void UpdateEmp(@RequestBody Employee emp)
	{
		employeeService.UpdateEmp(emp);
		
	}
	
	
	@PostMapping(headers="Accept=application/json")
	public void InsertEmp(@RequestBody Employee emp)
	{
		employeeService.InsertEmp(emp);
	}
	
	@DeleteMapping(value="/{nbr}",headers="Accept=application/json")
	public void DelEmp(@PathVariable("nbr") int nbr)
	{
		employeeService.DelEmp(nbr);
	}
}
