package Multithreading;

public class threadCreation {
    public static void main(String[] args) throws InterruptedException {

        /**
            thread object is empty by default,
            runnable interface is a functional interface and contains a method run()
         */
        Thread thread = new Thread(() -> { // run() has no argument
            System.out.println("The name of this thread is " + Thread.currentThread().getName());
            System.out.println("The priority of this thread is " + Thread.currentThread().getPriority());
            throw new RuntimeException("internal exception");
        });



        thread.setName("custom thread"); // overwrite the default thread name

        thread.setPriority(Thread.MAX_PRIORITY); //assign the highest priority to the thread, which is 10

        thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println("a uncaught exception " + t.getName() + " is " + e.getMessage());
        });

        System.out.println("In thread " + Thread.currentThread().getName() + " before starting a new thread"); // this thread main run 1st
        thread.start(); // this thread run 3rd
        System.out.println("In thread " + Thread.currentThread().getName() + " after starting a new thread"); // this thread main run 2nd




//        Thread.sleep(3000); // will throws InterruptedException


    }
}
