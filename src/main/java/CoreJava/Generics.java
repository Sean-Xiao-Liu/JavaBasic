package CoreJava;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        // List is a good example of using generics
        List<String> test = new ArrayList<>();
        test.add("a");

        List<Character> test2 = new ArrayList<>();
        test2.add('b'); // provide compile time type checking, only

        printList(test);
        printList(test2);
    }

}
