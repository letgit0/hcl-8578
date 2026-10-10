package Constructor;

import OOPS.A;

public class cons2 {
    private int a ;
    private String b ;



    public cons2(int age){
        a = age;                                     // constructor overloading
    }

    public cons2(int age, String name){
        a = age;                                      // constructor overloading
        b = name;
    }

    public static void main(String[] args){
        A num = new A();

        cons2 raj = new cons2(2,"raj");      // constructor overloading

        cons2 bhim =  new cons2(2);

    }
}
