package Interview;

public class Sulzer1 {
    public static int solution(int N) {
        // write your code in Java SE 8
        int temp = 1;
        if( N < 10) return 0;

        while(N/10 !=0 ){
            temp = temp*10;
            N = N/10;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(solution(900000000));
    }
}
