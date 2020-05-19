package DesignPattern.HeadFirst.Decorator;

/** this is a abstract component class**/
public abstract class Beverage {
    String description;

    public String getDescription() { // description with depends on the sub class
        return description;
    }
    public abstract double cost(); // detailed implementation will be achieved in sub classes
}
