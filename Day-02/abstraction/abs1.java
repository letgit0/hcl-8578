
package Day02.abstraction;

public class abs1 {

    abstract class A {
        abstract void name();
        abstract int age();
    }

    class B extends A {


        void name() {
            System.out.println("Tushar");
        }


        int age() {
            return 23;
        }
    }
}