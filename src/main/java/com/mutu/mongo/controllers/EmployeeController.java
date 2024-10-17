package com.mutu.mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutu.mongo.models.Response;
import com.mutu.mongo.models.Employee;
import com.mutu.mongo.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/list")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response(id, "Deleted!"));
    }
    
    
    @GetMapping("/getByName/{name}")
	public ResponseEntity<List<Employee>> getByName(@PathVariable String name) {
		List<Employee> result = employeeService.getByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
    
    @GetMapping("/getByNameAndAge/{name}/{age}")
	public ResponseEntity<List<Employee>> getByNameAndAge(@PathVariable String name, @PathVariable int age) {
    	List<Employee> result = employeeService.getByNameAndAge(name, age);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
    
    @GetMapping("/getByNameOrId/{name}/{id}")
	public ResponseEntity<List<Employee>> getByNameOrId(@PathVariable String name, @PathVariable String id) {
    	List<Employee> result = employeeService.getByNameOrId(name, id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
    @GetMapping("/getCountByDep/{department}")
	public  ResponseEntity<Long> getCountByDep(@PathVariable String department) {
    	Long result = employeeService.getCountByDep(department);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
    
    @GetMapping("/getListBySort/{department}")
	public ResponseEntity<List<Employee>> getListBySort(@PathVariable String department) {
    	List<Employee> result = employeeService.getListBySort(department);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
    @GetMapping("/getSpecificFileds/{id}")
	public ResponseEntity<List<Employee>> getSpecificFileds(@PathVariable String id) {
    	List<Employee> result = employeeService.getSpecificFileds(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
    @GetMapping("/getOlderAge/{age}")
	public ResponseEntity<List<Employee>> getOlderAge(@PathVariable int age) {
    	List<Employee> result = employeeService.getOlderAge(age);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}

