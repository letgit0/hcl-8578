package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public String createEmployee(Employee employee) {

        employeeRepo.save(employee);

        return "Employee is added successfully";
    }

    public Employee getEmployeeById(Long id) {

        return employeeRepo.findById(id).orElse(null);
    }

    public String deleteEmployeeById(Long id) {

        if (!employeeRepo.existsById(id)) {
            return "Employee with id " + id + " not found";
        }

        employeeRepo.deleteById(id);

        return "Employee deleted successfully";
    }

}