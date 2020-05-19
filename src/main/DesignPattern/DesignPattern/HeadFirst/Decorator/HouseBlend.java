package DesignPattern.HeadFirst.Decorator;

/** this is another concrete component, which is a implementation of Beverage**/
public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "This is HouseBlend"; // the variable description is defined in the abstract class Beverage
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
