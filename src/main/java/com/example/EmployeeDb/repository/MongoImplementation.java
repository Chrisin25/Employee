package com.example.EmployeeDb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.EmployeeDb.models.Employee;

@Repository
@Component
public class MongoImplementation implements EmployeeRepository{
    
    @Autowired
    MongoRepo mongoRepo;
    
    @Override
    public Employee findById(String id)
    {
        return mongoRepo.findAllById(id);
    }
    @Override
    public List<Employee> findByDesignation(String designation)
    {
        return mongoRepo.findByDesignation(designation);
    }
    @Override
    public List<Employee> findAllByManagerId(String managerId)
    {
        return mongoRepo.findAllByManagerId(managerId);
    }
    @Override
    public List<Employee> findAllByManagerIdAndYearOfExperienceGreaterThanEqual(String id, Long yearOfExperience)
    {
        return mongoRepo.findAllByManagerIdAndYearOfExperienceGreaterThanEqual(id,yearOfExperience);
    }
    @Override
    public List<Employee> findAllByDesignationAndDepartment(String designation, String department){
        return mongoRepo.findAllByDesignationAndDepartment(designation,department);
    }
    @Override
    public List<Employee> findAllByDepartment(String department){
        return mongoRepo.findAllByDepartment(department);
    }
    @Override
    public void deleteById(String id){
        mongoRepo.deleteById(id);
    }
    public void save(Employee e){
        mongoRepo.save(e);
    }
}