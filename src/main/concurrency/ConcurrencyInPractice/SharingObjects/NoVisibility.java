package ConcurrencyInPractice.SharingObjects;


/**
 * example of variable sharing without synchronization
 * **/
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReadThread extends Thread{ // a nested class, a class defined within class
        public void run(){
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {

        number = 1;
        ready = true;
        new ReadThread().start(); // nothing printed
        System.out.println(1 == 2);
    }
}

