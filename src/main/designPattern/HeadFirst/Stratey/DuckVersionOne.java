package DesignPattern.HeadFirst.Stratey;

public class DuckVersionOne {
    public void quack(){

    }

    public void swim(){

    }

    public void display(){

    }

    /** add method into super class directly force all sub-class to inherits the method even if they have nothing to do with it
     * also it has multiple cons:
     * 1. code is duplicated in subclasses
     * 2. runtime behavior changes are difficult
     * 3. change in superclass will effect all subclass, which violate the SOLID design principle
     * **/
    public void fly(){

    }
}

class RedHeadDuck extends DuckVersionOne{

}

class RubberDuck extends DuckVersionOne{
    @Override
    public void fly() {
        // rubber duck cannot fly
    }

    @Override
    public void quack() {
        // rubber duck cannot quack
    }
}