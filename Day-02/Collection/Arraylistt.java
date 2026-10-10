package Day02.Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylistt {

    public static void main(String[] args ){

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("enter the element");
        for(int i =0;i<10;i++){
            arr[i] = sc.nextInt();
        }


        ArrayList<Integer> num = new ArrayList<>();

        for(int i : arr){
            num.add(i);
        }

        System.out.println("Give index value ");
        int a = sc.nextInt() , b = sc.nextInt();

        num.set(a,34);
        num.set(b,31);

        System.out.println("the value change by you");
        System.out.println(num.get(a));
        System.out.println(num.get(b));

        System.out.println(num.toString());


        System.out.println("emter remove element index");
        int c = sc.nextInt();
        num.remove(c);

    }
}
