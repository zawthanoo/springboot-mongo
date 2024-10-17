package com.mutu.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mutu.mongo.models.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	//Equivalent : SELECT * FROM EMPLOYEE where name = ?
	@Query("{name : ?0}")
    public List<Employee> getByName(String name);

	//Equivalent : SELECT * FROM EMPLOYEE where name = ? and age = ?
	@Query("{name : ?0, age: ?1}")
	public List<Employee> getByNameAndAge(String name, int age);

	//Equivalent : SELECT * FROM EMPLOYEE where name = ? or id = ?
	@Query("{name : ?0},{age: ?1}")
	public List<Employee> getByNameOrId(String name, String id);
	
	//Equivalent : SELECT count(*) FROM EMPLOYEE where id = ?
	@Query(value="{department: ?0}",count=true)
	public Long getCountByDep(String department);

	//@Query(sort="{name:1}") //AES
	@Query(value="{department: ?0}", sort="{name: -1}") //DESC
	public List<Employee> getListBySort(String department);
	
	//Equivalent : SELECT NAME, DEPARTMENT FROM EMPLOYEE where id = ?
	@Query(value= "{id: ?0}", fields="{name:1, department:1}")
	public List<Employee> getSpecificFileds(String id);
	
	//Equivalent : SELECT * FROM EMPLOYEE where and age >= ?
	@Query("{age: {$gte: ?0}}")
	public List<Employee> getOlderAge(int age);
}