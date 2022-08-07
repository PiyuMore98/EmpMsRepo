package com.easyTech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easyTech.model.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

	public Employee findByEmpIdAndEmpName(Integer id,String name);
	
	public Employee findByEmpAgeLessThanEqaul(Integer age);
}