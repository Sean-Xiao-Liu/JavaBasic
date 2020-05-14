package DesignPattern.HeadFirst.Stratey;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckVersionThree test = new MallardDuck();
        test.performFly();
        test.performQuack();
        test.swim();
        test.display();

        System.out.println("then set behaviors");
        test.setFlyBehavior(new FlyNoWay());
        test.setQuackBehavior(new Squeak());
        test.performFly();
        test.performQuack();
        test.swim();
        test.display();

        /** strategy pattern defines a family of algorithms, encapsulate each one and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it**/
    }
}
