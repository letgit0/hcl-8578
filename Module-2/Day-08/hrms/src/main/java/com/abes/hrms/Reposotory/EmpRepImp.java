package com.abes.hrms.Reposotory;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
@Repository
public class EmpRepImp implements EmpRepo{
    @Override
    public double squareroot(double d) {
        double result = Math.sqrt(d);
        return result;
    }

    @Override
    public String empData() {
        return "My name is ";
    }

    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public int grt(int a, int b) {
        if(a>b){
            return a;
        }
        return b;
    }


}
