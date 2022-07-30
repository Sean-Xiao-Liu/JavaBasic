package Algorithm;

public class Factorial { // using recursive

    private static int fact(int x) {
        if (x <= 1) {
            return 1;
        } else {
            return x * fact(x - 1);
        }
    }

    private static int fact2(int a){
        int b = a - 1;
        while (b >= 1){
            a = a * b;
            b = b - 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fact2(5));
    }
}
