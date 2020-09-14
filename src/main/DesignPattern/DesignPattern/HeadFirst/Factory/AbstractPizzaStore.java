package DesignPattern.HeadFirst.Factory;


/**
    all the pizza class should extend this abstract class
 */
public abstract class AbstractPizzaStore {

    /**
     * abstract class can have both abstract and non-abstract method
     * so add abstract modifier to the method
     * */
    public abstract Pizza orderPizza(String type);
}
