/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech.getarrays.employeemanager.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

/**
 *
 * @author tnl04
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    public void deleteEmployeeById(Long id);

    public Optional<Employee> findEmployeeById(Long id);
      
}
