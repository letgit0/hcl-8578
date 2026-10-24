package org.abespriject.hclhrms.repository;

import org.abespriject.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class EmpRepoImp implements EmployeeRepo{

    List<Employee>  emplist = new ArrayList<>();

    @Override
    public String addemp(Employee emp) {
        emplist.add(emp);
        return "Employee Added Successfully";
    }

    @Override
    public List<Employee> getEmp() {
        if(emplist.isEmpty()) return null;
        return emplist;
    }

    @Override
    public String addEmpBulk(List<Employee> bulkemp) {


         List<Employee> Emplist =   List.of(new Employee(890,"Ram","tester","java","Ram@gmail.com") ,
                 new Employee(890,"Ram","tester","java","Ram@gmail.com"));

        return "";
    }

    @Override
    public Employee getEmpById(long empid) {
        return emplist.stream().filter(e -> e.getEmp_id() ==empid).findFirst().orElse(null);

    }

    @Override
    public String deleteById(long empid) {
         Employee emp = getEmpById(empid);

         if(emp != null){
             Iterator<Employee> it = emplist.iterator();
             while (it.hasNext()){
                 Employee em = it.next();
                 if(em.getEmp_id() == empid){
                     it.remove();
                 }
             }
             return "Employee removed";
         }
         return "employee not found";
    }

    @Override
    public String updateById(long emp, String updatedemail) {

         Employee existingEmp =    getEmpById(emp);

         if(existingEmp == null){
             return "not avalaible";
         }

        existingEmp.setEmail(updatedemail);
         return "Employ updated";

    }
}
