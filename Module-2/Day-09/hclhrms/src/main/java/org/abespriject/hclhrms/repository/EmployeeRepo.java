package org.abespriject.hclhrms.repository;


import org.abespriject.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {

    String addemp(Employee  emp);

    List<Employee> getEmp();

    String addEmpBulk(List<Employee> bulk);

    Employee getEmpById(long empid);

    String deleteById(long empid);

    String updateById(long emp , String updatedemail);


}
