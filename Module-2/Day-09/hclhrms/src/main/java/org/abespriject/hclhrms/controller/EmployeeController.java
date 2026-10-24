package org.abespriject.hclhrms.controller;


import org.abespriject.hclhrms.EmployeeServiceImp;
import org.abespriject.hclhrms.entity.Employee;
import org.abespriject.hclhrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
   private EmployeeServiceImp employeeServiceImp;


    @GetMapping("/")
    public String welcomeMsg(){
        return "Welcome to Abes Hrms";
    }



   @GetMapping("/addemp")
   public String addnewEmployee(){
       return employeeServiceImp.addEmp();
   }

   @GetMapping("/getemp")
    public  List<Employee> getEmp(){
        return employeeServiceImp.getEmp();
   }

   @GetMapping("/getempbyid")
    public Employee  getEmpById(){
        return employeeServiceImp.getEmpById();
   }

   @GetMapping("/deletebyid")
    public String deleteById(){
        return employeeServiceImp.deleteById();
   }


   @GetMapping("/updatbyid")
    public String updateById(){
        return employeeServiceImp.updateById();
   }
}
