/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech.getarrays.employeemanager.service;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepository;

/**
 *
 * @author tnl04
 */
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepo;
    
    @Autowired 
    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;      
    }
    
    public  Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    
    public  void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
    
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id "+id+" was not found"));
    }

    
}
