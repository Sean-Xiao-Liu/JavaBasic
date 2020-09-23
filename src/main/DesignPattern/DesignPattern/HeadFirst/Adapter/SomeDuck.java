package DesignPattern.HeadFirst.Adapter;

public class SomeDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("This a real duck");
    }

    @Override
    public void fly() {
        System.out.println("a real duck can fly");
    }
}
