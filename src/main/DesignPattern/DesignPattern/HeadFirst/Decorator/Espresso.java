package DesignPattern.HeadFirst.Decorator;

/** this is concrete component, which is a implementation of Beverage**/
public class Espresso extends Beverage {

    public Espresso(){
        description = "This is Espresso"; // the variable description is defined in the abstract class Beverage
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
