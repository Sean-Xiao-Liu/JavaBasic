package CoreJava;

public class BreakNestedLoop {
    public static void main(String[] args) {
        outerloop:
        for (int i=0; i < 6; i++) {
            midloop:
            for (int j=0; j < 5; j++) {
                for(int k=0;k < 5 ;k++) {
                    if (i * j * k == 6) {
                        System.out.println(i + " " + j + " " + k);
                        System.out.println("Breaking mid loop");
                        break midloop;
                    }
                    if (i * j * k == 8) {
                        System.out.println(i + " " + j + " " + k);
                        System.out.println("Breaking out loop");
                        break outerloop;
                    }
                    System.out.println(i + " " + j + " " + k);
                }

            }
        }
        System.out.println("Done");
    }
}
