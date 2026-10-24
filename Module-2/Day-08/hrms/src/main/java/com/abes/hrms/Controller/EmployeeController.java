package com.abes.hrms.Controller;


import com.abes.hrms.model.DemoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private DemoEmployee demoEmployee;

    @GetMapping("/")
    public String welcome(){
        return "<h2 style='color:red'>  Welcome to HRMS Application!</h2>";
    }

    @GetMapping("/add")
    public int sum(){
        System.out.println("inside controller point /add");
        int result = demoEmployee.add(20,40);
        return result;
    }

    @GetMapping("/sqrt")
    public double getSquareRoot(){
        return demoEmployee.squareroot();
    }


}

