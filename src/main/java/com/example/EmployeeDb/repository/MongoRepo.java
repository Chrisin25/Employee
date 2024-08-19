package com.example.EmployeeDb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeDb.models.Employee;

public interface MongoRepo extends MongoRepository<Employee,String>{
    public Employee findAllById(String id);
    
    public List<Employee> findByDesignation(String designation);

    public List<Employee> findAllByManagerId(String managerId);
    
    public List<Employee> findAllByManagerIdAndYearOfExperienceGreaterThanEqual(String id, Long yearOfExperience);

    public List<Employee> findAllByDesignationAndDepartment(String designation, String department);

    public List<Employee> findAllByDepartment(String department);

    public void deleteById(String id);

    
}