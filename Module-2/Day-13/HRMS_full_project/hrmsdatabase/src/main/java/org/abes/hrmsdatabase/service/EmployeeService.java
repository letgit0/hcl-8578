
        package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepo;

  public EmployeeService(EmployeeRepository employeeRepo) {
    this.employeeRepo = employeeRepo;
  }

  // Create a new employee
  @Transactional
  public Employee createEmployee(Employee employee) {

    if (employee == null) {
      throw new IllegalArgumentException(
              "Employee data is required"
      );
    }

    if (employee.getEmp_id() == null
            || employee.getEmp_id() <= 0) {
      throw new IllegalArgumentException(
              "Employee ID must be a positive number"
      );
    }

    if (blank(employee.getEmp_name())) {
      throw new IllegalArgumentException(
              "Employee name is required"
      );
    }

    if (blank(employee.getEmail())) {
      throw new IllegalArgumentException(
              "Email is required"
      );
    }

    // Validate email format
    if (!employee.getEmail().matches(
            "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
      throw new IllegalArgumentException(
              "Enter a valid email address"
      );
    }

    // Check whether employee ID already exists
    if (employeeRepo.existsById(employee.getEmp_id())) {
      throw new IllegalArgumentException(
              "Employee ID already exists"
      );
    }

    // Check whether email already exists
    if (employeeRepo.existsByEmailIgnoreCase(
            employee.getEmail().trim())) {
      throw new IllegalArgumentException(
              "Email already exists"
      );
    }

    // Remove unnecessary spaces
    employee.setEmp_name(employee.getEmp_name().trim());
    employee.setEmail(employee.getEmail().trim());

    // Save employee in database
    return employeeRepo.save(employee);
  }

  // Get all employees
  public List<Employee> getAllEmployees() {
    return employeeRepo.findAll();
  }

  // Get employee by ID
  public Employee getEmployeeById(Long id) {

    if (id == null || id <= 0) {
      return null;
    }

    return employeeRepo.findById(id).orElse(null);
  }

  // Verify employee using ID and email
  public Employee verifyEmployee(Long id, String email) {

    if (id == null || id <= 0 || blank(email)) {
      return null;
    }

    Employee employee = employeeRepo
            .findById(id)
            .orElse(null);

    if (employee != null
            && employee.getEmail() != null
            && employee.getEmail()
            .equalsIgnoreCase(email.trim())) {
      return employee;
    }

    return null;
  }

  // Delete employee by ID
  @Transactional
  public boolean deleteEmployeeById(Long id) {

    if (id == null || !employeeRepo.existsById(id)) {
      return false;
    }

    employeeRepo.deleteById(id);

    return true;
  }

  // Check whether a string is null or empty
  private boolean blank(String value) {
    return value == null || value.trim().isEmpty();
  }
}
