package CoreJava;

import java.util.HashMap;
import java.util.Map;

public class LambdaExpression implements LambdaInterface{
    @Override
    public void printContent(String text){
        System.out.println("override");
    }



    public static void main(String[] args) {
        LambdaInterface lambdaInterface = (text) -> System.out.println("lambda expression");
        lambdaInterface.printContent("text");


        LambdaInterface lambdaInterface2 = new LambdaExpression();
        LambdaInterface.printText("test");

        //forEach
        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");

        namesMap.forEach((key, value) -> System.out.println(key + " " + value));
    }
}


interface LambdaInterface{
    void printContent(String text); // The interface is still functional interface as long as it has only one abstract method

    static void printText(String text){
        System.out.println(text);
    }

}

