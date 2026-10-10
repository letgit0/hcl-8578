package Inheritance;

public class inherit2 {
    class A {

        void name(){
            System.out.println("Day-01");
        }

    }

    class B  extends A {                   // multi level inher.....

        void age(){
            System.out.println(22);
        }

    }

    class C extends B {

        void roll(){
            System.out.println(45);
        }

    }
}
