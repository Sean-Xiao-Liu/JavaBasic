package CoreJava;

public class MultipleLogicalOperator {
    public static void multipleOperators(int a, int b, int c,int d,int e){
        System.out.println(a > 0 || b > 0 && c > 0 && d > 0 || e > 0);
    }

    public static void main(String[] args) {
        multipleOperators(1, 1, 1, 1,1); // true
        multipleOperators(0,1,1,1,1); // true
        multipleOperators(1,0,1,1,1); // true
        multipleOperators(1,1,0,1,1); /** true */
        multipleOperators(0,1,0,1,0); //false
        multipleOperators(1,0,0,0,1); /** true */
    }
}
