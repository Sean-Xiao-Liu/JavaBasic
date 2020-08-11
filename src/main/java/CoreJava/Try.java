package CoreJava;


import java.util.ArrayList;
import java.util.List;

public class Try extends Super{
    public void show(){
        System.out.println("sub");
    }

    public void anotherShow(){
        System.out.println("another sub");
    }

    public static void main(String[] args) {
        Super test = new Try();


    }
}

class Super{
    public void show(){
        System.out.println("super");
    }
}