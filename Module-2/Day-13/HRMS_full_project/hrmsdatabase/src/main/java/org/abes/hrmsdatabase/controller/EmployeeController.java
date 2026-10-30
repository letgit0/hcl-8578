package org.abes.hrmsdatabase.controller;
import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class EmployeeController {
  private final EmployeeService employeeService;
  public EmployeeController(EmployeeService employeeService){this.employeeService=employeeService;}
  @GetMapping("/health") public Map<String,String> health(){return Map.of("status","ok","message","HRMS backend is running");}
  @GetMapping public List<Employee> getAll(){return employeeService.getAllEmployees();}
  @PostMapping public ResponseEntity<?> create(@RequestBody Employee employee){
    try { return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee)); }
    catch (IllegalArgumentException ex){return ResponseEntity.badRequest().body(Map.of("message",ex.getMessage()));}
    catch (DataIntegrityViolationException ex){return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message","Employee ID or email already exists"));}
  }
  @GetMapping("/{id}") public ResponseEntity<?> getById(@PathVariable Long id){
    Employee employee=employeeService.getEmployeeById(id);
    return employee==null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message","Employee not found")) : ResponseEntity.ok(employee);
  }
  // RequestParam example: /api/employees/verify?id=101&email=name@example.com
  @GetMapping("/verify") public ResponseEntity<?> verify(@RequestParam("id") Long id, @RequestParam("email") String email){
    Employee employee=employeeService.verifyEmployee(id,email);
    return employee==null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("verified",false,"message","Employee ID and email do not match")) : ResponseEntity.ok(Map.of("verified",true,"message","Employee verified successfully","employee",employee));
  }
  @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id){
    return employeeService.deleteEmployeeById(id) ? ResponseEntity.ok(Map.of("message","Employee deleted successfully")) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message","Employee not found"));
  }
}
