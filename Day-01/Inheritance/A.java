package Inheritance;



     public  class A {

        void name(){
            System.out.println("Day-01");
        }

    }

    class B  extends A {                   // overriding

        void name(){
            super.name();
            System.out.println("Tyagi");

        }


    }


