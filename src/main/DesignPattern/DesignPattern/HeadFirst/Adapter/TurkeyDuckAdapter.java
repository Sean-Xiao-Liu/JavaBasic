package DesignPattern.HeadFirst.Adapter;

public class TurkeyDuckAdapter implements Duck {

    Turkey turkey;

    public TurkeyDuckAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble(); // use the turkey method to response the call of duck method
    }

    @Override
    public void fly() {
        turkey.fly(); // use the method to response the call of duck method
    }
}
