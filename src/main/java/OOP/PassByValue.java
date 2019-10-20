package OOP;

public class PassByValue {

    static void add(int x){
        x = x+5;
    }

    public static void main(String[] args) {
        int x= 10;
        add(x);
        System.out.println(x);
    }
}


