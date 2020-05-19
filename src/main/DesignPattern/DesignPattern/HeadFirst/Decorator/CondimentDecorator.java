package DesignPattern.HeadFirst.Decorator;

/** this is a abstract decorator of component, in other words, condiment is used to decorate beverage**/
public abstract class CondimentDecorator extends Beverage { // extends another abstract class, will not need to override the abstract method
    public abstract String getDescription();
}
