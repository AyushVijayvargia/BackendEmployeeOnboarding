package com.org.employees.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.employees.entity.EmployeeDetails;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeDetails,Integer>{

	
	Optional<EmployeeDetails> findByEmployeeID(@Param("employeeID") int employeeID);
	
	List<EmployeeDetails> findAllByOrderByEmployeeID();
	
	Optional<EmployeeDetails> findTop1ByOrderByEmployeeID();


}
