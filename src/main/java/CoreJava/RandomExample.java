package CoreJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {

        List<Integer> scoreList = new ArrayList<>();
        scoreList.add(22);
        scoreList.add(19);
        scoreList.add(18);
        scoreList.add(18);

        Iterator<Integer> it = scoreList.iterator();
        while (it.hasNext()){
            if(it.next() > 21){
                it.remove();
            }
        }


        System.out.println(scoreList);
        System.out.println(scoreList.indexOf(18));
    }
}
