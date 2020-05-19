package DesignPattern.HeadFirst.Decorator;

/** this is a concrete decorator, which extends CondimentDecorator, which extends Beverage**/
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", with Mocha";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}
