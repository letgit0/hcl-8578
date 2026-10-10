package Day02.Collection;
import java.util.*;

public class ArrayList1 {

    public static void main(String[] args){

        LinkedList<String> list = new LinkedList<>();

        list.add("mango");
        list.add("murari");
        list.add("apple");
        list.add("patato");
        list.add("orange");

        int index = list.indexOf("apple");

        list.add(index +1,"Gauva");

        System.out.println(list);
    }
}
