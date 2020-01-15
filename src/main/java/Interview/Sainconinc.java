package Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sainconinc {

    public static void test(){
        List<String> list1 = new ArrayList<>();
        list1.add("foo");
        List<String> list2 = list1;
        List<String> list3 = new ArrayList<>(list2);

        list1.clear();
        list2.add("bbb");
        list3.add("ccc");


        list3.removeAll(new ArrayList<String>(Collections.singleton("ccc")));

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);


    }


    public static void main(String[] args) {
        test();
    }
}
