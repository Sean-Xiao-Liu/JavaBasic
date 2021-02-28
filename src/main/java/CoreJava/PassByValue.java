package CoreJava;

import java.util.List;

public class PassByValue {

    static void add(int x){
        x = x+5;
    }

    public static void main(String[] args) {
        int x= 10;
        add(x);
        System.out.println(x);

        String s1 = "This is a String";
        String s2 = s1;
        s1 = "Change the original String";
        System.out.println(s2);


    }
}


