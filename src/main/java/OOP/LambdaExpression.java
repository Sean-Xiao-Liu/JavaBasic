package OOP;

import java.util.Arrays;

public class LambdaExpression implements LambdaInterface{
    @Override
    public void printContent(String text){
        System.out.println("override");
    }



    public static void main(String[] args) {
        LambdaInterface lambdaInterface = (text) -> System.out.println("lambda expression");
        lambdaInterface.printContent("text");

        LambdaInterface lambdaInterface2 = new LambdaExpression();
        lambdaInterface2.printContent("test");


    }
}

interface LambdaInterface{
    void printContent(String text);

    static void printText(String text){
        System.out.println(text);
    }
}
