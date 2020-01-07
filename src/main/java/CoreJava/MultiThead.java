package CoreJava;

import static CoreJava.ThreadColor.*;

public class MultiThead extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(2000); // let the thread pause for 2 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MultiThead m1 = new MultiThead();
        MultiThead m2 = new MultiThead();
        MultiThead m3 = new MultiThead();
        MultiThead m4 = new MultiThead();
        m3.setPriority(10);
        m4.setPriority(1);
        System.out.println(ANSI_GREEN+"Thread m1 begin");
        m1.start();
//        m1.start(); // After starting a thread, it can never be started again. If you does so, an IllegalThreadStateException is thrown. In such case, thread will run once but for second time, it will throw exception.
        try{
            m1.join(5000);// means m2 m3 m4 will start 5 seconds after m1 start
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(ANSI_BLUE+"Thread m2 begin");
        m2.start();
        System.out.println(ANSI_RED+"Thread m3 begin");
        m3.start();
        System.out.println(ANSI_PURPLE+"Thread m4 begin");
        m4.start();

    }
}

class MultiThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("override the run() method when extents the Thread class");
    }

    public static void main(String[] args) {
        MultiThread2 multiThread2 = new MultiThread2();
        Thread thread = new Thread(multiThread2); // take instance as argument when create a new thread
        thread.start();
        multiThread2.run();
    }
}