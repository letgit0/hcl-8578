package Inheritance;

public class inherit3 {

    class A {

        void name(){
            System.out.println("Day-01");
        }

    }

    class B  extends A {                   //  .....

        void age(){
            System.out.println(22);
        }

    }

    class C extends A {

        void roll(){
            System.out.println(45);
        }

    }

    class D extends B {

        void num(){
            System.out.println(45);
        }

    }

    class E extends B {

        void sub(){
            System.out.println("maths");
        }

    }
}
