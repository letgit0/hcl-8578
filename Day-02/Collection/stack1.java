package Day02.Collection;
import java.util.*;

public class stack1 {

    public static void main(String[] args){

    Stack<Integer> st = new Stack<>();

    st.push(1);
    st.push(33);
    st.push(35);
    st.push(38);
    st.pop();
    st.pop();
        System.out.println(st.search(35));
        System.out.println(st.search(2));
    }
}
