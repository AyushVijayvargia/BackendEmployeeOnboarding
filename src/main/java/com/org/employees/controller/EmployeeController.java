package com.org.employees.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.employees.entity.EmployeeDetails;
import com.org.employees.model.Employee;
import com.org.employees.repository.*;
import com.org.employees.model.FilterId;

@RestController
public class EmployeeController {

	@Autowired
	EmployeesRepository repo;
	
	@GetMapping(path= "/employee/{employeeid}")
	@ResponseStatus(code=HttpStatus.OK)
	public Object fetchEmployeeDetails(@PathVariable("employeeid") @NotNull String employeeid) {
		Optional<EmployeeDetails> employee ;
			
		employee= repo.findByEmployeeID(Integer.parseInt(employeeid));
		
		return employee;
	}

	/*
	 * filter param - ALL and LATEST
	 */
	@GetMapping(path= "/employee")
	@ResponseStatus(code=HttpStatus.OK)
	public Object fetchEmployeeDetailsQuery(@RequestParam("filter") String filter) {
		
		if(FilterId.ALL.toString().equals(filter))
		{
			List<EmployeeDetails> list = new ArrayList<>();
			list = repo.findAllByOrderByEmployeeID();
			return list;
		}
		if(FilterId.LATEST.toString().equals(filter))
		{
			Optional<EmployeeDetails> employee ;
			
			employee = repo.findTop1ByOrderByEmployeeID();
			
			return employee;
		}
		
		
		return null;
	}

	@PostMapping(value="/saveRecord")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public String createNewRecord(@RequestBody Employee newEmployee) {
		EmployeeDetails employee = new EmployeeDetails();
		employee.setEmployeeID(newEmployee.getEmployeeID());
		employee.setEmployeeName(newEmployee.getEmployeeName());
		employee.setEmployeeEmail(newEmployee.getEmployeeEmail());
		repo.save(employee);

		return "Data is saved, tha you";
	}


}
