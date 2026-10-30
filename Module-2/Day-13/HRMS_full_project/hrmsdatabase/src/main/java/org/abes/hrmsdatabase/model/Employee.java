package org.abes.hrmsdatabase.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "employees")
public class Employee {
  @Id private Long emp_id;
  @Column(nullable=false) private String emp_name;
  private String stack;
  private String designation;
  @Column(nullable=false, unique=true) private String email;
  public Employee() {}
  public Employee(Long emp_id, String emp_name, String stack, String designation, String email) {
    this.emp_id=emp_id; this.emp_name=emp_name; this.stack=stack; this.designation=designation; this.email=email;
  }
  public Long getEmp_id(){return emp_id;} public void setEmp_id(Long emp_id){this.emp_id=emp_id;}
  public String getEmp_name(){return emp_name;} public void setEmp_name(String emp_name){this.emp_name=emp_name;}
  public String getStack(){return stack;} public void setStack(String stack){this.stack=stack;}
  public String getDesignation(){return designation;} public void setDesignation(String designation){this.designation=designation;}
  public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
}
