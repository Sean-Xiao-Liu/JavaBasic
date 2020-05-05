package DesignPattern.HeadFirst.Stratey;

/**program to interface, not to implementation**/
public abstract class DuckVersionThree {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;
    public void swim(){
        System.out.println("all ducks swim!");
    }

    public void display(){

    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    //add quack behavior setter
    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }

    //add fly behavior
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
}

interface FlyBehavior{
    void fly();
}

interface QuackBehavior{
    void quack();
}

/** write multiple classes to implements the quack method mentioned in the QuackBehavior interface**/
class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("real quacking");
    }
}

class Squeak implements  QuackBehavior{

    @Override
    public void quack() {
        System.out.println("actually squeaking");
    }
}

class MuteQuack implements  QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Cannot do anything");
    }
}

/** write multiple classes to implements the fly method mentioned in the FlyBehavior interface**/
class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("flying with wings");
    }
}

class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("cannot fly");
    }
}

/** implementation of Duck class**/
class MallardDuck extends DuckVersionThree{
    // implement the behaviors in the constructor
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a Mallard Duck!");
    }
}