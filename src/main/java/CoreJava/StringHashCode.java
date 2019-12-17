package CoreJava;

public class StringHashCode {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");


        System.out.println(s1=="abc");// return true
        System.out.println(s2=="abc");// return false

        s1 = "abc".concat("def");
        System.out.println(s1);
    }
}
