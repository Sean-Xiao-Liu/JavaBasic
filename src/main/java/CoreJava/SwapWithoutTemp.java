package CoreJava;

public class SwapWithoutTemp {
    public static void swapString(String a,String b){
        System.out.println("Before swap: " + a + " " + b);
        a = a + b;
        b = a.substring(0, a.length() - b.length()); // take start and end index
        a = a.substring(b.length()); // take start index
        System.out.println("After : " + a + " " + b);
    }

    public static void main(String[] args) {
        String a = "Love";
        String b = "You";
        swapString(a,b);
    }
}
