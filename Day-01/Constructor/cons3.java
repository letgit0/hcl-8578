package Constructor;

public class cons3 {

    class parents {

        parents(){
            System.out.println("parents");
        }
    }

    class child extends parents{

        child(){
            super();                              // super call parents cons...
            System.out.println("child");

        }
    }
}
