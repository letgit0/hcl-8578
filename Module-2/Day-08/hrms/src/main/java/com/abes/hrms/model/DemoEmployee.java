package com.abes.hrms.model;


import com.abes.hrms.Reposotory.EmpRepImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
    public class DemoEmployee {


    @Autowired
    private EmpRepImp empRepImp;
    public int add(int a, int b){
            return a+b;
        }

//        public int add(){
//          return
//        }
        public double squareroot(){
           return   empRepImp.squareroot(2000);
        }


        public int Grt(){
            return empRepImp.grt(3,5);
        }

    }


