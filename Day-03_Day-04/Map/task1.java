package Day03.Map;

import Day02.Collection.ArrayList1;

import java.util.*;
import java.util.Collection;

public class task1 {
    private int Age;
    private String Name;
    private int roll;
    private int marks;

    task1(int age, String name, int roll, int marks){
        this.Age = age;
        this.Name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public static void main(String[] args){
        task1 obj1 = new task1(20, "Tushar", 68,70);
        task1 obj2 = new task1(19 , "Vishal", 47, 72  );
        task1 obj3 = new task1(22 , "Tarun", 45, 74  );
        task1 obj4 = new task1(19 , "Smita", 49, 79  );

        ArrayList<task1> list = new ArrayList<>();

        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);

        for(task1 num : list ){
            System.out.println(num.Name);
        }

        System.out.println("Sorted order");

        Collections.sort(list,(a,b) ->{
          if(a.Age == b.Age) return a.roll - b.roll;
          return a.Age - b.Age;
        } );

        for(task1 num : list ){
            System.out.println(num.Name);
        }
    }
}
