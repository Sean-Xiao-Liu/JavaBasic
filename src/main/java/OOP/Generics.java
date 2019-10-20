package OOP;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        // List is a good example of using generics
        List<String> test = new ArrayList<>();
        test.add("a");

        List<Character> test2 = new ArrayList<>();
//        test2.add(2); // provide compile time type checking, only
    }

}
