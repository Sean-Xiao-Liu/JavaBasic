package DesignPattern.HeadFirst.Adapter;

public class SomeTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("This a turkey actually");
    }

    @Override
    public void fly() {
        System.out.println("a turkey can't really fly");
    }
}
