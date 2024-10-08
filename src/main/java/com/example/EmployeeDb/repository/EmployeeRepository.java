package com.example.EmployeeDb.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.EmployeeDb.models.Employee;

@Repository
public interface EmployeeRepository {

    public Employee findById(String id);

    public List<Employee> findByDesignation(String designation);

    public List<Employee> findAllByManagerId(String id);
    
    public List<Employee> findAllByManagerIdAndYearOfExperienceGreaterThanEqual(String id, Long yearOfExperience);

    public List<Employee> findAllByDesignationAndDepartment(String designation, String department);

    public List<Employee> findAllByDepartment(String department);

    public void deleteById(String id);

    public void save(Employee e);
}
