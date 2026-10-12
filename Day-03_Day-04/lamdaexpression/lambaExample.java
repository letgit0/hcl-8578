package Day03.lamdaexpression;

import java.util.HashMap;
import java.util.Map;

public class lambaExample {
    public static void main(String[] args){
        Map<String,Integer> map =  new HashMap<>();
        map.put("tushar",2);
        map.put("smita",3);
        map.put("tamanna",4);
        map.put("yash",5);
        map.put("murari",6);
        System.out.println(map);
        System.out.println("Ravi's marks: " + map.get("Ravi"));
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }
    }


