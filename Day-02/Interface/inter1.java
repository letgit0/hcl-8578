package Day02.Interface;

interface animal {
    static void sound(){
        System.out.println("bark");
    }
}


public class inter1 implements animal {

    public static void main(String[] args){

        animal.sound();
    }


}



