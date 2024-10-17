package com.mutu.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.mongo.models.Employee;
import com.mutu.mongo.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Optional<Employee> updateEmployee(Employee employee) {
        if(!employeeRepository.existsById(employee.getId())) {
            return Optional.empty();
        }
        return Optional.of(employeeRepository.save(employee));
    }
    
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
    
	public List<Employee> getByName(String name) {
		return employeeRepository.getByName(name);
	}

	public List<Employee> getByNameAndAge(String name, int age) {
		return employeeRepository.getByNameAndAge(name, age);
	}

	public List<Employee> getByNameOrId(String name, String id) {
		return employeeRepository.getByNameOrId(name, id);
	}
	
	public Long getCountByDep(String department) {
		return employeeRepository.getCountByDep(department);
	}

	public List<Employee> getListBySort(String department) {
		return employeeRepository.getListBySort(department);
	}
	
	public List<Employee> getSpecificFileds(String id) {
		return employeeRepository.getSpecificFileds(id);
	}
	
	public List<Employee> getOlderAge(int age) {
		return employeeRepository.getOlderAge(age);
	}
}