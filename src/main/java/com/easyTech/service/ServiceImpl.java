package com.easyTech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyTech.model.Employee;
import com.easyTech.repository.EmpRepo;

@Service
public class ServiceImpl implements EmpService{

	@Autowired
	private EmpRepo er;

	
	@Override
	public Employee addEmployee(Employee emp) {
		Employee employee = er.save(emp);
		return employee;
	}

	@Override
	public List<Employee> addMultipleEmployee(List<Employee> employee) {
		List<Employee> saveAll = er.saveAll(employee);
		for (Employee emp : saveAll) {
			System.out.println(emp);
		}
		return saveAll;
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Employee findById = er.findById(empId).get();
		return findById;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = er.findAll();
		for (Employee emp : findAll) {
			System.out.println(emp);
		}
		return findAll;
	}

	@Override
	public Employee findByEmpAgeLessThanEqaul(Integer age) {
		Employee employee = er.findByEmpAgeLessThanEqaul(age);
		return employee;
	}

	
	@Override
	public Employee findByEmpIdAndEmpName(Integer id, String name) {
		Employee findByEmpIdAndEmpName = er.findByEmpIdAndEmpName(id, name);
		return findByEmpIdAndEmpName;
	}


	@Override
	public Employee updateEmployee(Employee emp) {
		Employee save = er.save(emp);
		return save;
	}

	@Override
	public List<Employee> updateMultipleEmployee(List<Employee> emp) {
		List<Employee> saveAll = er.saveAll(emp);
		for (Employee emp1 : saveAll) {
			System.out.println(emp1);
		}
		return saveAll;
	}

	@Override
	public void deleteById(Integer empId) {
		er.deleteById(empId);
	}

	@Override
	public void deleteAll() {
		er.deleteAll();
	}

	
	
}
