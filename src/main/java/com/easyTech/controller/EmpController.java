package com.easyTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyTech.model.Employee;
import com.easyTech.service.EmpService;


@RestController
public class EmpController {

	
	@Autowired
	private EmpService empService;

	@PostMapping(value = "/addEmployee", consumes = "application/json", produces = "application/json")
		public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {

		Employee employee = empService.addEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	

	@PostMapping(value = "/addMultipleEmployee", consumes = "application/json", produces = "application/json")
		public ResponseEntity<List<Employee>> addMultipleEmployee(@RequestBody List<Employee> emp) {

		List<Employee> addMultipleEmployee = empService.addMultipleEmployee(emp);

		System.out.println(addMultipleEmployee);
		return new ResponseEntity<List<Employee>>(addMultipleEmployee, HttpStatus.CREATED);
	}
	

	@GetMapping(value = "/getEmpById/{empId}", produces = "application/json")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer empId) {

		Employee byId = empService.getEmployeeById(empId);

		return new ResponseEntity<Employee>(byId, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getAllEmp", produces = "application/json")
		public ResponseEntity<List<Employee>> getAllEmployee() {

		List<Employee> allEmployee = empService.getAllEmployee();

		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/login/{empId}/{empName")
		public ResponseEntity<String> loginCheck(@PathVariable Integer empId,@PathVariable String EmpName){
		Employee name = empService.findByEmpIdAndEmpName(empId, EmpName );
		if(name==null) {
			return new ResponseEntity<>("Invalid data",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Login Successfully",HttpStatus.OK);
	}

	
	@PutMapping(value = "/upall", consumes = "application/json", produces = "application/json")
		public ResponseEntity<String> updateMultipleEmployee(@RequestBody List<Employee> emp) {

		List<Employee> updateMultipleEmployee = empService.updateMultipleEmployee(emp);
		return new ResponseEntity<String>("All dta Updated", HttpStatus.OK);
	}

	
	@PutMapping(value = "/updateEmp/{empId}", consumes = "application/json", produces = "application/json")
		public ResponseEntity<String> updateEmp(@RequestBody Employee emp) {

		Employee employee = empService.updateEmployee(emp);
		return new ResponseEntity<String>(employee.getEmpId() + "updated", HttpStatus.OK);
	}

	
	@DeleteMapping(value = "/deleteId/{empId}", consumes = "application/json")
		public ResponseEntity<String> deleteById(@PathVariable Integer id) {

		empService.deleteById(id);
		return new ResponseEntity<String>(id + "Id deleted successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteAll", consumes = "application/json")
	    public ResponseEntity<String> deleteAll() {

		empService.deleteAll();
		return new ResponseEntity<>("Data deleted  successfully", HttpStatus.OK);
	}

}
