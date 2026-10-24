package org.abespriject.hclhrms;


import org.abespriject.hclhrms.entity.Employee;
import org.abespriject.hclhrms.repository.EmpRepoImp;
import org.abespriject.hclhrms.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmpRepoImp empRepoImp;
    public String addEmp(){
        Employee emp1 = new Employee(2001,"Tushar","FSD","Java", "tushar1605@gmail.com");
        return  empRepoImp.addemp(emp1);
    }

    public List<Employee> getEmp(){
        return empRepoImp.getEmp();
    }


    public Employee getEmpById(){
        return empRepoImp.getEmpById(2001);
    }

    public String updateById(){
        return empRepoImp.updateById(2001,"tushar@gmail.com");
    }

    public String deleteById(){
        return empRepoImp.deleteById(2022);
    }
}
