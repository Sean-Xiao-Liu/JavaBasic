package CoreJava;

import java.util.*;

public class RemoveFromList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");

        /*** method 1 to delete all b(s) from the list ***/
//        while(list.contains("b")){
//            list.remove("b");
//        }

        /*** method 2 use iterator to delete all b(s) from the list ***/
//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            String s = it.next();
//            if(s.equals("b")) it.remove();
//        }

        /*** method 3 use stream to delete all b(s) from the list ***/
//
//        List<String> newList = list.stream().filter(e -> !e.equals("b")).collect(Collectors.toList());
//
//        System.out.println(newList);

        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",1);
        map.put("c",2);
        map.put("d",3);



        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<String,Integer> entry = it.next();
            if(entry.getValue() == 1) it.remove();
            if(entry.getKey() == "c") it.remove();
        }

        System.out.println(map.toString());
    }
}
