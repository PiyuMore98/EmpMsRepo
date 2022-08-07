package com.easyTech.service;

import java.util.List;

import com.easyTech.model.Employee;

public interface EmpService {

	public Employee addEmployee(Employee emp);

	public List<Employee> addMultipleEmployee(List<Employee> employee);

	public Employee getEmployeeById(Integer empId);

	public List<Employee> getAllEmployee();

	public Employee findByEmpAgeLessThanEqaul(Integer age);

	public Employee findByEmpIdAndEmpName(Integer id,String name);
	
	public Employee updateEmployee(Employee emp);

	public List<Employee> updateMultipleEmployee(List<Employee> emp);

	public void deleteById(Integer empId);

	public void deleteAll();
}
