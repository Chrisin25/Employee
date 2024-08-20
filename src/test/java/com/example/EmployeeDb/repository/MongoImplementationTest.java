package com.example.EmployeeDb.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EmployeeDb.models.Employee;
@ExtendWith(MockitoExtension.class)
public class MongoImplementationTest {
    @Mock
    private MongoRepo mongoRepo;

    @InjectMocks
    private MongoImplementation sqlImplementation;

    @Test
    public void testFindById() {
        Employee employee = new Employee("1" , "John Doe", "Account Manager","john@aspire.com","BA","1234567890","Kochi","0",OffsetDateTime.now());
        when(mongoRepo.findAllById("1")).thenReturn(employee);

        Employee result = sqlImplementation.findById("1");
        assertEquals(employee, result);
    }

    @Test
    public void testFindByDesignation() {
        List<Employee> employees = Arrays.asList(new Employee("1" , "John Doe", "Account Manager","john@aspire.com","BA","1234567890","Kochi","0",OffsetDateTime.now()));
        when(mongoRepo.findByDesignation("Developer")).thenReturn(employees);
        List<Employee> result = sqlImplementation.findByDesignation("Developer");
        assertEquals(employees, result);
    }

    @Test
    public void testFindAllByManagerId() {
        List<Employee> employees = Arrays.asList(new Employee("1" , "John Doe", "Account Manager","john@aspire.com","BA","1234567890","Kochi","0",OffsetDateTime.now()));
        when(mongoRepo.findAllByManagerId("0")).thenReturn(employees);

        List<Employee> result = sqlImplementation.findAllByManagerId("0");
        assertEquals(employees, result);
    }
    @Test
    public void testFindAllByManagerIdAndYearOfExperienceGreaterThanEqual() {
        List<Employee> employees = Arrays.asList(new Employee("1" , "John Doe", "Account Manager","john@aspire.com","BA","1234567890","Kochi","0",OffsetDateTime.now()));
        when(mongoRepo.findAllByManagerIdAndYearOfExperienceGreaterThanEqual("0", 0L)).thenReturn(employees);

        List<Employee> result = sqlImplementation.findAllByManagerIdAndYearOfExperienceGreaterThanEqual("0", 0L);
        assertEquals(employees, result);
    }

    @Test
    public void testFindAllByDesignationAndDepartment() {
        List<Employee> employees = Arrays.asList(new Employee("1" , "John Doe", "Account Manager","john@aspire.com","BA","1234567890","Kochi","0",OffsetDateTime.now()));
        when(mongoRepo.findAllByDesignationAndDepartment("Account Manager", "BA")).thenReturn(employees);

        List<Employee> result = sqlImplementation.findAllByDesignationAndDepartment("Account Manager", "BA");
        assertEquals(employees, result);
    }

    @Test
    public void testFindAllByDepartment() {
        List<Employee> employees = Arrays.asList(new Employee("1" , "John Doe", "Account Manager","john@aspire.com","BA","1234567890","Kochi","0",OffsetDateTime.now()));
        when(mongoRepo.findAllByDepartment("BA")).thenReturn(employees);

        List<Employee> result = sqlImplementation.findAllByDepartment("BA");
        assertEquals(employees, result);
    }

    @Test
    public void testDeleteById() {

        doNothing().when(mongoRepo).deleteById("1");

        sqlImplementation.deleteById("1");
        verify(mongoRepo, times(1)).deleteById("1");
    }

    @Test
    public void testSave() {
        Employee employee = new Employee("1" , "John Doe", "Account Manager","john@aspire.com","BA","1234567890","Kochi","0",OffsetDateTime.now());

        sqlImplementation.save(employee);
        verify(mongoRepo, times(1)).save(employee);
    }
}

